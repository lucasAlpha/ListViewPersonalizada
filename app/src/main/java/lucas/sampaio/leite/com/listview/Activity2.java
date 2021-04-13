package lucas.sampaio.leite.com.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView textViewNome = (TextView) findViewById(R.id.textViewNome);
        TextView textViewContinente = (TextView) findViewById(R.id.textViewContinente);
        ImageView imageViewEscudo = (ImageView) findViewById(R.id.imageView);

        Intent i = getIntent();
        String nome = i.getStringExtra(MainActivity.TAG_NOME);
        String continente = i.getStringExtra(MainActivity.TAG_CONTINENTE);
        int escudoID = i.getIntExtra(MainActivity.TAG_IMAGEM, R.drawable.ic_launcher_foreground);

        textViewNome.setText(nome);
        textViewContinente.setText(continente);
        imageViewEscudo.setImageResource(escudoID);
    }
}

