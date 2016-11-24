package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.api.mysqla.result.Resultset;

import model.Pessoa;

public class ConexaoDB {
	Connection instance;

	public ConexaoDB() {
		instance = ConnectionFactory.getConnection();
	}

	public int executeConsulta(String sql) throws SQLException {

		Statement statement = (Statement) instance.createStatement();
		return statement.executeUpdate(sql);

	}

	public int executeDelete(String sql) throws SQLException {

		Statement statement = (Statement) instance.createStatement();
		return statement.executeUpdate(sql);
	}

	public ArrayList<Pessoa> buscarTodos(String sql) throws SQLException {
		Statement statement = (Statement) instance.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		ArrayList<Pessoa> lstPessoa = new ArrayList<Pessoa>();
		
		int id;
		String nome;
		String descricao;
		int quantidade;
		double preco;
		while (rs.next()) {
			id = rs.getInt(1);
			nome = rs.getString(2);
			descricao = rs.getString(3);
			quantidade = rs.getInt(4);
			preco = rs.getDouble(5);
			Pessoa p = new Pessoa(id, nome, descricao, quantidade, preco);
			lstPessoa.add(p);
		}
		return lstPessoa;
	}
}
