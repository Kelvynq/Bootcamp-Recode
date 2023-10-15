package usuario;

public class Usuario {
	
	private int ID_USUARIO;
	private String NOME_U;
	private String EMAIL_U;
	private String SENHA_U;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int iD_USUARIO, String nOME_U, String eMAIL_U, String sENHA_U) {
		super();
		ID_USUARIO = iD_USUARIO;
		NOME_U = nOME_U;
		EMAIL_U = eMAIL_U;
		SENHA_U = sENHA_U;
	}
	
	public int getID_USUARIO() {
		return ID_USUARIO;
	}
	public void setID_USUARIO(int iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}
	public String getNOME_U() {
		return NOME_U;
	}
	public void setNOME_U(String nOME_U) {
		NOME_U = nOME_U;
	}
	public String getEMAIL_U() {
		return EMAIL_U;
	}
	public void setEMAIL_U(String eMAIL_U) {
		EMAIL_U = eMAIL_U;
	}
	public String getSENHA_U() {
		return SENHA_U;
	}
	public void setSENHA_U(String sENHA_U) {
		SENHA_U = sENHA_U;
	}

	@Override
	public String toString() {
		return "Usuario [ID_USUARIO=" + ID_USUARIO + ", NOME_U=" + NOME_U + ", EMAIL_U=" + EMAIL_U + ", SENHA_U="
				+ SENHA_U + "]";
	}
}
