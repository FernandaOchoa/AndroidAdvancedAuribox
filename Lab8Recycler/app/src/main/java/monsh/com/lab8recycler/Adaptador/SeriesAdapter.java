package monsh.com.lab8recycler.Adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import monsh.com.lab8recycler.Modelo.Series;
import monsh.com.lab8recycler.R;

/**
 * Created by monsh on 18/08/2016.
 */
public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {

    private List<Series> items;

    public static  class SeriesViewHolder extends RecyclerView.ViewHolder{

        //Campos de un renglon
        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;

        public  SeriesViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            visitas = (TextView) v.findViewById(R.id.visitas);
        }

    }

    public SeriesAdapter(List<Series> items){
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.series_card, parent, false);
        return new SeriesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {
        holder.imagen.setImageResource(items.get(position).getImagen());
        holder.nombre.setText(items.get(position).getNombre());
        holder.visitas.setText("Visitas: "+String.valueOf(items.get(position).getVisitas()));
    }
}
