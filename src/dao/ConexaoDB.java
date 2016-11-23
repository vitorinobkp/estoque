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
		String nome;
		int idade;
		while (rs.next()) {
			nome = rs.getString(1);
			idade = rs.getInt(2);
			Pessoa p = new Pessoa(nome, idade);
			lstPessoa.add(p);
		}
		return lstPessoa;
	}
}
