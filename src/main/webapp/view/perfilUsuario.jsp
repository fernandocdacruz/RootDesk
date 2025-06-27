<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bem vindo ao RootDesk!!</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/perfilUsuarioStyle.css">
</head>
<body>
	<div id="container">
		<img alt="foto-perfil"  src="<%= request.getContextPath() %>/imgs/foto-perfil.jpg">
		<p class="mensagem-bemvindo">Bem vindo ${nome} !!</p>
		<form action="<%= request.getContextPath() %>/Usuario" method="post">
			<input type="hidden" name="idUsuario" value="${id}">
			<div>
				<a href="#">Calculadora de Fertilizantes</a>
				<button type="submit" name="acao" value="deletarUsuario">Deletar Conta</button>
				<div>
					<form action="<%= request.getContextPath() %>/Usuario" method="post">
						<input type="hidden" name="idUsuario" value="${id}">
						<button type="submit" name="acao" value="obterIdUsuario">Alterar Login</button>
					</form>
				</div>
				<a href="<%= request.getContextPath() %>/index.html">Sair</a>
			</div>	
		</form>	
	</div>
</body>
</html>