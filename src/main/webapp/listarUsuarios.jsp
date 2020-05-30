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
<title>Form de E-mail</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Listar Usuários!</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>E-mail</th>
				</tr>
			</thead>
			<tbody>
				<%
					UsuarioDao dao = new UsuarioDao();
					List<Usuario> lsUsuarios = dao.listar();

					for (Usuario u : lsUsuarios) {
						out.print("<tr><td>" + u.getId() + "</td><td>" + u.getEmail() + "</td>" + "<td> <a class='btn btn-info' href='index.jsp?id="
								+ u.getId() + "' ><samp class='glyphicon glyphicon-edit'></samp></a>");
				%>
				<a class="btn btn-danger"
					onclick="return confirm('Deseja realmente excluir esse registro?')"
					href='exemploServler?acao=excluir&id=<%=u.getId()%>'>
					<samp class="glyphicon glyphicon-remove"></samp>
					</a></td>

				<%
					out.print("</tr>");
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
