package com.br.italogas.taskapp.util;

public class IdExistenteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM = "Ja existe Tarefa caastrada com esse Id.";

	public IdExistenteException() {
		// TODO Auto-generated constructor stub
		super(MENSAGEM);
	}

}
