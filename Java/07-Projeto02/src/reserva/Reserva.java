package reserva;

import java.util.Date;

import usuario.Usuario;
import viagem.Viagem;

public class Reserva {
	
	private int ID_RESERVA;
	private double VALOR;
	private Date DATA_INICIO;
	private Date DATA_FIM;
	private Usuario usuario;
	private Viagem viagem;
	
	public Reserva() {
		super();
	}
	
	public Reserva(int iD_RESERVA, double vALOR, Date dATA_INICIO, Date dATA_FIM, Usuario usuario, Viagem viagem) {
		super();
		ID_RESERVA = iD_RESERVA;
		VALOR = vALOR;
		DATA_INICIO = dATA_INICIO;
		DATA_FIM = dATA_FIM;
		this.usuario = usuario;
		this.viagem = viagem;
	}

	public int getID_RESERVA() {
		return ID_RESERVA;
	}

	public void setID_RESERVA(int iD_RESERVA) {
		ID_RESERVA = iD_RESERVA;
	}

	public double getVALOR() {
		return VALOR;
	}

	public void setVALOR(double vALOR) {
		VALOR = vALOR;
	}

	public Date getDATA_INICIO() {
		return DATA_INICIO;
	}

	public void setDATA_INICIO(Date dATA_INICIO) {
		DATA_INICIO = dATA_INICIO;
	}

	public Date getDATA_FIM() {
		return DATA_FIM;
	}

	public void setDATA_FIM(Date dATA_FIM) {
		DATA_FIM = dATA_FIM;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	@Override
	public String toString() {
		return "Reserva [ID_RESERVA=" + ID_RESERVA + ", VALOR=" + VALOR + ", DATA_INICIO=" + DATA_INICIO + ", DATA_FIM="
				+ DATA_FIM + ", usuario=" + usuario + ", viagem=" + viagem + "]";
	}	
}