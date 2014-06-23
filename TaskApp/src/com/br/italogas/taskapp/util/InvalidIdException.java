package com.br.italogas.taskapp.util;

public class InvalidIdException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String MENSAGEM = "Id de tarefa invalido"; 

	public InvalidIdException() {
		// TODO Auto-generated constructor stub
		super(MENSAGEM);
	}

	public InvalidIdException(String message) {
		// TODO Auto-generated constructor stub
		super(MENSAGEM + ": " + message);
	}

}
