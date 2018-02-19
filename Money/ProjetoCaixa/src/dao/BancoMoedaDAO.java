package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.BancoMoeda;
import factory.Conexao;

public class BancoMoedaDAO {
	public void salvar(BancoMoeda b) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO moedas ");
		sql.append("(nome, codigo, sinal, valor) ");
		sql.append("VALUES (?, ?, ?, ?);");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, b.getNome());
		comando.setString(2, b.getCodigo());
		comando.setString(3, b.getSinal());
		comando.setDouble(4, b.getValor());
		
		comando.executeUpdate();
	}
	
	public void excluir(BancoMoeda b) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM moedas ");
		sql.append("WHERE id = ?;");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, b.getId());
		
		comando.executeUpdate();		
	}
	
	public void editar(BancoMoeda b) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE moedas ");
		sql.append("SET nome = ?, ");
		sql.append("codigo = ?, ");
		sql.append("sinal = ?, ");
		sql.append("valor = ? ");
		sql.append("where id = ?;");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, b.getNome());
		comando.setString(2, b.getCodigo());
		comando.setString(3, b.getSinal());
		comando.setDouble(4, b.getValor());
		comando.setLong(5, b.getId());
		
		comando.executeUpdate();
	}
	
	public ArrayList<BancoMoeda> consultar( ) throws SQLException {
		ArrayList<BancoMoeda> lista = new ArrayList<BancoMoeda>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, nome, codigo, sinal, valor, valorR ");
		sql.append("FROM moedas ORDER BY id ASC;");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		while(resultado.next()) {
			BancoMoeda b = new BancoMoeda();
			b.setId(resultado.getLong("id"));
			b.setNome(resultado.getString("nome"));
			b.setCodigo(resultado.getString("codigo"));
			b.setSinal(resultado.getString("sinal"));
			b.setValor(resultado.getDouble("valor"));
			b.setValorR(resultado.getDouble("valorR"));
			
			lista.add(b);
		}
		
		return lista;	
	}
	
	public static void main(String[] args) {
		BancoMoedaDAO bdao = new BancoMoedaDAO();
		BancoMoeda b = new BancoMoeda();	
		b.setNome("Euro");
		b.setCodigo("EUR");
		b.setSinal("&");
		b.setValor(10.5);
				
		try{
			bdao.salvar(b);
			System.out.println("Boa!");
		}
		catch(SQLException ex)
		{
			System.out.println("N foi.");
			ex.printStackTrace();
		}
	}
}
