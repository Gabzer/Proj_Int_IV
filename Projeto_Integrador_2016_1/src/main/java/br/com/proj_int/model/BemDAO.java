package br.com.proj_int.model;

import java.sql.Connection;
import java.sql.Date;
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
		Connection conexao = null;
		PreparedStatement psInsert = null;
		String sql = "INSERT INTO patrimonio (tipo, vida_util, valor_residual, data_compra, valor_bem, condicao_bem)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			conexao = this.conexao;
			psInsert = conexao.prepareStatement(sql);			
			psInsert.setString(1, bem.getNome());
			psInsert.setInt(2, bem.getVd_util());
			psInsert.setDouble(3, bem.getVr());
			psInsert.setDate(4, (Date) bem.getDataAquisicao());
			psInsert.setDouble(5, bem.getCb());
			psInsert.setInt(6, bem.getTemp_uso());
			psInsert.executeUpdate();
		}catch (Exception e){
			System.err.println("----------------------");
			System.err.println("Erro no insert_Bem");
			e.printStackTrace();			
		}
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
				b.setDataAquisicao(rs.getString("data_compra"));
				b.setCb(rs.getDouble("valor_bem"));
				b.setTemp_uso(rs.getInt("condicao_bem"));
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
