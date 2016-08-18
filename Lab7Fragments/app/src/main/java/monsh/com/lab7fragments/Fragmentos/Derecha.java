package monsh.com.lab7fragments.Fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import monsh.com.lab7fragments.R;

/**
 * Created by monsh on 18/08/2016.
 */
public class Derecha extends Fragment {

    View rootView;
    TextView txt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Indicamos de donde obtenemos la vista del fragmento, enlazamos el TxtView
        //Devolvemos la vista con return

        rootView = inflater.inflate(R.layout.derecha,container,false);
        txt = (TextView) rootView.findViewById(R.id.tv_text);
        return rootView;
        }
    public void ObtenerDatos(String mensaje){

        txt.setText(mensaje);
    }
}
