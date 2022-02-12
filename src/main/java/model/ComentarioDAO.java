package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ComentarioDAO {

	public ComentarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrar(ComentarioBean comentario) {
		
		String query = "INSERT INTO comentarios (mensagem, data, id_postagem_fk, id_usuario_fk, id_comentario_resp_fk) VALUES (?,?,?,?,?)";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);
			
			prepare.setString(1, comentario.getMensagem());
			prepare.setDate(2, (Date) comentario.getData());
			prepare.setInt(3, comentario.getPostagem().getIdPostagem());
			prepare.setInt(4, comentario.getUsuario().getIdUsuario());
			
			try {
				RespostaComentarioBean respostaComentario = (RespostaComentarioBean) comentario;
				prepare.setInt(5, respostaComentario.getIdComentarioRespondido());
			} catch (Exception e) {
				prepare.setString(5, null);
			}
			
	        if (prepare.executeUpdate() == 0) {
	            throw new Exception("Erro na criação do cometário.");
	        }
	        
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<ComentarioBean> listar(PostagemBean postagem) {
		
		ArrayList<ComentarioBean> comentarios = new ArrayList<>();
		
		String query = "SELECT id_comentario, mensagem, data, c.id_usuario_fk, f.nome 'nome_funcionario' "
				+ "FROM comentarios c "
				+ "JOIN usuarios u ON (c.id_usuario_fk = u.id_usuario) "
				+ "LEFT JOIN funcionarios f ON (u.id_usuario = f.id_usuario_fk) "
				+ "WHERE id_postagem_fk = ?;";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);
			
			prepare.setInt(1, postagem.getIdPostagem());

			ResultSet resultado = prepare.executeQuery();
			
			while (resultado.next()) {
				
				ComentarioBean comentario = new ComentarioBean();
				
				comentario.setIdComentario(resultado.getInt(1));
				comentario.setMensagem(resultado.getString(2));
				comentario.setData(resultado.getDate(3));
				
				if (resultado.getString(4) != null) {
					if (resultado.getString(5) != null) {
						FuncionarioBean funcionario = new FuncionarioBean();
						funcionario.setIdUsuario(resultado.getInt(4));
						funcionario.setNome(resultado.getString(5));
						
						comentario.setUsuario(funcionario);
					}
				}

				comentarios.add(comentario);
			}

			con.close();
			
			return comentarios;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<RespostaComentarioBean> listarRespostas(RespostaComentarioBean resposta) {
		
		ArrayList<RespostaComentarioBean> respostas = new ArrayList<>();
		
		String query = "SELECT id_comentario, mensagem, data, c.id_usuario_fk, f.nome 'nome_funcionario', id_comentario_resp_fk "
				+ "FROM comentarios c "
				+ "JOIN usuarios u ON (c.id_usuario_fk = u.id_usuario) "
				+ "LEFT JOIN funcionarios f ON (u.id_usuario = f.id_usuario_fk) "
				+ "WHERE id_comentario_resp_fk = ?;";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);
			
			prepare.setInt(1, resposta.getIdComentarioRespondido());

			ResultSet resultado = prepare.executeQuery();
			
			while (resultado.next()) {
				
				RespostaComentarioBean comentario = new RespostaComentarioBean();
				
				comentario.setIdComentario(resultado.getInt(1));
				comentario.setMensagem(resultado.getString(2));
				comentario.setData(resultado.getDate(3));
				
				if (resultado.getString(4) != null) {
					if (resultado.getString(5) != null) {
						FuncionarioBean funcionario = new FuncionarioBean();
						funcionario.setIdUsuario(resultado.getInt(4));
						funcionario.setNome(resultado.getString(5));
						
						comentario.setUsuario(funcionario);
					}
				}
				
				comentario.setIdComentarioRespondido(resultado.getInt(6));

				respostas.add(comentario);
			}

			con.close();
			
			return respostas;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<ComentarioBean> listarComentariosERespostas(PostagemBean postagem) {
		
		ArrayList<ComentarioBean> comentarios = listar(postagem);
		
		if (comentarios != null) {
			for (ComentarioBean comentarioBean : comentarios) {
				
				RespostaComentarioBean resposta = new RespostaComentarioBean();
				resposta.setIdComentarioRespondido(comentarioBean.getIdComentario());
				ArrayList<RespostaComentarioBean> respostas = listarRespostas(resposta);
				comentarioBean.setRespostas(respostas);
			}
			
			return comentarios;
		}

		return null;
	}
}
