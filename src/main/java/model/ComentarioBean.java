package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ComentarioBean {
	
	private int idComentario;
	private String mensagem;
	private Date data;
	private UsuarioBean usuario;
	private PostagemBean postagem;
	private ArrayList<RespostaComentarioBean> respostas;

	public ComentarioBean() {
	}
	
	public ComentarioBean(String mensagem, Date data, UsuarioBean usuario, PostagemBean postagem) {
		super();
		this.mensagem = mensagem;
		this.data = data;
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
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
	
	public ArrayList<RespostaComentarioBean> getRespostas() {
		return respostas;
	}

	public void setRespostas(ArrayList<RespostaComentarioBean> respostas) {
		this.respostas = respostas;
	}
	
	public String convertDateString() {
		SimpleDateFormat dateParser = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		return dateParser.format(this.data);
	}
}
