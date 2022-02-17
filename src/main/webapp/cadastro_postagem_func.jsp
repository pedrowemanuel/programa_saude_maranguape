<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UsuarioBean"%>
<%@ page import="model.FuncionarioBean"%>
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
	<h1>Cadastrar Postagem</h1>
	
    <form action="funcionarioCadastrarPostagem" name="fmCadastroPostagem" method="POST" enctype="multipart/form-data">

        <table >
            <tr>
                <td>
                    <label for="mensagem">Mensagem</label>
                </td>
            </tr> 
            <tr>
                <td>
                    <textarea name="mensagem" id="mensagem" cols="40" rows="10" placeholder="Mensagem"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="imagem">Imagem</label>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="file" name="imagem" id="imagem" accept="image/*" class="caixa1">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Salvar" class="Botao1">
                </td>
                <td>
                    <a href="funcionario_home.jsp"><input type="button" value="Voltar" class="Botao1"></a>
                </td>
            </tr>
            
        </table>
    </form>

</body>
</html>

<% }%>