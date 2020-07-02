package sahfer.FormacionDeportiva.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sahfer.FormacionDeportiva.Domain.SesionList;
import sahfer.FormacionDeportiva.R;

public class ListAdapterSesion extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<SesionList> names;

    public ListAdapterSesion(Context context, int layout, ArrayList<SesionList> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Copiamos la vista
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.list_item, null);
        // Valor actual según la posición

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.textViewEquipo);
        textView.setText(names.get(position).getEquipo());

        ImageView imgView = (ImageView) v.findViewById(R.id.imageView);
        if(names.get(position).getTipoPartido() == "training") {
            imgView.setImageResource(R.drawable.ic_menu_gallery);
        }
        //Devolvemos la vista inflada
        return v;
    }
}