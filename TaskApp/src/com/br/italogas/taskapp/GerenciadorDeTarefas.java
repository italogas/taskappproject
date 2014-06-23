package com.br.italogas.taskapp;

import com.br.italogas.taskapp.util.IdExistenteException;
import com.br.italogas.taskapp.util.InvalidDateException;
import com.br.italogas.taskapp.util.InvalidIdException;

public interface GerenciadorDeTarefas {

	/**
	 * Método do sistema para criar nova Tarefa.
	 * @param id
	 * @param atividade
	 * @param data
	 * @param horaInicio
	 * @param horaFim
	 * @param local
	 * @param obs
	 * @throws InvalidIdException
	 * @throws IdExistenteException
	 * @throws InvalidDateException
	 */
	void criarTarefa(String id, String atividade, String data,
			String horaInicio, String horaFim, String local, String obs) throws InvalidIdException, IdExistenteException, InvalidDateException;

	/**
	 * Obtem tafera com identificador fornecido.
	 * @param id
	 * @return
	 * @throws InvalidIdException 
	 */
	Tarefa getTarefaPorId(String id) throws InvalidIdException;

	/**
	 * Edita tarefa correspondente ao id fornecido 
	 *  e o campo que se deseja editar.
	 * @param id
	 * @param campo
	 * @param novoValor
	 * @throws InvalidIdException 
	 * @throws InvalidDateException 
	 */
	void editarTarefa(String id, String campo, String novoValor) throws InvalidIdException, InvalidDateException;

	/**
	 * Remover tarefa correspondente ao id fornecido
	 * @param id
	 */
	void removerTarefa(String id) throws InvalidIdException;

}
