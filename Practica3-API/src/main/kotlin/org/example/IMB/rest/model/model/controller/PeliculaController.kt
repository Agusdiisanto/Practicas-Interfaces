package org.example.IMB.rest.model.model.controller
import io.javalin.http.Context
import org.example.IMB.rest.model.model.Pelicula


class PeliculaController{

    var peliculas : MutableList<Pelicula> = mutableListOf();

    constructor(peliculas : MutableList<Pelicula>){
        this.peliculas = peliculas
    }


    fun buscarPeliculas(ctx : Context){
        var titulo = ctx.queryParam("title")
        var filtrado = peliculas.filter { p -> p.titulo == titulo }

        ctx.json(filtrado)
    }

    fun buscarPorRating(ctx : Context){

    }


}