package br.com.proj_int.model;

import java.util.List;

public interface IUsuarioDAO {
	
	Usuario select(Usuario user);
	List<Usuario> selectAll();
	
	void insert(Usuario user);
	void delete(Usuario user);
	void update(Usuario user);

}
