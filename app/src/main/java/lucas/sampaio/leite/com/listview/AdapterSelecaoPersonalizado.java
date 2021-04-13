package lucas.sampaio.leite.com.listview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterSelecaoPersonalizado extends BaseAdapter {

    private final List<Selecao> selecoes;
    private final Activity act;

    public AdapterSelecaoPersonalizado(List<Selecao> cursos, Activity act) {
        this.selecoes = cursos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return selecoes.size();
    }

    @Override
    public Object getItem(int position) {
        return selecoes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.item_personalizado, parent, false);
        Selecao selecao = selecoes.get(position);

        TextView nomeSelecao = (TextView) view.findViewById(R.id.item_personalizado_textView_selecao);
        TextView nomeContinente = (TextView) view.findViewById(R.id.item_personalizado_textView_continente);
        ImageView escudo = (ImageView) view.findViewById(R.id.item_personalizado_imageView_escudo);

        nomeSelecao.setText(selecao.getNome());
        nomeContinente.setText(selecao.getContinente());
        escudo.setImageResource(selecao.getImage());

        return view;
    }

}
