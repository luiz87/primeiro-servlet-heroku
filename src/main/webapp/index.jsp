<%@page import="dao.UsuarioDao"%>
<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form de E-mail</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<h2 for="email">Digite seu email!</h2>
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
			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
						<input type="email" class="form-control" id="email"
							placeholder="Enter email" name="email"
							value="<%out.print(u.getEmail());%>">
					</div>
				</div>
				<div class="col-sm-1">
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>

				<div class="col-sm-2">
					<a href='listarUsuarios.jsp' class="btn btn-success">Listae
						E-mails</a>
				</div>

			</div>

		</form>


	</div>
</body>
</html>
