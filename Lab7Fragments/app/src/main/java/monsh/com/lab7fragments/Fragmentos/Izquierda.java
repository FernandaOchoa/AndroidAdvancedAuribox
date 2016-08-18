package monsh.com.lab7fragments.Fragmentos;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import monsh.com.lab7fragments.Interfaces.EnviarMensaje;
import monsh.com.lab7fragments.R;

/**
 * Created by monsh on 18/08/2016.
 */

//Clase del fragment izquierdo que recibe datos
public class Izquierda extends Fragment {

    //Create my instance variables
    View rootView;
    Button boton;
    EditText campo;
    EnviarMensaje EM;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        //Indicamos de donde obtenemos la vista para el fragmento
        //enlazamos los layouts de boton y edittext, añadimos eventos

        rootView = inflater.inflate(R.layout.izquierda,container,false);
        campo = (EditText) rootView.findViewById(R.id.campo_texto);
        boton = (Button) rootView.findViewById(R.id.boton);

        /*
        Indicamos el nombre del texto en el editText y que lo guarde en una cadena
        llamada mensaje, este mismo lo pasamos al evento que llamaremos EM
        mensaje lo pasamos como parametro
         */
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje;
                mensaje = campo.getText().toString();
                EM.enviarDatos(mensaje);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            EM = (EnviarMensaje) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Necesitas implementar un mensaje");
        }


    }
}







