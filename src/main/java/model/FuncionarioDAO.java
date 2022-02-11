package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FuncionarioDAO {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public FuncionarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrar(FuncionarioBean funcionario) {
		
		UsuarioBean usuario = usuarioDAO.cadastrar(new UsuarioBean(funcionario.getEmail(), funcionario.getSenha()));
		
		if (usuario != null) {
			String query = "INSERT INTO funcionarios "
				+ "(nome, cpf, cargo, funcionario_admin, id_unidade_fk, id_usuario_fk) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			try {
				Connection con = Conexao.conectar();
	
				PreparedStatement prepare = con.prepareStatement(query);
	
				prepare.setString(1, funcionario.getNome());
				prepare.setString(2, funcionario.getCpf());
				prepare.setString(3, funcionario.getCargo());
				prepare.setInt(4, (funcionario.isFuncionarioAdmin() ? 1: 0));
				prepare.setInt(5, funcionario.getUnidade().getIdUnidade());
				prepare.setInt(6, usuario.getIdUsuario());
	
				prepare.executeUpdate();
	
				con.close();
	
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
