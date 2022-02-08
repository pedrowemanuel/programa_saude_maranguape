package model;

public class UsuarioBean {

	private int idUsuario;
	private String email;
	private String senha;
	
	public UsuarioBean() {
	}

	public UsuarioBean(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
