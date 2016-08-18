package monsh.com.lab7fragments.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import monsh.com.lab7fragments.Fragmentos.Derecha;
import monsh.com.lab7fragments.Interfaces.EnviarMensaje;
import monsh.com.lab7fragments.R;

public class MainActivity extends AppCompatActivity implements EnviarMensaje {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarDatos(String mensaje) {

        Derecha derecha = (Derecha) getFragmentManager().findFragmentById(R.id.der);
        derecha.ObtenerDatos(mensaje);
    }
}

