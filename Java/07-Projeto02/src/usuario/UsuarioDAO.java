package usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import conexao.Conexao;

public class UsuarioDAO {
	
	private Connection conexao;

    public UsuarioDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	//CREATE - Usuário
	public void criarUsuario(Usuario usuario) {

		String sql = "INSERT INTO usuario(NOME_U,EMAIL_U,SENHA_U)" + " VALUES(?,?,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setString(1, usuario.getNOME_U());
			stmt.setString(2, usuario.getEMAIL_U());
			stmt.setString(3, usuario.getSENHA_U());
            stmt.executeUpdate();
            System.out.println("Usuário criado com sucesso!\n");
		} catch (Exception e) {
			System.out.println("Nao foi possivel criar o usuário." + e.getMessage());
		} 
	}
	
	// READ - Usuário 
		public void lerTodosUsuarios() {
			String sql = "SELECT * FROM usuario";
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				ResultSet r = stmt.executeQuery();
				while (r.next()) {
					Usuario usuario = new Usuario();
					usuario.setID_USUARIO(r.getInt("ID_USUARIO"));
					usuario.setNOME_U(r.getString("NOME_U"));
					usuario.setEMAIL_U(r.getString("EMAIL_U"));
					usuario.setSENHA_U(r.getString("SENHA_U"));

					System.out.printf("ID DO USUÁRIO: %s\n Nome: %s\n Email: %s\n senha: %s\n\n", usuario.getID_USUARIO(), usuario.getNOME_U(),
							usuario.getEMAIL_U(), usuario.getSENHA_U());

				}
				if (!r.next()) {
					System.out.println("NAO HA MAIS DADOS");
				}
			} catch (SQLException e) {
				System.out.println("Nao foi possivel acessar as informacoes." + "Mensagem: " + e.getMessage());
			}
		}
		
	// UPDATE - Usuário
		public void atualizarUsuario(Usuario usuario) {
			String sql = "UPDATE usuario SET NOME_U = ?, EMAIL_U = ?, SENHA_U = ? WHERE ID_USUARIO = ?";
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setString(1, usuario.getNOME_U());
				stmt.setString(2, usuario.getEMAIL_U());
				stmt.setString(3, usuario.getSENHA_U());
				stmt.setInt(4, usuario.getID_USUARIO());
				stmt.executeUpdate();
				System.out.println("Usuário atualizado com sucesso!\n");
			} catch (SQLException e) {
				System.out.println(" Nao foi possivel atualizar o usuário." + "Mensagem: " + e.getMessage());
			}
		}
		
	// DELETE - Usuário
		public void deleteUsuario(int id) {
			String sql = "DELETE FROM usuario WHERE ID_USUARIO = ?";
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
				System.out.println("Usuário deletado com sucesso!");
			} catch (SQLException e) {
				System.out.println("Nao foi possivel deletar o usuário." + "Mensagem: " + e.getMessage());
			}
		}
		
		public Usuario buscarUsuario(int id) {
	        Usuario usuario = null;
	        String sql = "SELECT * FROM usuario WHERE ID_USUARIO = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            ResultSet resultado = stmt.executeQuery();
	            if (resultado.next()) {
	                usuario = new Usuario();
	                usuario.setID_USUARIO(resultado.getInt("ID_USUARIO"));
	                usuario.setNOME_U(resultado.getString("NOME_U"));
	                usuario.setEMAIL_U(resultado.getString("EMAIL_U"));
	                usuario.setSENHA_U(resultado.getString("SENHA_U"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return usuario;
	    }
}