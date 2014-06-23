/**
 * 
 */
package com.br.italogas.taskapp;

import java.util.Calendar;

import com.br.italogas.taskapp.util.InvalidDateException;
import com.br.italogas.taskapp.util.InvalidIdException;

/**
 * @author Ítalo
 *
 */
public class Tarefa {

	private String id;
	private String atividade;
	private String data;
	private String horaInicio;
	private String horaFim;
	private String local;
	private String obs;

	public Tarefa(String id, String atividade, String data,
			String horaInicio, String horaFim, String local, String obs) throws InvalidIdException, InvalidDateException {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setAtividade(atividade);
		this.setData(data);
		this.setHoraInicio(horaInicio);
		this.setHoraFim(horaFim);
		this.setLocal(local);
		this.setObs(obs);
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws InvalidIdException {
		if(id == null || id == "") { throw new InvalidIdException(); }
		
		try {
			Integer.parseInt(id);
		} catch (NumberFormatException n){
			throw new InvalidIdException(n.getMessage());
		}
		
		this.id = id;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) throws InvalidDateException{
		if(data.length() == 10 && data.charAt(2) == '/' && data.charAt(5) == '/'){
			String[] dataArray = data.split("/");
			if(checkDia(dataArray[0]) && checkMes(dataArray[1]) && checkAno(dataArray[2])){
				this.data = data;
			} else {
				throw new InvalidDateException();
			}
		} else {
			throw new InvalidDateException();
		}
	}

	@SuppressWarnings("deprecation")
	private boolean checkAno(String string) {
		Integer ano = Integer.parseInt(string);
		Calendar dataAtual = Calendar.getInstance();
		int anoAtual = 1900 + dataAtual.getTime().getYear();
		if(ano >= anoAtual) return true;
		return false;
		// TODO Auto-generated method stub
		
	}

	private boolean checkMes(String string) {
		Integer mes = Integer.parseInt(string);
		if(mes > 0 && mes < 13){
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	private boolean checkDia(String string) {
		Integer dia = Integer.parseInt(string);
		if(dia > 0 && dia < 32){
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getAtividade() + " no dia: " + getData() + " a partir de: " + getHoraInicio() +
				" ate: " + getHoraFim() + "." + " Local: " + getLocal() + ", Obs: " + getObs();
	}

}
