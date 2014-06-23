package com.br.italogas.taskapp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GerenciadorDeIds {
	
	static GerenciadorDeIds gerenciadorIds;
	
	private final String arquivoIds = "arquivoDeIds"; 
	private Integer id;
	
	private GerenciadorDeIds(){
		try {
			recuperarEstado();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			id = 0000;
		}
	}

	public static GerenciadorDeIds getInstance() {
		// TODO Auto-generated method stub
		if(gerenciadorIds == null){
			gerenciadorIds = new GerenciadorDeIds();
		}
		return gerenciadorIds;
	}

	public String getNextId() {
		// TODO Auto-generated method stub
		id += 1;
		salvarEstado();
		return id.toString();
	}

	public void salvarEstado() {
		// TODO Auto-generated method stub
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new BufferedOutputStream
					(new FileOutputStream(arquivoIds)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			out.writeUTF(id.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void recuperarEstado() throws EOFException{
		// TODO Auto-generated method stub
		DataInputStream in = null;
		try {
			in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(arquivoIds)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			id = Integer.parseInt(in.readUTF());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void removerId() {
		// TODO Auto-generated method stub
		id-=id;
		salvarEstado();
	}

	public String getIdAtual() {
		// TODO Auto-generated method stub
		return id.toString();
	}

}
