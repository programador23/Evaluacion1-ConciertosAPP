package com.example.misconciertos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;


import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.misconciertos.dto.Conciertos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Spinner selector_genero;
    Spinner selector_calificacion;
private EditText nombre;
private CalendarView fecha;
private EditText Valor;
private Button Registar;
private ListView listView1;
private List<Conciertos> conciertosList = new ArrayList<>();
private ArrayAdapter<Conciertos> adapterList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //muestra lista del xml opociones (las carga)
        selector_genero = this.<Spinner>findViewById(R.id.idSpinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.selector_genero_musical, android.R.layout.simple_spinner_item);
        selector_genero.setAdapter(adapter);

        selector_calificacion = this.findViewById(R.id.idCalificacion);

        //rellernado spinner por java
        ArrayList<String> SpinnerCalificaciones=new ArrayList<String>();
        SpinnerCalificaciones.add("1");
        SpinnerCalificaciones.add("2");
        SpinnerCalificaciones.add("3");
        SpinnerCalificaciones.add("4");
        SpinnerCalificaciones.add("5");
        SpinnerCalificaciones.add("6");
        SpinnerCalificaciones.add("7");
        ArrayAdapter<CharSequence> adapter1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,SpinnerCalificaciones);
        selector_calificacion.setAdapter(adapter1);

        //lista opciones



        this.nombre=findViewById(R.id.txtnombre);
        this.selector_genero=findViewById(R.id.idSpinner);
        this.selector_calificacion=findViewById(R.id.idCalificacion);
        this.fecha =findViewById(R.id.txtcalendario);
        this.Valor=findViewById(R.id.txt_valor);
        this.Registar=findViewById(R.id.Registar);
        this.listView1=findViewById(R.id.listView1);


        this.adapterList = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,conciertosList);
        this.listView1.setAdapter(adapterList);
        this.Registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<String> errores = new ArrayList<>();

                String nombreStr = nombre.getText().toString();

                long fechacomocadena =fecha.getDate();
                SimpleDateFormat sdf=new
                        SimpleDateFormat("dd/MM/yyyy");
                String fechaString = sdf.format(fechacomocadena);

                String precio = Valor.getText().toString().trim();


                String Nombreplus=nombreStr;
                String Fechaplus="";
                String Precioplus="";



                //Valida

                try {
                  if (nombreStr.isEmpty()){
                      errores.add("DEBE REGISTRAR EL NOMBRE DEL ARTISTA");
                    }
                }catch (Exception e){
            errores.add("DEBE REGISTRAR EL NOMBRE DEL ARTISTA");
               }

                try {
                    if (fechaString.isEmpty()){
                        errores.add("DEBE REGISTRAR LA FECHA");
                    }
                }catch (Exception e){
                    errores.add("DEBE REGISTRAR LA FECHA");
                }

                try {
                    if (precio.isEmpty()){
                        errores.add("DEBE REGISTRAR EL VALOR DE LA ENTRADA");
                    }
                }catch (Exception e){
                    errores.add("DEBE REGISTRAR EL VALOR DE LA ENTRADA");
                }


                     if (errores.isEmpty()) {

                         Conciertos concierto = new Conciertos();
                         concierto.setNombre_Artista(nombreStr);
                         concierto.setFecha(fechaString);
                         concierto.setValor(precio);
                         conciertosList.add(concierto);
                         adapterList.notifyDataSetChanged();

                         Toast.makeText(MainActivity.this, "Registro Exitoso", Toast.LENGTH_LONG).show();

                     } else {
                         mostrarErrores(errores);
                     }




            }
        });


        }

private void mostrarErrores(List<String>errores){
      String mensaje ="";
      for (String e: errores){
          mensaje+="-"+e+"\n";
      }
    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
    alertBuilder
            .setTitle("Error de Validacion")
            .setMessage(mensaje)
            .setPositiveButton("Aceptar",null)
            .create()
            .show();
    }

}