package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UnidadeDAO {

	public UnidadeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrar(UnidadeBean unidade) {
		
		String query = "INSERT INTO unidades (nome, regiao) VALUES (?,?)";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);

			prepare.setString(1, unidade.getNome());
			prepare.setString(2, unidade.getRegiao());
			

	        if (prepare.executeUpdate() == 0) {
	            throw new Exception("Erro na criação da unidade.");
	        }
	        
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<UnidadeBean> listar() {
		
		ArrayList<UnidadeBean> unidades = new ArrayList<>();
		
		String query = "SELECT id_unidade, nome, regiao "
			+ "FROM unidades u ";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);

			ResultSet resultado = prepare.executeQuery();
			
			while (resultado.next()) {
				
				int id_unidade = Integer.parseInt(resultado.getString(1)) ;
				String nome = resultado.getString(2);
				String regiao = resultado.getString(3);
				
				UnidadeBean unidade = new UnidadeBean(nome,regiao);
				unidade.setIdUnidade(id_unidade);

				unidades.add(unidade);
			}

			con.close();
			
			return unidades;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void excluir(UnidadeBean unidade) {
		
		String query = "DELETE FROM unidades WHERE id_unidade = ?";

		try {
			Connection con = Conexao.conectar();

			PreparedStatement prepare = con.prepareStatement(query);

			prepare.setInt(1, unidade.getIdUnidade());

	        if (prepare.executeUpdate() == 0) {
	            throw new Exception("Erro na exclusão da unidade.");
	        }

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
