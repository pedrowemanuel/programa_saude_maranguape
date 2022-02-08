package model;

public class UnidadeBean {

	private int idUnidade;
	private String nome;
	private String regiao;
	
	public UnidadeBean() {
	}
	
	public UnidadeBean(String nome, String regiao) {
		super();
		this.nome = nome;
		this.regiao = regiao;
	}
	
	public int getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(int idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
}
