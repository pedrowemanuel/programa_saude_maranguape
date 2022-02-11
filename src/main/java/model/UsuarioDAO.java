package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDAO {

	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioBean cadastrar(UsuarioBean usuario) {
		
		String query = "INSERT INTO usuarios (email, senha) VALUES (?,?)";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			prepare.setString(1, usuario.getEmail());
			prepare.setString(2, usuario.getSenha());
			

	        if (prepare.executeUpdate() == 0) {
	            throw new Exception("Erro na criação do usuário.");
	        }

	        ResultSet generatedKeys = prepare.getGeneratedKeys();

            if (generatedKeys.next()) {
                usuario.setIdUsuario(generatedKeys.getInt(1));
            }
            else {
                throw new Exception("Erro ao obter o id do usuário");
            }

			con.close();
			
			return usuario;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public boolean login(UsuarioBean usuario) {
		
		String query = "SELECT 1 "
			+ "FROM usuarios u "
			+ "WHERE email = ? "
				+ "AND senha = ? "
			+"LIMIT 1 ";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);

			prepare.setString(1, usuario.getEmail());
			prepare.setString(2, usuario.getSenha());

			ResultSet resultado = prepare.executeQuery();
			
			boolean usuarioLogado = false;

			if(resultado.next())
				usuarioLogado = true;

			con.close();
			
			return usuarioLogado;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
