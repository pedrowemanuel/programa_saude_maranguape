package model;

public class ComentarioBean {
	
	private int idComentario;
	private String mensagem;
	private UsuarioBean usuario;
	private PostagemBean postagem;

	public ComentarioBean() {
	}
	
	public ComentarioBean(String mensagem, UsuarioBean usuario, PostagemBean postagem) {
		super();
		this.mensagem = mensagem;
		this.usuario = usuario;
		this.postagem = postagem;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public PostagemBean getPostagem() {
		return postagem;
	}

	public void setPostagem(PostagemBean postagem) {
		this.postagem = postagem;
	}
	
	

}
