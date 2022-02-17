<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.PostagemBean"%>
<%@ page import="model.UsuarioBean"%>
<%@ page import="java.util.ArrayList"%>
<%

	UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute("usuario");
	if(usuario == null) {
		out.println("Usuário não autenticado!");
	} else {
	
	@SuppressWarnings("unchecked")
	ArrayList<PostagemBean> postagens = (ArrayList<PostagemBean>) request.getAttribute("postagens");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="icon" href="imagens/favicon.ico">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
<title>Saúde Maranguape</title>
</head>
<body>
	<h1>Listar Postagens</h1>
	<table id="tabela_postagens" class="display">
		<thead>
			<tr>
				<th align="right">Código</th>
				<th align="left">Mensagem</th>
				<th align="left">Data</th>
				<th align="center">Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < postagens.size(); i++) {
			%>
			<tr>
				<td align="right"><%=postagens.get(i).getIdPostagem()%></td>
				<td><%=postagens.get(i).getMensagem()%></td>
				<td><%=postagens.get(i).convertDateString()%></td>
				<td align="center"> <a
					href="javascript: confirmar('funcionarioExcluirPostagem?id_postagem=<%=postagens.get(i).getIdPostagem()%>')"
					class="Botao2">Excluir</a></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<a href="funcionario_home.jsp"><input type="button" value="Voltar" class="Botao1"></a>

	<script src="scripts/jquery-3.6.0.js"></script>
	<script type="text/javascript" charset="utf8"
		src="scripts/jquery.dataTables.js"></script>
	<script src="scripts/confirmador.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabela_postagens').DataTable({
				"aaSorting" : [ [ 1, "asc" ] ]
			});
		});
	</script>
</body>
</html>

<% }%>