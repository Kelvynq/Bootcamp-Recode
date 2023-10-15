package viagem;

import usuario.Usuario;

public class Viagem {
	
	private int ID_VIAGEM;
	private String ESTADO_V;
	private String CIDADE_V;
	private Usuario usuario;
	
	public Viagem() {
		super();
	}

	public Viagem(int iD_VIAGEM, String eSTADO_V, String cIDADE_V, Usuario usuario) {
		super();
		ID_VIAGEM = iD_VIAGEM;
		ESTADO_V = eSTADO_V;
		CIDADE_V = cIDADE_V;
		this.usuario = usuario;
	}

	public int getID_VIAGEM() {
		return ID_VIAGEM;
	}

	public void setID_VIAGEM(int iD_VIAGEM) {
		ID_VIAGEM = iD_VIAGEM;
	}

	public String getESTADO_V() {
		return ESTADO_V;
	}

	public void setESTADO_V(String eSTADO_V) {
		ESTADO_V = eSTADO_V;
	}

	public String getCIDADE_V() {
		return CIDADE_V;
	}

	public void setCIDADE_V(String cIDADE_V) {
		CIDADE_V = cIDADE_V;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Viagem [ID_VIAGEM=" + ID_VIAGEM + ", ESTADO_V=" + ESTADO_V + ", CIDADE_V=" + CIDADE_V + ", usuario="
				+ usuario + "]";
	}
}