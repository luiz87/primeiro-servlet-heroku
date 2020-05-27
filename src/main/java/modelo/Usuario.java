package modelo;

public class Usuario {
	
	private int id;
	private String email;
	
	public Usuario() {
		setId(-1);
		setEmail("");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
