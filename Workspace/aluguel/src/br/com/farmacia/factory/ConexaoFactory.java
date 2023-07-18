package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/sistema";
	
	//private static final String USUARIO = "6e5e4ohfwyylvx5ddkm2";
	//private static final String SENHA = "pscale_pw_jHnzGMppikn6fLvVFL3TPNp1PtYVcYXzdG7UOF2JQOR";
	//private static final String URL = "jdbc:mysql://aws.connect.psdb.cloud";
	
	
	public static Connection conectar() throws SQLException {
		
		//Referencia ao Driver mysql- sem esse driver nao mostra os dados na tela
	    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
		return conexao;
}

@SuppressWarnings("unused")
public static void main(String[] args) {
	try{
		Connection conexao = ConexaoFactory.conectar();
		System.out.println("Conectado com sucesso!");
	}

	catch(SQLException ex){
		ex.printStackTrace();
		System.out.println("Conexao falhou!!");
	}
}
}