package com.br.italogas.taskapp.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.br.italogas.taskapp.GerenciadorDeTarefasImpl;
import com.br.italogas.taskapp.R;
import com.br.italogas.taskapp.util.IdExistenteException;
import com.br.italogas.taskapp.util.InvalidDateException;
import com.br.italogas.taskapp.util.InvalidIdException;
import com.br.italogas.taskapp.util.Util;

public class AdicionarTarefaActivity extends ActionBarActivity {
	
	GerenciadorDeTarefasImpl gerenciador = GerenciadorDeTarefasImpl.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adicionar_tarefa);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adicionar_tarefa, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_adicionar_tarefa, container, false);
			return rootView;
		}
	}
	
	/**
	 * Coleta dados fornecidos por usuario e faz chamada ao sistema 
	 * @param view
	 */
	@SuppressLint("ShowToast")
	public void adicionarTarefa(View view){
		EditText editTextAtividade = (EditText) findViewById(R.id.atividade);
		DatePicker datePickerData = (DatePicker) findViewById(R.id.data);
		TimePicker timePickerHoraInicio = (TimePicker) findViewById(R.id.horaInicio);
		TimePicker timePickerHoraFim = (TimePicker) findViewById(R.id.horaFim);
		EditText editTextLocal = (EditText) findViewById(R.id.campo_local);
		EditText editTextObs = (EditText) findViewById(R.id.campo_obs);
		String atividade = editTextAtividade.getText().toString();
		int dia = datePickerData.getDayOfMonth();
		int mes = datePickerData.getMonth();
		int ano = datePickerData.getYear();
		String data = Util.formatarData(dia, mes, ano);
		Log.i("Data:", data);
		Integer horaAtualInicio = timePickerHoraInicio.getCurrentHour();
		Integer minutoAtualinicio = timePickerHoraInicio.getCurrentMinute();
		String horaInicio = Util.formatarHora(horaAtualInicio, minutoAtualinicio);
		Log.i("Hora: ", horaInicio);
		Integer horaAtualFim = timePickerHoraFim.getCurrentHour();
		Integer minutoAtualFim = timePickerHoraFim.getCurrentMinute();
		String horaFim = Util.formatarHora(horaAtualFim, minutoAtualFim);
		String local = editTextLocal.getText().toString();
		String obs = editTextObs.getText().toString();
		
		try {
			if(gerenciador.getTarefaPorId("0001") == null) {
				gerenciador.criarTarefa("0001", atividade, data, horaInicio, horaFim, local, obs);
			} else {
				gerenciador.criarTarefa("0002", atividade, data, horaInicio, horaFim, local, obs);
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Toast.makeText(this, R.string.tarefa_cadastrada_, Toast.LENGTH_SHORT).show();
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
