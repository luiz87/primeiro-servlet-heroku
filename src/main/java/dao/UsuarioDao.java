package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UsuarioDao {
	
	// insert é C do nosso CRUD
	public boolean incluir(Usuario usuario) {
		Connection conexao = Conexao.getConectar();
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement("insert into usuario (email) values (?) ");
			pst.setString(1, usuario.getEmail());
			pst.execute();
			pst.close();
			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// listar R do nosso CRUD
	public List<Usuario> listar() {
		Connection conexao = Conexao.getConectar();
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement("select * from usuario");
			
		 	ResultSet rs = pst.executeQuery();
		 	List<Usuario> lsUsuario = new ArrayList<Usuario>();
		 	while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				lsUsuario.add(u);
			}
			return lsUsuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// listar R do nosso CRUD
	public Usuario getUsuario(String id) {
		Connection conexao = Conexao.getConectar();
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement("select * from usuario where id = ?");
			pst.setInt(1, Integer.parseInt(id));
		 	ResultSet rs = pst.executeQuery();
			Usuario u = new Usuario();
		 	while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
			}
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean atualizar(Usuario usuario) {
		Connection conexao = Conexao.getConectar();
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement("update usuario set email = ? where id = ? ");
			pst.setString(1, usuario.getEmail());
			pst.setInt(2, usuario.getId());
			pst.execute();
			pst.close();
			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean excluir(Usuario usuario) {
		Connection conexao = Conexao.getConectar();
		PreparedStatement pst;
		
		try {
			pst = conexao.prepareStatement("delete from usuario where id = ?");
			pst.setInt(1, usuario.getId());
			pst.execute();
			pst.close();
			conexao.close();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
