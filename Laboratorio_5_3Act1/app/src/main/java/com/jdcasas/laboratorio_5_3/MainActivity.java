package com.jdcasas.laboratorio_5_3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView ListaOpciones;

    public static final String [] Platos={ "Lomo Saltado","Sopa Seca",
            "Frejoles", "Bisteck a lo pobre ", "Que rico .... a comer !!!" };

    public static final String [] Ingredientes={ "1 kg. de carne de res .1/2 kg. cebolla cortada a lo largo ,250 gr. tomate ,1 kg. papas,Sal, pimienta y ajos al gusto,Sillao ,3 cucharaditas de perejil picado ,Vinagre,Aceite vegetal",
            "1 kg de fideos tallarin delgado,750 g de carne de gallina,3 cebollas medianas picadas en cuadritos,3 zanahorias rayadas.250 g de ají panca molido,2 lt de agua,50 g de perejil molido,300 g de albahaca molida,4 dientes de ajo machacados,Sal, pimienta y aceite al gusto,10 aceitunas negras ,50 g de pasas negras",
            "½ kilo de frijoles,1/3 de taza de aceite,1 cebolla,150 gramos de costilla ahumada,1 cucharada de ají verde molido,2 cucharaditas de ajo finamente picado,1 cucharadita de tomillo seco,Agua",
            "6 Filetes de Carne,6 Huevos Fritos ,6 Plátanos Verdes ,6 Salchichas ,6 Tazas de Arroz cocido ,6 Papas cortadas en bastones y fritas ,1 Cucharada de Ajo molido , Aceite para Freír ,Sal y Pimienta al gusto",
            "**********" };

    public static final String[] Tiempo ={ "1 hora","1 hora","2 horas",
            "30 minutos ","**********" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListaOpciones = (ListView)findViewById(R.id.Opciones);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Platos);
        ListaOpciones.setAdapter(adapter);
        ArrayList<HashMap<String, String>> ListaComidas = new ArrayList<HashMap<String, String>>();

        ListaOpciones.setAdapter(new ListAdapter(this, Platos, Ingredientes, Tiempo));


       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
