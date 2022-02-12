package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	public ArrayList<FuncionarioBean> listar(FuncionarioBean funcionarioFiltro) {
		
		ArrayList<FuncionarioBean> funcionarios = new ArrayList<>();
		
		String query = "SELECT id_funcionario, nome, cpf, cargo, id_unidade_fk, id_usuario_fk"
			+ "FROM funcionarios f WHERE funcionario_admin = ? ";
			
		if (funcionarioFiltro.getUnidade() != null) {
			query += " AND id_unidade_fk = ? ";
		}

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);
			
			prepare.setInt(1, (funcionarioFiltro.isFuncionarioAdmin() ? 1: 0));
			
			if (funcionarioFiltro.getUnidade() != null) {
				prepare.setInt(2, funcionarioFiltro.getUnidade().getIdUnidade());
			}

			ResultSet resultado = prepare.executeQuery();
			
			while (resultado.next()) {
				
				FuncionarioBean funcionario = new FuncionarioBean();
				
				funcionario.setIdFuncionario(resultado.getInt(1));
				funcionario.setNome(resultado.getString(2));
				funcionario.setCpf(resultado.getString(3));
				funcionario.setCargo(resultado.getString(4));

				UnidadeBean unidadeFuncionario = new UnidadeBean();
				unidadeFuncionario.setIdUnidade(resultado.getInt(5));
				
				funcionario.setIdUsuario(resultado.getInt(6));

				funcionarios.add(funcionario);
			}

			con.close();
			
			return funcionarios;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void excluir(FuncionarioBean funcionario) {
		
		String query = "DELETE FROM funcionarios WHERE id_funcionario = ?";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);

			prepare.setInt(1, funcionario.getIdFuncionario());

	        if (prepare.executeUpdate() == 0) {
	            throw new Exception("Erro na exclusão do funcionário.");
	        }

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
