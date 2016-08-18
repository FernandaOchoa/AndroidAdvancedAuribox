package monsh.com.lab5listas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by monsh on 17/08/2016.
 */

//Clase adaptador
public class PeliculasAdapter extends ArrayAdapter<Peliculas> {

    Context context;
    int layoutResourceId;
    Peliculas datos[] = null;

    public PeliculasAdapter(Context context,int layoutResourceId, Peliculas[] datos){
        super(context,layoutResourceId,datos);

        this.context= context;
        this.layoutResourceId = layoutResourceId;
        this.datos = datos;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        PeliculasHolder holder = null;

        if (row == null) {

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new PeliculasHolder();

            holder.imagen = (ImageView) row.findViewById(R.id.img);
            holder.texto = (TextView) row.findViewById(R.id.tv_row);

            row.setTag(holder);

        } else {
            holder = (PeliculasHolder) row.getTag();
        }
        Peliculas peliculas = datos[position];
        holder.texto.setText(peliculas.nombre);
        holder.imagen.setImageResource(peliculas.icon);

        return row;
    }
    static class PeliculasHolder{
        ImageView imagen;
        TextView texto;
    }





}


