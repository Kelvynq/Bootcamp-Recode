package reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;


import conexao.Conexao;
import usuario.Usuario;
import usuario.UsuarioDAO;
import viagem.Viagem;
import viagem.ViagemDAO;

public class ReservaDAO {
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	ViagemDAO viagemDAO = new ViagemDAO();
	private Connection conexao;
	
	public ReservaDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	// CREAD - Reserva
	public void criarReserva(Reserva reserva) {
		String sql = "INSERT INTO reserva (ID_RESERVA, VALOR, DATA_INICIO, DATA_FIM, ID_USUARIO, ID_VIAGEM) VALUES (?,?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, reserva.getID_RESERVA());
			stmt.setDouble(2, reserva.getVALOR());
			stmt.setTimestamp(3, new java.sql.Timestamp(reserva.getDATA_INICIO().getTime()));
			stmt.setDate(4, new Date(reserva.getDATA_FIM().getTime()));
			stmt.setInt(5, reserva.getUsuario().getID_USUARIO());
			stmt.setInt(6, reserva.getViagem().getID_VIAGEM());
			stmt.executeUpdate();
			System.out.println("Reserva criada com sucesso!\n");
		} catch (Exception e) {
			System.out.println("Nao foi possivel criar a reserva.\n" + e.getMessage());
		} 
	}
    
    // READ - Reserva
    public void lerTodasReservas() {
		//String sql = "SELECT * FROM reserva";
			String sql = "SELECT * FROM reserva as r " + "INNER JOIN usuario as u " + "ON r.ID_USUARIO = u.ID_USUARIO";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Reserva reserva = new Reserva();
				reserva.setID_RESERVA(r.getInt("ID_RESERVA"));
                reserva.setVALOR(r.getDouble("VALOR"));
                reserva.setDATA_INICIO(r.getDate("DATA_INICIO"));
                reserva.setDATA_FIM(r.getDate("DATA_FIM"));
                reserva.setUsuario(usuarioDAO.buscarUsuario(r.getInt("ID_USUARIO")));
                reserva.setViagem(viagemDAO.buscarViagem(r.getInt("ID_VIAGEM")));
                
                Usuario usuario = new Usuario();
                usuario.setID_USUARIO(r.getInt("ID_USUARIO"));
                usuario.setNOME_U(r.getString("NOME_U"));
                
                Viagem viagem = new Viagem();
                viagem.setID_VIAGEM(r.getInt("ID_VIAGEM"));
                
				System.out.printf("ID DA RESERVA: %s\n Nome: %s\n Check-in: %s\n Check-out: %s\n \n",  reserva.getID_RESERVA(),usuario.getNOME_U(), reserva.getDATA_INICIO(),
						reserva.getDATA_FIM());
			}
			if (!r.next()) {
				System.out.println("NAO HA MAIS DADOS");
			}
		} catch (SQLException e) {
			System.out.println("Nao foi possivel acessar as informacoes." + "Mensagem: " + e.getMessage());
		}
	}
    
    // UPDATE - Reserva
    public void atualizarReserva(Reserva reserva) {
		String sql = "UPDATE reserva SET VALOR = ?, DATA_INICIO = ?, DATA_FIM = ?, ID_USUARIO = ?,ID_VIAGEM = ? WHERE ID_RESERVA = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setDouble(1, reserva.getVALOR());
			stmt.setDate(2, new Date(reserva.getDATA_INICIO().getTime()));
			stmt.setDate(3, new Date(reserva.getDATA_FIM().getTime()));
			stmt.setInt(4, reserva.getUsuario().getID_USUARIO());
			stmt.setInt(5, reserva.getViagem().getID_VIAGEM());
			stmt.setInt(6, reserva.getID_RESERVA());
			stmt.executeUpdate();
			System.out.println("Reserva atualizada com sucesso\n");
		} catch (SQLException e) {
			System.out.println(" Nao foi possivel atualizar a reserva." + "Mensagem: " + e.getMessage());
		}
	}
    
    // DELETE - Reserva
    public void deleteReserva(int id) {
		String sql = "DELETE FROM reserva WHERE ID_RESERVA = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Reserva deletada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Nao foi possivel deletar a Reserva." + "Mensagem: " + e.getMessage());
		}
	}

}
