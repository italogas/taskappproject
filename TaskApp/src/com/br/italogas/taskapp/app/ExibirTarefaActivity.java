package com.br.italogas.taskapp.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.br.italogas.taskapp.GerenciadorDeTarefasImpl;
import com.br.italogas.taskapp.R;
import com.br.italogas.taskapp.Tarefa;
import com.br.italogas.taskapp.util.InvalidIdException;

public class ExibirTarefaActivity extends ActionBarActivity {
	
	GerenciadorDeTarefasImpl gerenciador;

	@SuppressLint({ "NewApi", "InlinedApi" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		gerenciador = GerenciadorDeTarefasImpl.getInstance();
		
		Intent intent = getIntent();
		String stringExtra = intent.getStringExtra(VisualizarTarefasActivity.EXTRA_MESSAGE);
		Tarefa tarefa = null;
		try {
			tarefa = gerenciador.getTarefaPorId(stringExtra);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String atividade = "Atividade: " + tarefa.getAtividade();
		String data = "Data: " + tarefa.getData();
		String horario = "De: " + tarefa.getHoraInicio() + ", "+ " até: " + tarefa.getHoraFim();
		String local = "Local: " + tarefa.getLocal();
		String obs = "Tarefa: " + tarefa.getObs(); 
		
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);;
		
		TextView textViewAtividade = new TextView(this);
		textViewAtividade.setText(atividade);
		textViewAtividade.setTextSize(20); 
		linearLayout.addView(textViewAtividade);
		
		TextView textViewData = new TextView(this);
		textViewData.setText(data);
		textViewData.setTextSize(20);
		linearLayout.addView(textViewData);
		
		TextView textViewHora = new TextView(this);
		textViewHora.setText(horario);
		textViewHora.setTextSize(20);
		linearLayout.addView(textViewHora);
		
		TextView textViewLocal = new TextView(this);
		textViewLocal.setText(local);
		textViewLocal.setTextSize(20);
		linearLayout.addView(textViewLocal);
		
		TextView textViewObs = new TextView(this);
		textViewObs.setText(obs);
		textViewObs.setTextSize(20);
		linearLayout.addView(textViewObs);
		
		Button botaoEditarTarefa = new Button(this);
		botaoEditarTarefa.setText("Editar Tarefa");
		botaoEditarTarefa.setWidth(100);
		botaoEditarTarefa.setGravity(Button.TEXT_ALIGNMENT_CENTER);
		botaoEditarTarefa.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ExibirTarefaActivity.this, AdicionarTarefaActivity.class);
				startActivity(intent);
			}
		});
		linearLayout.addView(botaoEditarTarefa);
		
		setContentView(linearLayout);
		
		/* try {
			TextView textViewAtividade = (TextView) findViewById(R.id.textViewAtividade);
			textViewAtividade.setText(atividade);
			textViewAtividade.setTextSize(10); 
		} catch (Exception e){
			Log.e("Erro1: ", String.valueOf(e.getMessage()));
		}
		
		Log.i("Msg 2: ", "Chegou aqui!");
		
		try{
			TextView textViewData = (TextView) findViewById(R.id.textViewData);
			textViewData.setText(data);
			textViewData.setTextSize(10);
		} catch(Exception e){
			Log.e("Erro2: ", String.valueOf(e.getMessage()));
		}
		
		Log.i("Msg 3: ", "Chegou aqui!");
		
		try{
			TextView textViewHora = (TextView) findViewById(R.id.textViewHorario);
			textViewHora.setText(horario);
			textViewHora.setTextSize(10);
		} catch(Exception e){
			Log.e("Erro3: ", String.valueOf(e.getMessage()));
		}
		
		Log.i("Msg 4: ", "Chegou aqui!");
		
		try{
			TextView textViewLocal = (TextView) findViewById(R.id.textViewLocal);
			textViewLocal.setText(local);
			textViewLocal.setTextSize(10);
		} catch(Exception e){
			Log.e("Erro4: ", String.valueOf(e.getMessage()));
		}
		
		Log.i("Msg 5: ", "Chegou aqui!");
		
		try{
			TextView textViewObs = (TextView) findViewById(R.id.textViewObs);
			textViewObs.setText(obs);
			textViewObs.setTextSize(10);
		} catch(Exception e){
			Log.e("Erro5: ", String.valueOf(e.getMessage()));
		}
		
		setContentView(R.layout.activity_exibir_tarefa);
		

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		} */
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exibir_tarefa, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_exibir_tarefa,
					container, false);
			return rootView;
		}
	}

}
