package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import modelo.Usuario;

@WebServlet(urlPatterns = "/exemploServler" )
public class ExemploServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();
		String email = req.getParameter("email");
		String acao = req.getParameter("acao");
		usuario.setEmail(email);
		PrintWriter out = resp.getWriter();

		String conteudo = "";
		if(email != null) 
			conteudo += "<h2>O email digitado foi: "+usuario.getEmail()+"</h2>";	
		
		if(acao.equals("incluir")) {
			if(dao.incluir(usuario)) {
				conteudo += "<div class='alert alert-success'>";
				conteudo += "  <strong>Inserido!</strong> Usuário inserido com sucesso.";
				conteudo += "</div>";
			}	
		}
		
		if(acao.equals("atualizar")) {
			usuario.setId(Integer.parseInt(req.getParameter("id")));
			if(dao.atualizar(usuario)) {
				conteudo += "<div class='alert alert-info'>";
				conteudo += "  <strong>Alterado!</strong> Usuário atualizado com sucesso.";
				conteudo += "</div>";
			}	
		}
		
		if(acao.equals("excluir")) {
			usuario.setId(Integer.parseInt(req.getParameter("id")));
			if(dao.excluir(usuario)) {
				conteudo += "<div class='alert alert-danger'>";
				conteudo += "  <strong>Excluido!</strong> Usuário excluido com sucesso.";
				conteudo += "</div>";
			}
		}
		
		out.print("<!DOCTYPE html>																							");
		out.print("<html>                                                                                                   ");
		out.print("<head>                                                                                                   ");
		out.print("<meta charset=\"UTF-8\">                                                                                   ");
		out.print("<title>Form de E-mail</title>                                                                            ");
		out.print("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"> ");
		out.print("</head>                                                                                                  ");
		out.print("<body>                                                                                                   ");
		out.print("<div class='container'>");
		out.print(conteudo);
		out.print("</div>");
		out.print("<body>                                                                                                   ");
		out.print("</html>                                                                                                  ");
	}
}
