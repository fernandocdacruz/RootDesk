package model.dao;

import model.entities.Usuario;

public interface UsuarioDao {
	void inserirUsuario(Usuario usuario);
	Usuario acharPeloLogin(String login);
}
