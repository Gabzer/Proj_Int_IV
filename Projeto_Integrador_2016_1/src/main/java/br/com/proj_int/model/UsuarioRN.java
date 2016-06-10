package br.com.proj_int.model;

import br.com.proj_int.util.DAOFactory;

public class UsuarioRN {

	UsuarioDAO userDAO = new UsuarioDAO();

	public UsuarioRN() {
		this.userDAO = DAOFactory.criaUsuarioDAO();
	}

	public Usuario procurar(Usuario user) {
		Usuario user2 = new Usuario();
		user2 = this.userDAO.select(user);
		return user2;
	}
	
	public void salvar(Usuario user){
		userDAO.insert(user);
	}

}
