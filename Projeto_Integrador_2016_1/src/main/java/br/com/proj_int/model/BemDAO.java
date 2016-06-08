package br.com.proj_int.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BemDAO implements IBemDAO {
	
	private Connection conexao;
	Bem bem2;

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public Bem select(Bem bem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Bem bem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Bem bem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Bem bem) {
		// TODO Auto-generated method stub

	}

	// /////////////////////--SELECT_ALL--/////////////////////
	@Override// ///////////////////////////////////////////////
	public List<Bem> selectAll() {
		// TODO Auto-generated method stub
		Connection conexao = null;
		PreparedStatement psAll = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM patrimonio ORDER BY id";
		List<Bem> lsBens = null;
		try {
			conexao = this.conexao;
			psAll = conexao.prepareStatement(sql);
			rs = psAll.executeQuery();
			lsBens = new ArrayList<Bem>();
			while (rs.next()) {
				Bem b = new Bem();
				b.setId(rs.getInt("id"));
				b.setNome(rs.getString("tipo"));
				lsBens.add(b);
			}
		} catch (Exception e) {
			System.err.println("----------------------");
			System.err.println("Erro no selectAll-Bem");
			e.printStackTrace();
		}
		return lsBens;
	}// ////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////

	@Override
	public Bem selectById(Bem bem) {
		// TODO Auto-generated method stub
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM patrimonio WHERE id = ?";
		
		try{
			conexao = this.conexao;
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, bem.getId());
			rs = ps.executeQuery();
			if(rs.next()){
				Bem b = new Bem();
				b.setId(rs.getInt("id"));
				b.setNome(rs.getString("tipo"));
				b.setVd_util(rs.getInt("vida_util"));
				b.setVr(rs.getDouble("valor_residual"));
				System.out.println(b.getId() + " " + b.getNome() + " " + b.getVd_util() + " " + b.getVr());
				bem2 = b;
			}
		}catch (Exception e){
			System.err.println("----------------------");
			System.err.println("Erro no selectByIdBem");
			e.printStackTrace();
		}		
		return bem2;
	}

}
