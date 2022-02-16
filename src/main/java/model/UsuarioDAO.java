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
	
	public UsuarioBean login(UsuarioBean usuario) {
		
		String query = "SELECT "
				+ "	id_usuario, a.id_administrador, fa.id_funcionario 'id_funcionario_admin', "
				+ "	f.id_funcionario, COALESCE(a.nome, fa.nome, f.nome, 'ANONIMO') nome, COALESCE(fa.id_unidade_fk, f.id_unidade_fk) id_unidade "
				+ "FROM usuarios u "
				+ "LEFT JOIN administradores a ON (u.id_usuario = a.id_usuario_fk) "
				+ "LEFT JOIN funcionarios fa ON (u.id_usuario = fa.id_usuario_fk AND fa.funcionario_admin = 1) "
				+ "LEFT JOIN funcionarios f ON (u.id_usuario = f.id_usuario_fk AND f.funcionario_admin = 0) "
				+ "WHERE email = ? "
				+ "AND senha = ?"
				+ "LIMIT 1; ";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);

			prepare.setString(1, usuario.getEmail());
			prepare.setString(2, usuario.getSenha());

			ResultSet resultado = prepare.executeQuery();

			if(resultado.next()) {
				
				if (resultado.getString(2) != null) {
					AdministradorBean administrador = new AdministradorBean();
					administrador.setIdUsuario(resultado.getInt(1));
					administrador.setIdAdministrador(resultado.getInt(2));
					administrador.setNome(resultado.getString(5));
					
					con.close();
					
					return administrador;
				}
				
				if (resultado.getString(3) != null || resultado.getString(4) != null) {
					FuncionarioBean funcionario = new FuncionarioBean();
					
					funcionario.setIdUsuario(resultado.getInt(1));
					
					if (resultado.getString(3) != null) {
						funcionario.setIdFuncionario(resultado.getInt(3));
						funcionario.setFuncionarioAdmin(true);
						
						UnidadeBean unidade = new UnidadeBean();
						unidade.setIdUnidade(resultado.getInt(6));
						funcionario.setUnidade(unidade);
					} else {
						funcionario.setIdFuncionario(resultado.getInt(4));
						funcionario.setFuncionarioAdmin(false);
						
						UnidadeBean unidade = new UnidadeBean();
						unidade.setIdUnidade(resultado.getInt(6));
						funcionario.setUnidade(unidade);
					}

					funcionario.setNome(resultado.getString(5));
					
					con.close();
					
					return funcionario;
				}
				
				UsuarioBean usuarioAnonimo = new UsuarioBean();
				usuarioAnonimo.setIdUsuario(resultado.getInt(1));
				
				con.close();

				return usuarioAnonimo;
			}
			
			con.close();
			
			return null;


		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
