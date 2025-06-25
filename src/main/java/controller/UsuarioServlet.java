package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;

@WebServlet("/Usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private UsuarioDao usuarioDao;
   
   @Override
   public void init() {
	   usuarioDao = DaoFactory.createUsuarioDao();
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String acao = request.getParameter("acao");
	   switch (acao) {
	   case "cadastrarUsuario": cadastrarUsuario(request, response);
	   break;
	   case "entrarPerfil": entrarPerfil(request, response);
	   break;
	   }
   }
   
   private void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   String nome = request.getParameter("nome");
	   String login = request.getParameter("login");
	   String senha = request.getParameter("senha");
	   
	   if (validarLoginEmUso(login)) {
		   usuarioDao.inserirUsuario(new Usuario(nome, login, senha));
		   response.sendRedirect(request.getContextPath() + "/index.html");
	   } else {
		   request.setAttribute("erro", "Login em uso. Tente novamente.");
		   request.setAttribute("voltarPara", "/view/cadastrarUsuario.html");
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/view/erro.jsp");
		   dispatcher.forward(request, response);
		   return;
	   } 
   }
   
   private void entrarPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   String login = request.getParameter("login");
	   String senha = request.getParameter("senha");
	   
	   if (!validarLoginEmUso(login)) {
		   Usuario usuario = usuarioDao.acharPeloLogin(login);
		   if (usuario.getSenha().equals(senha)) {
			   response.sendRedirect(request.getContextPath() + "/view/perfilUsuario.html");
		   } else {
			   request.setAttribute("erro", "Senha inválida. Tente novamente.");
			   request.setAttribute("voltarPara", "/index.html");
			   RequestDispatcher dispatcher = request.getRequestDispatcher("/view/erro.jsp");
			   dispatcher.forward(request, response);
			   return;
		   }
	   } else {
		   request.setAttribute("erro", "Login inválido. Tente novamente.");
		   request.setAttribute("voltarPara", "/index.html");
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/view/erro.jsp");
		   dispatcher.forward(request, response);
		   return;
	   }
	   
   }
   
   private boolean validarLoginEmUso(String login) {
	   boolean valido = true;
	   if (usuarioDao.acharPeloLogin(login) != null) {
		  valido = false;
	   }
	   return valido;
   }

}
