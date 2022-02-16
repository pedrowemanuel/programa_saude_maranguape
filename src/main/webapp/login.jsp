<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="utf-8">
	<title>Login</title>
	<link rel="icon" href="imagens/favicon.ico">
	<link rel="stylesheet" href="style.css">

</head>

<body>
	<h1>Programa Saúde Maranguape</h1>
	<h2>Login</h2>

	<form name="fmLogin" action="fazerLogin" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<input type="email" name="email" placeholder="Email" class="caixa1" required>
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="senha" placeholder="Senha" class="caixa1" required>
				</td>
			</tr>
		</table>
		<div>
			<input type="submit" name="submit" value="Entrar" class="Botao1">
		</div>
	</form>

</body>
</html>