package model;

import java.util.Date;

public class PostagemBean {

	private int idPostagem;
	private String mensagem;
	private Date data;
	private FuncionarioBean funcionario;
	
	public PostagemBean() {
	}

	public PostagemBean(String mensagem, Date data, FuncionarioBean funcionario) {
		super();
		this.mensagem = mensagem;
		this.data = data;
		this.funcionario = funcionario;
	}

	public int getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(int idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public FuncionarioBean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioBean funcionario) {
		this.funcionario = funcionario;
	}
		
}
