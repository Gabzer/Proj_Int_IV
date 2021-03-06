package br.com.proj_int.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.proj_int.model.Usuario;
import br.com.proj_int.model.UsuarioRN;

@ManagedBean(name = "mbuser")
@SessionScoped
public class MBUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario user = new Usuario();
	private List<Usuario> lsUsuarios = null;
	String msg= "senha Invalida";
	public String actionProcurar() {
		Usuario user2 = new Usuario();
		UsuarioRN userRN = new UsuarioRN();
		user2 = userRN.procurar(user);
		if (user2 == null) {
			
			return  msg;
		} else {
			return "contabilidade?faces-redirect=true";
		}
	}
	
	public String actionSalvar (){
		System.out.println("passou");
		UsuarioRN userRN = new UsuarioRN();
		userRN.salvar(user);
		return "home";
	}
	

	///////////////////gets-setters//////////////////
	/////////////////////////////////////////////////
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public List<Usuario> getLsUsuarios() {
		return lsUsuarios;
	}

	public void setLsUsuarios(List<Usuario> lsUsuarios) {
		this.lsUsuarios = lsUsuarios;
	}

}
