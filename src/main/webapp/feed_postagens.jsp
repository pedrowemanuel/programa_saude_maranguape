<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UnidadeBean"%>
<%@ page import="model.PostagemBean"%>
<%@ page import="java.util.ArrayList"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<PostagemBean> postagens = (ArrayList<PostagemBean>) request.getAttribute("postagens");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="icon" href="imagens/favicon.ico">
<link rel="stylesheet" href="style.css">
<title>Saúde Maranguape</title>

<style type="text/css">
	h1{
		text-align: center;
	}
	h2{
		text-align: center;
	}
	
	header{
		background-color: white;
		padding: 5px;
		margin: 10px;
		border-radius:30px;
	}
	nav{
		padding: 10px;
		margin:10px;
		text-align: center;
	}
	nav > a{
		color: white;
		text-decoration: none;
		margin-right: 20px;
	}
	nav > a:hover{
		text-decoration: underline;
		
	}
	main{
		background-color: white;
		padding:10px;
		margin:10px;
		border-radius: 10px;
	}
	
	section#identific{
		display: flex;
		background-color: #005078;
		width:200px;
		height:50px;
		margin-bottom:10px;
		font-size: 50%; 
		color:white;
		border-radius: 10px;
		justify-content: center;
		align-items: center;
	}
	
	section#postagem{
		border: 1px solid gray;
		width:600px;
		min-height:400px;
		padding: 20px;
		margin-left:50px;
		margin-bottom:50px;
		border-radius: 10px;
	}
	
	.imagemPostagem {
		margin-bottom: 10px;
		max-width: 500px;
		height: auto;
	}
	footer{
		background-color: white;
		text-align: center;
		font-size: 50%; 
	}
</style>

</head>
<body>
	<header>
		<h1>Programa Saúde Maranguape</h1>
		<h2>Informações</h2>
		
	</header>
	<nav>
		<!-- <a href="" >Unidade 1</a> -->
	</nav>
	<main>
		<%
			for (int i = 0; i < postagens.size(); i++) {
		%>	
		<section id="postagem">
			<section id="identific">
				<img alt="User" src="imagens/user.png" width="40" height="40">
				<%= postagens.get(i).getFuncionario().getNome() %>
			</section>
				<%
					if (postagens.get(i).getLinkImagem() != null && !postagens.get(i).getLinkImagem().isEmpty()) {
				%>
					<section>
						<hr>
						<img class="imagemPostagem" alt="Postagem" src="imagens_postagens/<%= postagens.get(i).getLinkImagem()%>">
					</section>
				<%}%>
			<hr>
			<%= postagens.get(i).getMensagem() %>
		</section>
		<%
			}
		%>
	</main>
	<footer>
		<p>Secretaria do Estado do Ceará</p>
	</footer>
</body>
</html>