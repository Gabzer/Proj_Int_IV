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
	
	public String actionCalcular() {
		System.out.println(bem.getId() + " aquiMB ");
		bem2 = new Bem();
		BemRN bemRN = new BemRN();
		bem2 = bemRN.calcular(bem);
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
