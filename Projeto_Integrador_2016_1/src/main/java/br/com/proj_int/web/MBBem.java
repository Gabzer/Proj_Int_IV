package br.com.proj_int.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.proj_int.model.Bem;
import br.com.proj_int.model.BemRN;

@ManagedBean (name = "mbbem")
@SessionScoped
public class MBBem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Bem bem = new Bem();
	Bem bem2 = null;
	private List<Bem> lsBens = null;

	public List<Bem> getActionListar() {
		BemRN bemRN = new BemRN();
		List<Bem> lsBens = bemRN.listar(bem);
		return lsBens;
	}
	
	public String actionSalvar (){
		BemRN bemRN = new BemRN();
		bemRN.salvar(bem);
		return "contabilidade";
	}
	
	public String actionCalcular() {
		BemRN bemRN = new BemRN();
		Bem bem2 = bemRN.calcular(bem);
		if (bem2.getTurno() == 100){
			bem2.setTurno(1);
		} else {
			if (bem2.getTurno() == 150){
				bem2.setTurno(2);
			} else {
				bem2.setTurno(3);
			}
		}
		bem.setNome(bem2.getNome());
		bem.setVd_util(bem2.getVd_util());
		bem.setTurno(bem2.getTurno());
		bem.setVr(bem2.getVr());
		bem.setDa(bem2.getDa());
		bem.setVc(bem2.getVc());
		bem.setG_p(bem2.getG_p());
		return "resultado";
	}
	
	

	public List<Bem> getLsBem() {
		return lsBens;
	}

	public void setLsBem(List<Bem> lsBem) {
		this.lsBens = lsBem;
	}

	public Bem getBem() {
		return bem;
	}

	public void setBem(Bem bem) {
		this.bem = bem;
	}
	
	

}
