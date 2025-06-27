<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualizar Login !</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/atualizarLoginStyle.css">
</head>
<body>
	<div id="container">
		<h1>Atualizar Login</h1>	
		<form action="<%= request.getContextPath() %>/Usuario" method="post">
			<input type="hidden" name="idUsuario" value="${id}">
			<label for="novoLogin">Novo login:</label>
			<input type="text" name="novoLogin" required>
			<div class="btn-form">
				<button class="btn" type="submit" name="acao" value="atualizarUsuario">Atualizar</button>
				<a class="btn btn-voltar" href="<%= request.getContextPath() %>/view/perfilUsuario.jsp">Voltar</a>
			</div>	
		</form>	
	</div>
</body>
</html>