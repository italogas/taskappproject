/**
 * 
 */
package com.br.italogas.taskapp.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.br.italogas.taskapp.GerenciadorDeTarefas;
import com.br.italogas.taskapp.GerenciadorDeTarefasImpl;
import com.br.italogas.taskapp.Tarefa;
import com.br.italogas.taskapp.util.IdExistenteException;
import com.br.italogas.taskapp.util.InvalidDateException;
import com.br.italogas.taskapp.util.InvalidIdException;

/**
 * @author Italo
 *
 */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class TestaGerenciadorDeTarefas {
	
	GerenciadorDeTarefas gerenciador;
	Tarefa t1;
	Tarefa tarefaAntes;
	String id;
	String atividade;
	String data;
	String horaInicio;
	String horaFim;
	String local;
	String obs;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		gerenciador = GerenciadorDeTarefasImpl.getInstance();
		id = "0001";
		atividade  = "Fazer compras.";
		data = "08/05/2014";
		horaInicio = "08:00";
		horaFim  ="10:00";
		local = "Supermecado Z";
		obs = "Observacoes";
		t1 = new Tarefa(id, atividade, data, horaInicio, horaFim, local, obs);
	}

	@Test
	public void testaCriarTarefa0() {
		try{
			gerenciador.criarTarefa(id, atividade, data, horaInicio, horaFim, local, obs);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		Tarefa tarefa = null;
		try{
			tarefa = gerenciador.getTarefaPorId("0001");
		} catch(InvalidIdException i){
			i.printStackTrace();
		}
		
		assertEquals(t1.getId(), tarefa.getId());
		assertEquals(t1.getAtividade(), tarefa.getAtividade());
		assertEquals(t1.getData(), tarefa.getData());
		assertEquals(t1.getHoraInicio(), tarefa.getHoraInicio());
		assertEquals(t1.getLocal(), tarefa.getLocal());
		assertEquals(t1.getObs(), tarefa.getObs());
	}
	
	@Test (expected = IdExistenteException.class)
	public void testaCriarTarefa1() throws Exception {
		gerenciador.criarTarefa("0001", "Fazer compras.", "08/05/2014", "08:00", "10:00", "Supermecado Z", "Observacoes");
	}
	
	@Test (expected = InvalidIdException.class)
	public void testaCriarTarefa2() throws Exception {
		gerenciador.criarTarefa(null, "Jantar na casa de aninha.", "10/05/2014", "19:00", "22:00", "Casa de aninha", null);
	}
	
	@Test (expected = InvalidIdException.class)
	public void testaCriarTarefa3() throws Exception {
		gerenciador.criarTarefa("", "Jantar na casa de aninha.", "10/05/2014", "19:00" , "22:00", "Casa de aninha", null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaCriarTarefa4() throws Exception {
		gerenciador.criarTarefa("0002", null, "10/05/2014", "19:00" , "22:00", "Casa de aninha", null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaCriarTarefa5() throws Exception {
		gerenciador.criarTarefa("0002", "", "10/05/2014", "19:00" , "22:00", "Casa de aninha", null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaCriarTarefa6() throws Exception {
		gerenciador.criarTarefa("0002", "Jantar na casa de aninha.", null, "19:00" , "22:00", "Casa de aninha", null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaCriarTarefa7() throws Exception {
		gerenciador.criarTarefa("0002", "Jantar na casa de aninha.", "", "19:00" , "22:00", "Casa de aninha", null);
	}

	
	/*
	 * 
	//Teste que recupera tarefa para testar modificacoes feitas a seguir.
	
	@Test
	public void testaEditarTarefa() {
		tarefaAntes = null;
		try{
			tarefaAntes = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		}
	}  */
	
	@Test
	public void testaEditarTarefa0() throws InvalidIdException, InvalidDateException{
		Tarefa tarefaAntes = null;
		try{
			tarefaAntes = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		}
		assertEquals(atividade, tarefaAntes.getAtividade());
		Tarefa tarefaDepois = null;
		try{
			gerenciador.editarTarefa("0001", GerenciadorDeTarefasImpl.ATIVIDADE, "Estudar ATAL. ");
			tarefaDepois = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		} catch (InvalidDateException d) {
			// TODO Auto-generated catch block
			d.printStackTrace();
		}
		assertEquals("Estudar ATAL. ", tarefaDepois.getAtividade());
		
	}
	
	@Test
	public void testaEditarTarefa1() {
		Tarefa tarefaAntes = null;
		try{
			tarefaAntes = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		}
		assertEquals(data, tarefaAntes.getData());
		Tarefa tarefaDepois = null;
		try{
			gerenciador.editarTarefa("0001", GerenciadorDeTarefasImpl.DATA, "03/06/2014");
			tarefaDepois = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		} catch (InvalidDateException d) {
			// TODO Auto-generated catch block
			d.printStackTrace();
		}
		assertEquals("03/06/2014", tarefaDepois.getData());
		
	}
	
	@Test
	public void testaEditarTarefa2() {
		Tarefa tarefaAntes = null;
		try{
			tarefaAntes = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		}
		assertEquals(horaInicio, tarefaAntes.getHoraInicio());
		
		Tarefa tarefaDepois = null;
		try{
			gerenciador.editarTarefa("0001", GerenciadorDeTarefasImpl.HORA_INICIO, "09:00");
			tarefaDepois = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		} catch (InvalidDateException d) {
			// TODO Auto-generated catch block
			d.printStackTrace();
		}
		assertEquals("09:00", tarefaDepois.getHoraInicio());
		
	}
	
	@Test
	public void testaEditarTarefa3(){
		Tarefa tarefaAntes = null;
		try{
			tarefaAntes = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		}
		assertEquals(horaFim, tarefaAntes.getHoraFim());
		
		Tarefa tarefaDepois = null;
		try{
			gerenciador.editarTarefa("0001", GerenciadorDeTarefasImpl.HORA_FIM, "11:00");
			tarefaDepois = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		} catch (InvalidDateException d) {
			// TODO Auto-generated catch block
			d.printStackTrace();
		}
		assertEquals("11:00", tarefaDepois.getHoraFim());
		
	} 
	
	@Test
	public void testaEditarTarefa4() {
		Tarefa tarefaAntes = null;
		try{
			tarefaAntes = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		}
		assertEquals(local, tarefaAntes.getLocal());
		
		Tarefa tarefaDepois = null;
		try{
			gerenciador.editarTarefa("0001", GerenciadorDeTarefasImpl.LOCAL, "Supermecado X");
			tarefaDepois = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		} catch (InvalidDateException d) {
			// TODO Auto-generated catch block
			d.printStackTrace();
		}
		assertEquals("Supermecado X", tarefaDepois.getLocal());
		
	}
	
	@Test
	public void testaEditarTarefa5() {
		Tarefa tarefaAntes = null;
		try{
			tarefaAntes = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		}
		assertEquals(obs, tarefaAntes.getObs());
		
		Tarefa tarefaDepois = null;
		try{
			gerenciador.editarTarefa("0001", GerenciadorDeTarefasImpl.OBSERVACAO, "Nenhuma");
			tarefaDepois = gerenciador.getTarefaPorId("0001");
		} catch (InvalidIdException e){
			e.printStackTrace();
		} catch (InvalidDateException d) {
			// TODO Auto-generated catch block
			d.printStackTrace();
		}
		assertEquals("Nenhuma", tarefaDepois.getObs());
		
	} 
	
	@Test (expected = IllegalArgumentException.class)
	public void testaEditarTarefa6() {
		try {
			gerenciador.editarTarefa("0001", "Qualquer coisa", "Nenhuma");	
		} catch (InvalidIdException e) {
			e.printStackTrace();
		} catch (InvalidDateException d){
			d.printStackTrace();
		}
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaEditarTarefa7() {
		try{
			gerenciador.editarTarefa("0001", "", "Nenhuma");
		} catch (InvalidIdException e){
			e.printStackTrace();
		} catch (InvalidDateException d){
			d.printStackTrace();
		}
		
	} 
	
	@Test (expected = IllegalArgumentException.class)
	public void testaEditarTarefa8() {
		try{
			gerenciador.editarTarefa("0001", null, "Nenhuma");
		} catch (InvalidIdException e){
			e.printStackTrace();
		} catch (InvalidDateException d){
			d.printStackTrace();
		}
		
	}
	
	@Test (expected = InvalidIdException.class)
	public void testaRemoverTarefa0() throws InvalidIdException{
		try{
			gerenciador.removerTarefa(id);
		} catch(InvalidIdException e){
			e.printStackTrace();
		}
		
		gerenciador.getTarefaPorId(id);
	}
	
	@Test (expected = InvalidIdException.class)
	public void testaRemoverTarefa1() throws InvalidIdException{
		gerenciador.removerTarefa(null);

	}
	
	@Test (expected = InvalidIdException.class)
	public void testaRemoverTarefa2() throws InvalidIdException{
		gerenciador.removerTarefa("");

	}
	
	
	
}

