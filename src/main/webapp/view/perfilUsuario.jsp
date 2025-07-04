<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Perfil do Usuário</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/perfilUsuarioStyle.css">
</head>
<body>
	<div id="container">
		<h1>Bem-vindo, ${nome}!</h1>
		<img alt="foto-perfil" src="<%= request.getContextPath() %>/imgs/foto-perfil.jpg">
		
		<nav class="menu">
			<ul>
				<li><a href="#">Calculadora de Fertilizantes</a></li>
				<li>
					<form action="<%= request.getContextPath() %>/Usuario" method="post">
						<input type="hidden" name="idUsuario" value="${id}">
						<button type="submit" name="acao" value="obterIdUsuario" class="btn-menu">Alterar Login</button>
					</form>
				</li>
				<li>
					<form action="<%= request.getContextPath() %>/Usuario" method="post">
						<input type="hidden" name="idUsuario" value="${id}">
						<button type="submit" name="acao" value="deletarUsuario" class="btn-menu">Deletar Conta</button>
					</form>
				</li>
				<li><a class="btn-menu sair" href="<%= request.getContextPath() %>/index.html">Sair</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>
