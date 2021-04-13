package lucas.sampaio.leite.com.listview;

import android.media.Image;

public class Selecao {
    private String nome;
    private String continente;
    private int image;

    public Selecao (String nome, String continente, int image){
        this.nome = nome;
        this.continente = continente;
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public String getContinente() {
        return continente;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Selecao{" +
                "nome='" + nome + '\'' +
                ", continente='" + continente + '\'' +
                '}';
    }
}

