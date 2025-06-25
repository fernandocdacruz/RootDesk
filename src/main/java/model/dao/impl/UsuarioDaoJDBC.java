package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioDaoJDBC implements UsuarioDao {

	private Connection conn;
	
	public UsuarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserirUsuario(Usuario usuario) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO usuarios "
					+ "(nome, login, senha) "
					+ "VALUES "
					+ "(?, ?, ?)"
					);
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getLogin());
			st.setString(3, usuario.getSenha());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Usuario acharPeloLogin(String login) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM USUARIOS "
					+ "WHERE login = ?"
					);
			st.setString(1, login);
			rs = st.executeQuery();
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
