<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Erro!</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/erroStyle.css">
</head>
<body>
	<div id="container">
		<h1>Ocorreu um erro!</h1>
		<p class="mensagem-erro">
			<% 
				out.println((String) request.getAttribute("erro"));
			%>
		</p>
		<div class="btn-container">
		<a class="btn btn-voltar" href="<%= request.getContextPath() %><%= request.getAttribute("voltarPara") %>">Voltar</a>
	</div>
	</div>	
</body>
</html>