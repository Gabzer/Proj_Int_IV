package br.com.proj_int.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

	private Connection conexao;
	Usuario user2 = new Usuario();

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	// ////////////////////--SELECT--///////////////////////
	@Override///////////////////////////////////////////////
	public Usuario select(Usuario user) {
		// TODO Auto-generated method stub
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, login, senha, tipo FROM usuario "
				+ "WHERE login = ? AND senha = ?";
		
		try {
			conexao = this.conexao;
			ps = conexao.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getSenha());
			rs = ps.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				user2 = u;
			} else {
				user2 = null;
			}
		} catch (Exception e) {
			System.err.println("----------------------");
			System.err.println("Erro no selectUsuario");
			e.printStackTrace();
		}
		return user2;
	}////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////

	@Override
	public void insert(Usuario user) {
		// TODO Auto-generated method stub
		Connection conexao = null;
		PreparedStatement psInsert = null;
		String sql = "INSERT INTO usuario (login, senha)"
				+ " VALUES (?, ?)";
		try {
			conexao = this.conexao;
			psInsert = conexao.prepareStatement(sql);
			psInsert.setString(1, user.getLogin());
			psInsert.setString(2, user.getSenha());
			psInsert.executeUpdate();
		}catch (Exception e){
			System.err.println("----------------------");
			System.err.println("Erro no insert_Usuario");
			e.printStackTrace();			
		}

	}

	@Override
	public void delete(Usuario user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Usuario user) {
		// TODO Auto-generated method stub

	}

	// /////////////////////--SELECT_ALL--/////////////////////
	@Override// ///////////////////////////////////////////////
	public List<Usuario> selectAll() {
		// TODO Auto-generated method stub
		Connection conexao = null;
		PreparedStatement psAll = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM usuario ORDER BY id";
		List<Usuario> lsUsuarios = null;
		try {
			conexao = this.conexao;
			psAll = conexao.prepareStatement(sql);
			rs = psAll.executeQuery();
			lsUsuarios = new ArrayList<Usuario>();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				lsUsuarios.add(u);
			}
		} catch (Exception e) {
			System.err.println("----------------------");
			System.err.println("Erro no selectAll");
			e.printStackTrace();
		}
		return lsUsuarios;
	}// ////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////

}
