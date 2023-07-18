package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.farmacia.domain.Imoveis;
import br.com.farmacia.factory.ConexaoFactory;

public class ImoveisDAO {
	public void salvar(Imoveis i) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO imoveis ");
		sql.append("(nome, tipo, endereco, bairro, cidade, uf, cep, andar, valoraluguel, valorcondominio, valoriptu) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, i.getNome());
		comando.setString(2, i.getTipo());
		comando.setString(3, i.getEndereco());
		comando.setString(4, i.getBairro());
		comando.setString(5, i.getCidade());
		comando.setString(6, i.getUf());
		comando.setString(7, i.getCep());
		comando.setString(8, i.getAndar());
		comando.setDouble(9, i.getValoraluguel());
		comando.setDouble(10, i.getValorcondominio());
		comando.setDouble(11, i.getValoriptu());
		comando.executeUpdate();
	}
	
	// exclusao testado ok
	public void excluir (Imoveis i) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM imoveis ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, i.getCodigo());
		comando.executeUpdate();
	}
	
	//testado ok
	public void editar (Imoveis i) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE imoveis ");
		sql.append("SET nome = ?, tipo = ?, endereco = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, andar = ?, valoraluguel = ?, valorcondominio = ?, valoriptu = ?  ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		//comando.setLong(1, i.getCodigo());
		comando.setString(1, i.getNome());
		comando.setString(2, i.getTipo());
		comando.setString(3, i.getEndereco());
		comando.setString(4, i.getBairro());
		comando.setString(5, i.getCidade());
		comando.setString(6, i.getUf());
		comando.setString(7, i.getCep());
		comando.setString(8, i.getAndar());		
		comando.setDouble(9, i.getValoraluguel());
		comando.setDouble(10, i.getValorcondominio());
		comando.setDouble(11, i.getValoriptu());
		comando.setLong(12, i.getCodigo());
		comando.executeUpdate();
	}
	
	public Imoveis buscaPorCodigo(Imoveis i)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome, endereco, bairro, cidade, cep");
		sql.append("FROM imoveis ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setLong(1, i.getCodigo());
		ResultSet resultado = comando.executeQuery();
		Imoveis retorno = null;
		
		if(resultado.next()){
			retorno = new Imoveis();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEndereco(resultado.getString("endereco"));
			retorno.setBairro(resultado.getString("bairro"));
			retorno.setCidade(resultado.getString("cidade"));
			retorno.setCep(resultado.getString("cep"));			
		}
		return retorno;
	}
		
	public ArrayList<Imoveis>buscarPorNome(Imoveis i)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome, endereco, bairro, cidade, cep ");
		sql.append("FROM imoveis ");
		sql.append("WHERE nome LIKE ? ");
		sql.append("ORDER BY nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, "%" + i.getNome() + "%");
		
		ResultSet resultado = comando.executeQuery();
		ArrayList<Imoveis>lista = new ArrayList<Imoveis>();
		
		while(resultado.next()){
			Imoveis item = new Imoveis();
			item.setCodigo(resultado.getLong("codigo"));
			item.setNome(resultado.getString("nome"));
				
			lista.add(item);
		}
		return lista;
	}
	
	//  lista os dados da tabela imoveis quando clica no botao opcao/editar - testado ok
	public ArrayList<Imoveis> listar()throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome, tipo, endereco, bairro, cidade, uf, cep, andar, valoraluguel, valorcondominio, valoriptu ");
		sql.append("FROM imoveis ");
		sql.append("ORDER BY nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		 
		ArrayList<Imoveis>lista = new ArrayList<Imoveis>();
		
		while(resultado.next()){
			Imoveis i = new Imoveis();
			i.setCodigo(resultado.getLong("codigo"));
			i.setNome(resultado.getString("nome"));
			i.setTipo(resultado.getString("tipo"));
			i.setEndereco(resultado.getString("endereco"));
			i.setBairro(resultado.getString("bairro"));
			i.setCidade(resultado.getString("cidade"));
			i.setUf(resultado.getString("uf"));
			i.setCep(resultado.getString("cep"));
			i.setAndar(resultado.getString("andar"));
			i.setValoraluguel(resultado.getDouble("valoraluguel"));
			i.setValorcondominio(resultado.getDouble("valorcondominio"));
			i.setValoriptu(resultado.getDouble("valoriptu"));
			lista.add(i);
		}
		return lista;
	}	
}