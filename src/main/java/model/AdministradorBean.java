package model;

public class AdministradorBean extends UsuarioBean {

	private int idAdministrador;
	private String nome;
	
	public AdministradorBean() {
	}
	
	public AdministradorBean(String email, String senha, int idAdministrador, String nome) {
		super(email,senha);
		this.idAdministrador = idAdministrador;
		this.nome = nome;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}
	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
