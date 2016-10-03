package com.jdcasas.laboratorio_5_3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
/**
 * Created by Usuario on 02/10/2016.
 */
public class ListAdapter  extends ArrayAdapter<String>{

    private Context context;
    private String[] comida;
    private String[] ingredientes;
    private String[] tiempo;
    public ListAdapter(Context context, String[] comida, String[] ingredientes, String[] tiempo){
        super(context, R.layout.field_list, comida);
        this.context = context;
        this.comida = comida;
        this.ingredientes = ingredientes;
        this.tiempo = tiempo;
    }
    @Override
    public View getView(int ind, View view, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View reView = inflater.inflate(R.layout.field_list,parent,false);
        TextView txtNombre = (TextView) reView.findViewById(R.id.nombre);
        TextView txtIngredientes = (TextView) reView.findViewById(R.id.ingredientes);
        TextView txtTiempo = (TextView) reView.findViewById(R.id.tiempo);
        txtNombre.setText(comida[ind]);
        txtIngredientes.setText(ingredientes[ind]);
        txtTiempo.setText(tiempo[ind]);
        return reView;
    }
}
