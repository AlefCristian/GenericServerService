package model;

/**
 * Created by alef on 19/11/16.
 */

public class Usuario {
	private final int cod;
    private String login;
    private String password;
    private String nivel;
    
    public Usuario(String login, String password, String nivel) {
    	this.cod = 0;
    	this.login = login;
    	this.password = password;
    	this.nivel = nivel;
    }
    /**
     * Construtor utilizado apenas por DAO
     */
    public Usuario(int cod, String login, String password) {
    	this.cod = cod;
        this.login = login;
        this.password  = password;
    }
    
    public int getCod() {
    	return this.cod;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }
    
    public Usuario setNivel(String nivel) {
    	this.nivel = nivel;
    	return this;
    }
    
    public String getNivel() {
    	return this.nivel;
    }
    
    public enum Colum {
    	COD, LOGIN, PASSWORD, NIVEL;    	
    }
}
