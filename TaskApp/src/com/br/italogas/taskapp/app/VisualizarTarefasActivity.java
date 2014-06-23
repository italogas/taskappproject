package com.br.italogas.taskapp.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.br.italogas.taskapp.GerenciadorDeTarefasImpl;
import com.br.italogas.taskapp.R;
import com.br.italogas.taskapp.Tarefa;

public class VisualizarTarefasActivity extends ListActivity {
	
	public static String EXTRA_MESSAGE = "com.br.italogas.taskapp.app.EXTRA_MESSAGE";
	
	GerenciadorDeTarefasImpl gerenciador;
	ArrayList<String> listaDeDescricoes;
	ArrayAdapter<String> adapter;
	HashMap<String, String> mapaDeDescricoesPorId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		gerenciador = GerenciadorDeTarefasImpl.getInstance();
		mapaDeDescricoesPorId = new HashMap<String, String>();
		listaDeDescricoes = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, listaDeDescricoes);
		
		//setContentView(R.layout.activity_visualizar_tarefas);
		setListAdapter(adapter);

		/*if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment()).commit();
		} */
		
		adicionarTarefasNaTela();
	}

	private void adicionarTarefasNaTela() {
		// TODO Auto-generated method stub
		
		Map<String, Tarefa> mapaDeTarefasPorId = gerenciador.getMapaDeTarefasPorId();
		Collection<Tarefa> values = mapaDeTarefasPorId.values();
		Iterator<Tarefa> iterator = values.iterator();
		while(iterator.hasNext()){
			Tarefa t = iterator.next();
			mapaDeDescricoesPorId.put(t.getId(), t.getAtividade());
			listaDeDescricoes.add(t.getAtividade());
			adapter.notifyDataSetChanged();
			/* TextView text1 = new TextView(this);
			text1.setText(t.getAtividade());
			text1.setTextSize(10);
			addContentView(text1, findViewById(R.id.container).getLayoutParams()); */
		}
	}

	/* @Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.visualizar_tarefas, menu);
		return true;
	} */

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
					R.layout.fragment_visualizar_tarefas, container, false);
			return rootView;
		}
	} 

	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String msg = l.getItemAtPosition(position).toString();
		Iterator<String> iterator = mapaDeDescricoesPorId.keySet().iterator();
		String idTarefa = null;
		while(iterator.hasNext()){
			String key = iterator.next();
			if(mapaDeDescricoesPorId.get(key).equals(msg)){
				idTarefa = key;
				break;
			}
		}
		Intent intent = new Intent(this, ExibirTarefaActivity.class);
		intent.putExtra(EXTRA_MESSAGE, idTarefa);
		startActivity(intent);
	}
}
