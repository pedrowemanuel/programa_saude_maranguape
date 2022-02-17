<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UsuarioBean"%>
<%
	UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuario");

	if(usuario == null) {
		out.println("Usuário não autenticado!");
	} else {
%>

<!DOCTYPE html>
<html lang="pt-br" >
<head>
<meta charset="utf-8">
<link rel="icon" href="imagens/favicon.ico" >
<link rel="stylesheet" href="style.css">
<title>Saúde Maranguape</title>
</head>
<body>
	<h1>Programa Saúde Maranguape</h1>
	<h2>Profissional de Saúde</h2>
	
	<a href="funcionarioAcessarCadastroPostagem"><input type="button" value="Criar Postagem" class="Botao1"></a>
	<a href="funcionarioAcessarListarPostagens"><input type="button" value="Listar Postagens" class="Botao1"></a>
	<a href="fazerLogout"><input type="button" value="Sair" class="BotaoSair"></a>
</body>
</html>

<% }%>