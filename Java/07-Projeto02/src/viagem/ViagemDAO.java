package viagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import usuario.Usuario;
import usuario.UsuarioDAO;

public class ViagemDAO {
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Connection conexao;

    public ViagemDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // CREAD - Viagem
    public void criarViagem(Viagem viagem) {
		String sql = "INSERT INTO viagem (ID_VIAGEM, ESTADO_V, CIDADE_V, ID_USUARIO) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, viagem.getID_VIAGEM());
			stmt.setString(2, viagem.getESTADO_V());
			stmt.setString(3, viagem.getCIDADE_V());
			stmt.setInt(4, viagem.getUsuario().getID_USUARIO());
			stmt.executeUpdate();
			System.out.println("Viagem criada com sucesso!\n");
		} catch (Exception e) {
			System.out.println("Nao foi possivel criar a viagem.\n" + e.getMessage());
		} 
	}
    
    // READ - Viagem
    public void lerTodasViagens() {
		//String sql = "SELECT * FROM viagem";
		String sql = "SELECT * FROM viagem as v " + "INNER JOIN usuario as u " + "ON v.ID_USUARIO = u.ID_USUARIO";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Viagem viagem = new Viagem();
				viagem.setID_VIAGEM(r.getInt("ID_VIAGEM"));
                viagem.setESTADO_V(r.getNString("ESTADO_V"));
                viagem.setCIDADE_V(r.getNString("CIDADE_V"));
                
                //viagem.setUsuario(usuarioDAO.buscarUsuario(r.getInt("ID_USUARIO")));
                
                Usuario usuario = new Usuario();
                usuario.setID_USUARIO(r.getInt("ID_USUARIO"));
                usuario.setNOME_U(r.getString("NOME_U"));
				System.out.printf("ID DA VIAGEM: %s\n Nome: %s\n Estado: %s\n Cidade: %s\n\n", viagem.getID_VIAGEM(),usuario.getNOME_U(), viagem.getESTADO_V(),
						viagem.getCIDADE_V());
			}
			if (!r.next()) {
				System.out.println("NAO HA MAIS DADOS");
			}
		} catch (SQLException e) {
			System.out.println("Nao foi possivel acessar as informacoes." + "Mensagem: " + e.getMessage());
		}
	}
    
    // UPDATE - Viagem
    public void atualizarViagem(Viagem viagem) {
		String sql = "UPDATE viagem SET ESTADO_V = ?, CIDADE_V = ?, ID_USUARIO = ? WHERE ID_VIAGEM = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, viagem.getESTADO_V());
			stmt.setString(2, viagem.getCIDADE_V());
			stmt.setInt(3, viagem.getUsuario().getID_USUARIO());
			stmt.setInt(4, viagem.getID_VIAGEM());
			stmt.executeUpdate();
			System.out.println("Viagem atualizada com sucesso!\n");
		} catch (SQLException e) {
			System.out.println(" Nao foi possivel atualizar a viagem." + "Mensagem: " + e.getMessage());
		}
	}
    
    // DELETE - Viagem
    public void deleteViagem(int id) {
		String sql = "DELETE FROM viagem WHERE ID_VIAGEM = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Viagem deletada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Nao foi possivel deletar a viagem." + "Mensagem: " + e.getMessage());
		}
	}
	
    public Viagem buscarViagem(int id) {
        Viagem viagem = null;
        String sql = "SELECT * FROM viagem WHERE ID_VIAGEM = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                viagem = new Viagem();
                viagem.setID_VIAGEM(resultado.getInt("ID_VIAGEM"));
                viagem.setESTADO_V(resultado.getNString("ESTADO_V"));
                viagem.setCIDADE_V(resultado.getNString("CIDADE_V"));
                viagem.setUsuario(usuarioDAO.buscarUsuario(resultado.getInt("ID_USUARIO")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viagem;
    }
    
    
}
