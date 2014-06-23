/**
 * 
 */
package com.br.italogas.taskapp;

import java.util.HashMap;
import java.util.Map;

import com.br.italogas.taskapp.util.IdExistenteException;
import com.br.italogas.taskapp.util.InvalidDateException;
import com.br.italogas.taskapp.util.InvalidIdException;

/**
 * @author Ítalo
 *
 */
public class GerenciadorDeTarefasImpl implements GerenciadorDeTarefas{
	
	public static final String ATIVIDADE = "com.br.italogas.taskapp.ATIVIDADE";
	public static final String DATA = "com.br.italogas.taskapp.DATA";
	public static final String HORA_INICIO = "com.br.italogas.taskapp.HORA_INICIO";
	public static final String HORA_FIM = "com.br.italogas.taskapp.HORA_FIM";
	public static final String LOCAL = "com.br.italogas.taskapp.LOCAL";
	public static final String OBSERVACAO = "com.br.italogas.taskapp.OBSERVACAO";
	
	private static GerenciadorDeTarefasImpl instancia;
	private Map<String, Tarefa> mapaDeTarefasPorId; 
	
	private GerenciadorDeTarefasImpl(){
		setMapaDeTarefasPorId(new HashMap<String, Tarefa>());
	}
	
	/**
	 * Singleton
	 * @return instancia de GerenciadorDeTarefasImpl
	 */
	public static synchronized GerenciadorDeTarefasImpl getInstance() {
		// TODO Auto-generated method stub
		if(instancia == null){
			instancia = new GerenciadorDeTarefasImpl();
		}
		return instancia;
	}

	@Override
	public void criarTarefa(String id, String atividade, String data,
			String horaInicio, String horaFim, String local, String obs) throws InvalidIdException, IdExistenteException, 
			IllegalArgumentException, InvalidDateException{
		// TODO Auto-generated method stub
		if(id == null || id == "") { throw new InvalidIdException(); }
		if(atividade == null || atividade == "") { throw new IllegalArgumentException("Atividade invalida."); }
		if(data == null || data == "") { throw new IllegalArgumentException("Data invalida."); }
		if(mapaDeTarefasPorId.containsKey(id)){ throw new IdExistenteException(); }
		
		mapaDeTarefasPorId.put(id, new Tarefa(id, atividade, data, horaInicio, horaFim, local, obs));
		
	}

	@Override
	public Tarefa getTarefaPorId(String id) throws InvalidIdException {
		// TODO Auto-generated method stub
		if(!mapaDeTarefasPorId.containsKey(id)){ throw new InvalidIdException(); }
		return mapaDeTarefasPorId.get(id);
	}

	public Map<String, Tarefa> getMapaDeTarefasPorId() {
		return mapaDeTarefasPorId;
	}

	public void setMapaDeTarefasPorId(Map<String, Tarefa> mapaDeTarefasPorId) {
		this.mapaDeTarefasPorId = mapaDeTarefasPorId;
	}

	@Override
	public void editarTarefa(String id, String campo, String novoValor) throws InvalidIdException, 
	InvalidDateException {
		// TODO Auto-generated method stub
		Tarefa tarefa = getTarefaPorId(id);
		if(campo == ATIVIDADE){
			tarefa.setAtividade(novoValor);
		} else if(campo == DATA){
			tarefa.setData(novoValor);
		} else if(campo == HORA_INICIO){
			tarefa.setHoraInicio(novoValor);
		} else if (campo == HORA_FIM){
			tarefa.setHoraFim(novoValor);
		} else if (campo == LOCAL){
			tarefa.setLocal(novoValor);
		} else if (campo == OBSERVACAO){
			tarefa.setObs(novoValor);
		} else {
			throw new IllegalArgumentException("Campo inválido. ");
		}
	}

	@Override
	public void removerTarefa(String id) throws InvalidIdException {
		// TODO Auto-generated method stub
		if(mapaDeTarefasPorId.containsKey(id)) { 
			mapaDeTarefasPorId.remove(id); 
		} else {
			throw new InvalidIdException();
		}
		
	}

}
