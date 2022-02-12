package model;

import java.util.Date;

public class PostagemBean {

	private int idPostagem;
	private String mensagem;
	private Date data;
	private String linkImagem;
	private FuncionarioBean funcionario;
	
	public PostagemBean() {
	}

	public PostagemBean(String mensagem, Date data, String linkImagem, FuncionarioBean funcionario) {
		super();
		this.mensagem = mensagem;
		this.data = data;
		this.linkImagem = linkImagem;
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
	
	public String getLinkImagem() {
		return linkImagem;
	}

	public void setLinkImagem(String linkImagem) {
		this.linkImagem = linkImagem;
	}

	public FuncionarioBean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioBean funcionario) {
		this.funcionario = funcionario;
	}
		
}
