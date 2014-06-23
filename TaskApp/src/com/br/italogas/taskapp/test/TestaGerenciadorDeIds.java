package com.br.italogas.taskapp.test;

import static org.junit.Assert.*;

import java.io.EOFException;

import org.junit.Before;
import org.junit.Test;

import com.br.italogas.taskapp.GerenciadorDeIds;

public class TestaGerenciadorDeIds {
	
	GerenciadorDeIds gerenciadorIds;

	String id1;
	String id2;
	
	@Before
	public void setUp() throws Exception {
		gerenciadorIds = GerenciadorDeIds.getInstance();
		id1 = "0";
		id2 = "1";
	}

	@Test
	public void testInicializacao() {
		assertEquals(id1, gerenciadorIds.getIdAtual());
	}
	
	@Test
	public void testReinicializacao() {
		gerenciadorIds.getNextId();
		gerenciadorIds.salvarEstado();
		try {
			gerenciadorIds.recuperarEstado();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(id2, gerenciadorIds.getIdAtual());
	}
	
	@Test
	public void testRemocao() {
		gerenciadorIds.removerId();
		assertEquals(id1, gerenciadorIds.getIdAtual());
	}

}
