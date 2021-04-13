package lucas.sampaio.leite.com.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listaSelecoes;
    AdapterSelecaoPersonalizado adapter;

    public static final String TAG_NOME = "SELECAO_NOME";
    public static final String TAG_CONTINENTE = "SELECAO_CONTINENTE";
    public static final String TAG_IMAGEM = "SELECAO_IMAGEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Selecao> selecoes = carregarSelecoes();

        listaSelecoes = (ListView) findViewById(R.id.list);
    //  ArrayAdapter<Selecao> adapter = new ArrayAdapter<Selecao>(this, android.R.layout.simple_list_item_1, selecoes);

        adapter = new AdapterSelecaoPersonalizado(selecoes, this);
        listaSelecoes.setAdapter(adapter);
        listaSelecoes.setOnItemClickListener(this);

    }




    private List<Selecao> carregarSelecoes(){
        List<Selecao> selecoes = new ArrayList<>();

        String[] array_selecoes = getResources().getStringArray(R.array.array_selecoes);
        String[] array_continentes = getResources().getStringArray(R.array.array_continentes);

        selecoes.add(new Selecao(array_selecoes[0], array_continentes[0], R.drawable.brasil_logo));
        selecoes.add(new Selecao(array_selecoes[1], array_continentes[0], R.drawable.argentina_logo));
        selecoes.add(new Selecao(array_selecoes[2], array_continentes[1], R.drawable.alemanha_logo));

        return selecoes;
    }


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Selecao item = (Selecao) adapter.getItem(position);
//        Toast.makeText(this, "Você Clicou em: " + item.getNome(), Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Selecao item = (Selecao) adapter.getItem(position);

        Intent i = new Intent(getApplicationContext(), Activity2.class);

        i.putExtra(TAG_NOME, item.getNome());
        i.putExtra(TAG_CONTINENTE, item.getContinente());
        i.putExtra(TAG_IMAGEM, item.getImage());
        startActivity(i);
    }
}