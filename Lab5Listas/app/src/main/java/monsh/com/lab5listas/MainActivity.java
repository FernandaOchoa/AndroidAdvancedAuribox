package monsh.com.lab5listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hacemos el arreglo

        Peliculas peliculas_datos[] = new  Peliculas[]{
                new Peliculas(R.mipmap.ic_git,"Ex-Machina"),
                new Peliculas(R.mipmap.ic_git,"Codigo Turin"),
                new Peliculas(R.mipmap.ic_git,"Time"),
                new Peliculas(R.mipmap.ic_git,"Wreck-it Ralph"),
                new Peliculas(R.mipmap.ic_git,"Ex-Machina"),
                new Peliculas(R.mipmap.ic_git,"Codigo Turin"),
                new Peliculas(R.mipmap.ic_git,"Time"),
                new Peliculas(R.mipmap.ic_git,"Wreck-it Ralph"),
                new Peliculas(R.mipmap.ic_git,"Ex-Machina"),
                new Peliculas(R.mipmap.ic_git,"Codigo Turin"),
                new Peliculas(R.mipmap.ic_git,"Time"),
                new Peliculas(R.mipmap.ic_git,"Wreck-it Ralph"),
                new Peliculas(R.mipmap.ic_git,"Ex-Machina"),
                new Peliculas(R.mipmap.ic_git,"Codigo Turin"),
                new Peliculas(R.mipmap.ic_git,"Time"),
                new Peliculas(R.mipmap.ic_git,"Wreck-it Ralph"),
        };

        //Al adaptador le paso el arreglo
        PeliculasAdapter adapter = new PeliculasAdapter(this,R.layout.row,peliculas_datos);

        ///Me traigo mi lista y la enlazo con su vista, ademas le asigno su adaptador lleno
        ls = (ListView) findViewById(R.id.ls);
        ls.setAdapter(adapter);

        //Escucho los eventos en los items (elementos de la lista)
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView vista =(TextView) view.findViewById(R.id.tv_row);
                Toast.makeText(getApplicationContext(),vista.getText()+" "+position, Toast.LENGTH_SHORT).show();
            }
        });













    }
}
