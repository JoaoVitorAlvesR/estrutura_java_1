package database.model;

public class Usuario {
	
	private int id;
	private String usuario;
	private String senha;
	private String perfil;
	
	public Usuario() {
		
	}
	
	
	public Usuario(String usuario, String senha, String perfil) {
		this.usuario = usuario;
		this.senha = senha;
		this.perfil = perfil;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getPerfil() {
		return perfil;
	}
}
