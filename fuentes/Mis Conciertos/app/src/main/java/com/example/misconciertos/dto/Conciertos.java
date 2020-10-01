package com.example.misconciertos.dto;

public class Conciertos {
    private String Nombre_Artista;
    private String Valor;
    private String Fecha;

    public Conciertos() {

    }

    public String getNombre_Artista() {
        return Nombre_Artista;
    }

    public void setNombre_Artista(String nombre_Artista) {
        Nombre_Artista = nombre_Artista;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public Conciertos(String nombre_Artista, String valor, String fecha) {
        Nombre_Artista = nombre_Artista;
        Valor = valor;
        Fecha = fecha;
    }
  @Override
    public String toString(){
        return "Nombre Artista: "+Nombre_Artista+
                " Fecha: "+ Fecha+" Precio De La Entrada: "+Valor+" ";
  }

}
