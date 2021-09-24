package com.letstravel.pagamento.exception;

public class ClientNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idClient;
	
	public ClientNotFoundException(String idClient) {
		super();
		this.idClient = idClient;
	}
	
	public String getIdClient() {
		return idClient;
	}
	
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
}
