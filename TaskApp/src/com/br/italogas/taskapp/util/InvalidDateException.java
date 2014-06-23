package com.br.italogas.taskapp.util;

public class InvalidDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String MENSAGEM = "Formato de data invalido";

	public InvalidDateException() {
		// TODO Auto-generated constructor stub
		super(MENSAGEM);
	}

	public InvalidDateException(String detailMessage) {
		super(MENSAGEM + ":" + detailMessage);
		// TODO Auto-generated constructor stub
	}

}
