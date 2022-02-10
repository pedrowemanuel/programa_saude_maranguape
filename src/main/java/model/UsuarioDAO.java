package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDAO {

	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrarUsuario(UsuarioBean usuario) {
		
		String query = "INSERT INTO usuarios (email, senha) VALUES (?,?)";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);

			prepare.setString(1, usuario.getEmail());
			prepare.setString(2, usuario.getSenha());

			prepare.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
