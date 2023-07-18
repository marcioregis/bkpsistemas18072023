package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.farmacia.domain.Imoveis;
import br.com.farmacia.domain.Inquilinos;
import br.com.farmacia.factory.ConexaoFactory;

public class InquilinosDAO {
	public void salvar(Inquilinos q) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO inquilinos ");
		sql.append("(nomeinq, cpf, rg, profissao, email, endereco, bairro, cidade, uf, cep, telefone, celular,"
				+ "enderecocom, bairrocom, cidadecom, ufcom, cepcom, telefonecom, celularcom, imoveis_codigo) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareCall(sql.toString());
		comando.setString(1, q.getNomeinq());
		comando.setString(2, q.getCpf());
		comando.setString(3, q.getRg());
		//comando.setDate(4, q.getDatanasc());	
		//comando.setDate(4, new java.sql.Date(q.getDatanasc().getTime()));
		comando.setString(4, q.getProfissao());
		comando.setString(5, q.getEmail());
		comando.setString(6, q.getEndereco());
		comando.setString(7, q.getBairro());
		comando.setString(8, q.getCidade());
		comando.setString(9, q.getUf());
		comando.setString(10, q.getCep());
		comando.setString(11, q.getTelefone());
		comando.setString(12, q.getCelular());
		comando.setString(13, q.getEnderecocom());
		comando.setString(14, q.getBairrocom());
		comando.setString(15, q.getCidadecom());
		comando.setString(16, q.getUfcom());
		comando.setString(17, q.getCepcom());
		comando.setString(18, q.getTelefonecom());
		comando.setString(19, q.getCelularcom());
		comando.setLong(20, q.getImoveis().getCodigo());
		comando.executeUpdate();
	}

	// Funcao Listar inquilinos na tela principal e tela de cadastro de inquilinos - opcao Editar
	public ArrayList<Inquilinos> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT q.codigo, q.nomeinq, q.cpf, q.rg, q.profissao, q.email,"
				+ "q.endereco, q.bairro, q.cidade, q.uf, q.cep, q.telefone, q.celular, q.enderecocom, q.bairrocom,"
			+ "q.cidadecom, q.ufcom, q.cepcom, q.telefonecom, q.celularcom, i.codigo, i.nome ");
		sql.append("FROM inquilinos q ");
		sql.append("INNER JOIN imoveis i ON i.codigo = q.imoveis_codigo ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareCall(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList<Inquilinos> lista = new ArrayList<Inquilinos>();

		while (resultado.next()) {
			// instanciar
			Imoveis i = new Imoveis();
			i.setCodigo(resultado.getLong("i.codigo"));
			i.setNome(resultado.getString("i.nome"));

			Inquilinos q = new Inquilinos();
			q.setCodigo(resultado.getLong("q.codigo"));
			q.setNomeinq(resultado.getString("q.nomeinq"));
			q.setCpf(resultado.getString("q.cpf"));	
			q.setRg(resultado.getString("q.rg"));	
			//q.setDatanasc(resultado.getDate("q.datanasc"));	
			q.setProfissao(resultado.getString("q.profissao"));
			q.setEmail(resultado.getString("q.email"));
			q.setEndereco(resultado.getString("q.endereco"));
			q.setBairro(resultado.getString("q.bairro"));
			q.setCidade(resultado.getString("q.cidade"));
			q.setUf(resultado.getString("q.uf"));
			q.setCep(resultado.getString("q.cep"));
			q.setTelefone(resultado.getString("q.telefone"));
			q.setCelular(resultado.getString("q.celular"));
			q.setEnderecocom(resultado.getString("q.enderecocom"));
			q.setBairrocom(resultado.getString("q.bairrocom"));
			q.setCidadecom(resultado.getString("q.cidadecom"));
			q.setUfcom(resultado.getString("q.ufcom"));
			q.setCepcom(resultado.getString("q.cepcom"));
			q.setTelefonecom(resultado.getString("q.telefonecom"));
			q.setCelularcom(resultado.getString("q.celularcom"));
			
			q.setImoveis(i);
			lista.add(q);
		}
		return lista;
	}

	// Funcao exclui dados dos produtos
	public void excluir(Inquilinos q) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM inquilinos ");
		sql.append("WHERE codigo = ?");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareCall(sql.toString());
		comando.setLong(1, q.getCodigo());
		comando.executeUpdate();
	}

	// Funcao editar
	public void editar(Inquilinos q) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE inquilinos ");
		sql.append("SET nomeinq = ?, cpf = ?, rg = ?, profissao = ?, email = ?, endereco = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, telefone = ?, celular = ?, enderecocom = ?, bairrocom = ?, cidadecom = ?, ufcom = ?, cepcom = ?, telefonecom = ?, celularcom = ?, imoveis_codigo = ? ");
		sql.append("WHERE codigo = ? ");

		//prepara o conexao do banco
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareCall(sql.toString());
		
		comando.setString(1, q.getNomeinq());
		comando.setString(2, q.getCpf());
		comando.setString(3, q.getRg());
		comando.setString(4, q.getProfissao());
		comando.setString(5, q.getEmail());
		comando.setString(6, q.getEndereco());
		comando.setString(7, q.getBairro());
		comando.setString(8, q.getCidade());
		comando.setString(9, q.getUf());
		comando.setString(10, q.getCep());
		comando.setString(11, q.getTelefone());
		comando.setString(12, q.getCelular());
		comando.setString(13, q.getEnderecocom());
		comando.setString(14, q.getBairrocom());
		comando.setString(15, q.getCidadecom());
		comando.setString(16, q.getUfcom());
		comando.setString(17, q.getCepcom());
		comando.setString(18, q.getTelefonecom());
		comando.setString(19, q.getCelularcom());
		comando.setLong(20, q.getImoveis().getCodigo());
		comando.setLong(21, q.getCodigo());
		comando.executeUpdate();
	}
}
