package br.com.proj_int.model;

import java.util.List;

public interface IBemDAO {
	
	Bem select(Bem bem);
	Bem selectById(Bem bem);	
	void insert(Bem bem);
	
	void delete(Bem bem);
	void update(Bem bem);
	List<Bem> selectAll();

}
