package model.dao;

import model.entities.Usuario;

public interface UsuarioDao {
	void inserirUsuario(Usuario usuario);
	Usuario acharPeloLogin(String login);
	void deletarUsuario(int id);
	void atualizarUsuario(int id, String novoLogin);
}
