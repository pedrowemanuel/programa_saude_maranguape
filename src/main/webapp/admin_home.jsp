<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UsuarioBean"%>
<%
	UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuario");

	if(usuario == null) {
		out.println("Usuário não autenticado!");
	} else
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>

</body>
</html>