package com.br.italogas.taskapp.test;

import org.junit.Before;
import org.junit.Test;

import com.br.italogas.taskapp.Tarefa;
import com.br.italogas.taskapp.util.InvalidDateException;
import com.br.italogas.taskapp.util.InvalidIdException;

public class TestaTarefa {
	
	Tarefa t1;
	String id;
	String atividade;
	String data;
	String horaInicio;
	String horaFim;
	String local;
	String obs;
	

	@Before
	public void setUp() throws Exception {
		id = "001";
		atividade = "Jantar na casa de Italo";
		data = "21/06/2014";
		horaInicio = "12:00";
		horaFim = "14:00";
		local = "Casa de Italo";
		obs = "Levar sobremesa";
	}

	@Test (expected = InvalidIdException.class)
	public void testaIdInvalido0() throws InvalidIdException, InvalidDateException {
		t1 = new Tarefa(null, atividade, data, horaInicio, horaFim, local, obs);
	}
	
	@Test (expected = InvalidIdException.class)
	public void testaIdInvalido1() throws InvalidIdException, InvalidDateException {
		t1 = new Tarefa("", atividade, data, horaInicio, horaFim, local, obs);
	}
	
	@Test (expected = InvalidIdException.class)
	public void testaIdInvalido2() throws InvalidIdException, InvalidDateException {
		t1 = new Tarefa("aaa", atividade, data, horaInicio, horaFim, local, obs);
	}
	
	@Test (expected = InvalidDateException.class)
	public void testaDataInvalida0() throws InvalidDateException {
		try {
			t1 = new Tarefa(id, atividade, "12///212", horaInicio, horaFim, local, obs);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test (expected = InvalidDateException.class)
	public void testaDataInvalida1() throws InvalidDateException {
		try {
			t1 = new Tarefa(id, atividade, "00/12/2014", horaInicio, horaFim, local, obs);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Test (expected = InvalidDateException.class)
	public void testaDataInvalida2() throws InvalidDateException {
		try {
			t1 = new Tarefa(id, atividade, "01/13/2014", horaInicio, horaFim, local, obs);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Test (expected = InvalidDateException.class)
	public void testaDataInvalida3() throws InvalidDateException {
		try {
			t1 = new Tarefa(id, atividade, "01/08/2013", horaInicio, horaFim, local, obs);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


}
