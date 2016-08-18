package monsh.com.lab8recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import monsh.com.lab8recycler.Adaptador.SeriesAdapter;
import monsh.com.lab8recycler.Modelo.Series;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar serie
        List items = new ArrayList();

        items.add(new Series(R.drawable.theit, "The IT Crowd",320));
        items.add(new Series(R.drawable.mrobot, "Mr. Robot",540));
        items.add(new Series(R.drawable.screem, "Sream Queens",1080));
        items.add(new Series(R.drawable.law,"Law & order UVE",245));
        items.add(new Series(R.drawable.drhouse,"Dr. House",368));

        //Obtenemos el recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        //Usar un administrador para linearlayout
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        //Crear un nuevo adaptador
        adapter = new SeriesAdapter(items);
        recycler.setAdapter(adapter);
    }
}
