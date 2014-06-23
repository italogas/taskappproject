package com.br.italogas.taskapp.util;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	public static String formatarData(int dia, int mes, int ano){
		String stringDia = (dia < 10) ? "0" + dia : "" + dia;
		String stringMes = (mes < 10) ? "0" + mes : "" + mes;
		String data = stringDia + "/" + stringMes + "/" + ano;
		return data;
	}
	
	public static String formatarHora(Integer hora, Integer minuto){
		String stringHora = (hora < 10) ? "0" + hora : "" + hora;
		String stringMinuto = (minuto < 10) ? "0" + minuto : "" + minuto;
		String stringTempo = stringHora + ":" + stringMinuto;
		return stringTempo;
		
	}

}
