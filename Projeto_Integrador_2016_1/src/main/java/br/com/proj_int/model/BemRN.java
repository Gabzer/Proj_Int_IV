package br.com.proj_int.model;

import java.util.List;

import br.com.proj_int.util.DAOFactory;

public class BemRN {
	
	BemDAO bemDAO = new BemDAO();
	Bem b;
	
	public BemRN(){
		this.bemDAO = DAOFactory.criaBemDAO();
	}
	
	public List<Bem> listar(Bem bem) {
		List<Bem> lsBens = null;
		lsBens = this.bemDAO.selectAll();
		return lsBens;
	}
	
	public Bem calcular(Bem bem){
		b = bemDAO.selectById(bem);
		
		//b.setNome(bem.getNome());
		//b.setVd_util(bem.getVd_util());
		b.setTurno(bem.getTurno());
		b.setDataAquisicao(bem.getDataAquisicao());
		b.setDataReferencia(bem.getDataReferencia());
		b.setCb(bem.getCb());
		//b.setVr(bem.getVr());
		b.setVv(bem.getVv());
		
		
		//////////////////////////calculo do tempo (N)//////////////////////////
		////////////////////////////////////////////////////////////////////////
		////anos
		int anos = 0;
		double tempo = 0.0;
		System.out.println(b.getId() + b.getNome() + b.getVd_util() + " " + b.getVr() + " " + b.getDataAquisicao() + " aquiRN");
		int ano1 = Integer.parseInt(b.getDataAquisicao().substring(6, 10));
		int ano2 = Integer.parseInt(b.getDataReferencia().substring(6, 10));
		anos = ano2 - ano1 - 1;
		
		////mesesAquisição
		int dia1 = Integer.parseInt(b.getDataAquisicao().substring(0,2));
		int mes1 = 0;
		if(dia1 < 16){
			mes1 = Integer.parseInt(b.getDataAquisicao().substring(3, 5));
			mes1 = 12 - mes1;
		} else {
			mes1 = Integer.parseInt(b.getDataAquisicao().substring(3, 5));
			mes1 = 11 - mes1;
		}////
		
		////mesesReferência
		int dia2 = Integer.parseInt(b.getDataReferencia().substring(0,2));
		int mes2 = 0;
		if(dia2 < 16){
			mes2 = Integer.parseInt(b.getDataReferencia().substring(3, 5));
			mes2 = 12 - mes2;
		} else {
			mes2 = Integer.parseInt(b.getDataReferencia().substring(3, 5));
			mes2 = 11 - mes2;
		}////
		
		anos = anos * 12;
		tempo = anos + mes1 + mes2;
		b.setN(tempo);
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		
		///////////////////////////Valor residual (VR)///////////////////////////
		/////////////////////////////////////////////////////////////////////////
		double vr = 0.0;
		vr = b.getVr() / 100;
		vr = b.getCb() * vr;
		b.setVr(vr);
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		
		//////////////////////////Taxa anual (I)/////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		double i = 0.0;
		i = b.getTurno() / b.getVd_util();
		i = i / 100;
		b.setI(i);
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		
		////////---DA---///////
		double da = 0.0;
		da = (((b.getCb() - b.getVr()) * b.getI()) / 12) * b.getN();
		b.setDa(da);
		///////////////////////
		
		////////---VC---///////
		double vc = 0.0;
		vc = b.getCb() - b.getDa();
		b.setVc(vc);
		///////////////////////
		
		///////---G/P---///////
		double g_p = 0.0;
		g_p = b.getVv() - b.getVc();
		b.setG_p(g_p);
		///////////////////////
		System.out.println(b);
		
		return b;		
	}

}
