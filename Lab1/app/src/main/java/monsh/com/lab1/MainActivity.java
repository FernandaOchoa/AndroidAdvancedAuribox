package monsh.com.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //Create my instance variables
    private Button saludar;
    private EditText texto;
    private TextView mostrarT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link views with instance variables
        saludar = (Button) findViewById(R.id.btn_saludar);
        texto = (EditText) findViewById(R.id.edt_texto);
        mostrarT = (TextView) findViewById(R.id.tv_show);

        //Add Listener to my button
        saludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = texto.getText().toString();

                mostrarT.setText("Hola "+nombre);

                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int hour = cal.get(Calendar.HOUR_OF_DAY);

                if (hour < 6 || hour >= 21) {
                    mostrarT.setText(getString(R.string.goodnight) + nombre + "!");
                } else if (hour >= 6 && hour < 12) {
                    mostrarT.setText(getString(R.string.goodmorning) + nombre + "!");
                } else if (hour >= 12 && hour < 17) {
                    mostrarT.setText(getString(R.string.goodafternoon) + nombre + "!");
                } else if (hour >= 17 && hour < 21) {
                    mostrarT.setText(getString(R.string.goodevening) + nombre + "!");
                }
            }
        });
    }
}
