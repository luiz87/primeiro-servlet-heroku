<%@page import="dao.UsuarioDao"%>
<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form de E-mail</title>
</head>
<body>
	<h2>Digite seu email!</h2>
	<%
		String id = request.getParameter("id");
		String acao = "incluir";
		Usuario u = new Usuario();
		if (id != null) {
			out.println("Id identificado " + id);
			UsuarioDao dao = new UsuarioDao();
			u = dao.getUsuario(id);
			acao = "atualizar";
		}
	%>
	<form action="exemploServler" method="get">
		<input type="hidden" name="acao" value="<%out.print(acao);%>">
		<input type="hidden" name="id" value="<%out.print(u.getId());%>">
		<input type="text" name="email" value="<%out.print(u.getEmail());%>"><br>
		<input type="submit">
	</form>
	<a href='listarUsuarios.jsp'>Lista</a>
</body>
</html>
