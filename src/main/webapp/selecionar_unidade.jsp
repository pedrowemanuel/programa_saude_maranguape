<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UnidadeBean"%>
<%@ page import="java.util.ArrayList"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<UnidadeBean> unidades = (ArrayList<UnidadeBean>) request.getAttribute("unidades");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<link rel="icon" href="imagens/favicon.ico">
	<link rel="stylesheet" href="style.css">
	<title>Saúde Maranguape</title>
</head>
<body>
	<h1>Programa Saúde Maranguape</h1>
	
	    <form action="cidadaoAcessarPostagens" name="fmSelectUnidade" method="POST" enctype="multipart/form-data">

        <table>
            <tr>
                <td>
                    <label for="id_unidade">Escolha a Unidade de saúde</label>
                </td>
            </tr> 
            <tr>
                <td>
                    <select id="id_unidade" name="id_unidade" required>
						<option value="">Selecione a unidade: </option>
						<%
						for (int i = 0; i < unidades.size(); i++) {
						%>
						<option value="<%=unidades.get(i).getIdUnidade()%>"><%=unidades.get(i).getNome()%></option>
						<% } %>
					</select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Entrar" class="Botao1">
                </td>
            </tr>
            
        </table>
    </form>
</body>
</html>