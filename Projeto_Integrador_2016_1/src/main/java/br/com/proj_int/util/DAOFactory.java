package br.com.proj_int.util;

import br.com.proj_int.model.BemDAO;
import br.com.proj_int.model.UsuarioDAO;

public class DAOFactory {
	
	public static UsuarioDAO criaUsuarioDAO() {
		UsuarioDAO dao = new UsuarioDAO();
		dao.setConexao(ConnectionFactory.getConnection());
		return dao;
	}
	
	public static BemDAO criaBemDAO(){
		BemDAO dao = new BemDAO();
		dao.setConexao(ConnectionFactory.getConnection());
		return dao;
	}

}
