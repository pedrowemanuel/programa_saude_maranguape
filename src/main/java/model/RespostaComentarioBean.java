package model;

import java.util.Date;

public class RespostaComentarioBean extends ComentarioBean {
	
	private int idComentarioRespondido;

	public RespostaComentarioBean() {
	}

	public RespostaComentarioBean(String mensagem, Date data, UsuarioBean usuario, PostagemBean postagem, int idComentarioRespondido) {
		super(mensagem, data, usuario, postagem);
		// TODO Auto-generated constructor stub
		
		this.idComentarioRespondido = idComentarioRespondido;
	}

	public int getIdComentarioRespondido() {
		return idComentarioRespondido;
	}

	public void setIdComentarioRespondido(int idComentarioRespondido) {
		this.idComentarioRespondido = idComentarioRespondido;
	}

}
