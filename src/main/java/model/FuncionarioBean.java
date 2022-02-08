package model;

public class FuncionarioBean extends UsuarioBean {

	private int idFuncionario;
	private String nome;
	private String cpf;
	private String cargo;
	private boolean isFuncionarioAdmin;
	private UnidadeBean unidade;

	public FuncionarioBean() {
	}

	public FuncionarioBean(String email, String senha, int idFuncionario, String nome, String cpf, String cargo,
			boolean isFuncionarioAdmin, UnidadeBean unidade) {
		super(email,senha);
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.isFuncionarioAdmin = isFuncionarioAdmin;
		this.unidade = unidade;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean isFuncionarioAdmin() {
		return isFuncionarioAdmin;
	}

	public void setFuncionarioAdmin(boolean isFuncionarioAdmin) {
		this.isFuncionarioAdmin = isFuncionarioAdmin;
	}

	public UnidadeBean getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeBean unidade) {
		this.unidade = unidade;
	}

}
