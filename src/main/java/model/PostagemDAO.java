package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PostagemDAO {

	public PostagemDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrar(PostagemBean postagem) {
		
		String query = "INSERT INTO postagens (mensagem, data, link_imagem, id_funcionario_fk) VALUES (?,?,?,?)";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);
			
			prepare.setString(1, postagem.getMensagem());
			prepare.setDate(2, (Date) postagem.getData());
			prepare.setString(3, postagem.getLinkImagem());
			prepare.setInt(4, postagem.getFuncionario().getIdFuncionario());
			

	        if (prepare.executeUpdate() == 0) {
	            throw new Exception("Erro na criação da postagem.");
	        }
	        
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<PostagemBean> listar(UnidadeBean unidade) {
		
		ArrayList<PostagemBean> postagens = new ArrayList<>();
		
		String query = "SELECT id_postagem, mensagem, data, link_imagem, id_funcionario_fk, f.nome "
			+ "FROM postagens p "
			+ "JOIN funcionarios f ON (p.id_funcionario_fk = f.id_funcionario) "
			+ "WHERE f.id_unidade_fk = ?"
			+ "ORDER BY p.data desc";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);
			
			prepare.setInt(1, unidade.getIdUnidade());

			ResultSet resultado = prepare.executeQuery();
			
			while (resultado.next()) {
				
				PostagemBean postagem = new PostagemBean();
				
				postagem.setIdPostagem(resultado.getInt(1));
				postagem.setMensagem(resultado.getString(2));
				postagem.setData(resultado.getDate(3));
				postagem.setLinkImagem(resultado.getString(4));
				
				FuncionarioBean funcionario = new FuncionarioBean();
				funcionario.setIdFuncionario(resultado.getInt(5));
				funcionario.setNome(resultado.getString(6));
				
				postagem.setFuncionario(funcionario);

				postagens.add(postagem);
			}

			con.close();
			
			return postagens;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void excluir(PostagemBean postagem) {
		
		String query = "DELETE FROM postagens WHERE id_postagem = ?";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);

			prepare.setInt(1, postagem.getIdPostagem());

	        if (prepare.executeUpdate() == 0) {
	            throw new Exception("Erro na exclusão da postagem.");
	        }

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
