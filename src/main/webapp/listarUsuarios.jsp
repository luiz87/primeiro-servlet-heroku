<%@page import="dao.UsuarioDao"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Usuários</title>
</head>
<body>
	<h2>Listar Usuários!</h2>

	<table>
		<tr>
			<td>Id</td>
			<td>E-mail</td>
		</tr>
		<%
			UsuarioDao dao = new UsuarioDao();
			List<Usuario> lsUsuarios = dao.listar();

			for (Usuario u : lsUsuarios) {
				out.print("<tr><td>" + u.getId() + "</td><td>" + u.getEmail() + "</td>" + "<td> <a href='index.jsp?id="
						+ u.getId() + "' >Editar</a></td>");
		%>
		<td><a onclick="return confirm('Deseja realmente excluir esse registro?')" href='exemploServler?acao=excluir&id=<%=u.getId()%>'>Excluir</a></td>

		<%
			out.print("</tr>");
			}
		%>

		<table>
</body>
</html>
