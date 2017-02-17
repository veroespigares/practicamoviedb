package com.practicamoviedb.veronica.practicamoviedb.model;

public class Principal
{
    private String titulo;
    private String imagen;

    public Principal(String tit, String sub, String img){
        titulo = tit;
        imagen = img;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getImagen() { return imagen; }
}
