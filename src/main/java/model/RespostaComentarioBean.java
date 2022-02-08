package model;

public class RespostaComentarioBean extends ComentarioBean {
	
	private int idComentarioRespondido;

	public RespostaComentarioBean() {
	}

	public RespostaComentarioBean(String mensagem, UsuarioBean usuario, PostagemBean postagem, int idComentarioRespondido) {
		super(mensagem, usuario, postagem);
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
