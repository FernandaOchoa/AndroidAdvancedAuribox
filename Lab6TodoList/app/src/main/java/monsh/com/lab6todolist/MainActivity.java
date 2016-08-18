package monsh.com.lab6todolist;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Create Instance Variables
    private EditText input;
    private ListView list;
    private FloatingActionButton add;

    //Arrays
    private ArrayList<String> listArray;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link my instance variables with views
        input = (EditText) findViewById(R.id.edt_input);
        list = (ListView) findViewById(R.id.ls);
        add = (FloatingActionButton) findViewById(R.id.add);

        //Initialize the list and the add item (fab)
        listArray = new ArrayList<String>();
        listArray.add("Ir al Taller de Swift");

        //Initialize the ArrayAdapter
        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.renglon,listArray);
        list.setAdapter(adapter);

        //Add Actions to my FAB
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = input.getText().toString();
                if (task.isEmpty()) {
                    Snackbar.make(v, "Esta Vacío", Snackbar.LENGTH_SHORT).show();
                } else {
                    listArray.add(task);

                    //Apply changes on the adapter to refresh
                    adapter.notifyDataSetChanged();

                    //Clear the editText for new item
                    input.setText("");
                }
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listArray.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }
}
