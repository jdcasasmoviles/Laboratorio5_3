package com.jdcasas.laboratorio_5_3act2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private GridView Opciones;
    private Toast mensaje;
    public static final String [] Platos={ "Lomo Saltado","Sopa Seca",
            "Frejoles", "Bisteck a lo pobre ", "Que rico .... a comer !!!" };

    public static final String [] Ingredientes={ "1 kg. de carne de res \n1/2 kg. cebolla cortada a lo largo \n250 gr. tomate \n1 kg. papas\nSal, pimienta y ajos al gusto\nSillao \n3 cucharaditas de perejil picado \nVinagre\nAceite vegetal",
            "1 kg de fideos tallarin delgado\n750 g de carne de gallina\n3 cebollas medianas picadas en cuadritos\n3 zanahorias rayadas\n250 g de ají panca molido\n2 lt de agua\n50 g de perejil molido\n300 g de albahaca molida\n4 dientes de ajo machacados\nSal, pimienta y aceite al gusto\n10 aceitunas negras \n50 g de pasas negras",
            "½ kilo de frijoles\n1/3 de taza de aceite\n1 cebolla\n150 gramos de costilla ahumada\n1 cucharada de ají verde molido\n2 cucharaditas de ajo finamente picado\n1 cucharadita de tomillo seco\nAgua",
            "6 Filetes de Carne\n6 Huevos Fritos \n6 Plátanos Verdes \n6 Salchichas \n6 Tazas de Arroz cocido \n6 Papas cortadas en bastones y fritas \n1 Cucharada de Ajo molido \n Aceite para Freír ,Sal y Pimienta al gusto",
            "**********"};

    public static final String[] Tiempo = {"1 hora", "1 hora", "2 horas",
            "30 minutos ", "**********"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Opciones= (GridView)findViewById(R.id.Opciones);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1 ,Platos);
        Opciones.setAdapter(adapter);
        ArrayList<HashMap<String, String>> ListaComidas = new ArrayList<HashMap<String, String>>();;
        Opciones.setAdapter(new ListAdapter(this, Platos, Ingredientes, Tiempo));
        Opciones.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, android.view.View v, int position, long id) {
                        mensaje.makeText(getApplicationContext(), "Has hecho click : "
                                + parent.getItemAtPosition(position),Toast.LENGTH_LONG).show();
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
