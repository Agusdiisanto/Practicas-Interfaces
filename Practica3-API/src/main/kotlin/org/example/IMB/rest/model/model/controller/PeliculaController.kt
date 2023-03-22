package org.example.IMB.rest.model.model.controller
import io.javalin.http.Context
import org.example.IMB.rest.model.model.Pelicula
import org.example.IMB.rest.model.model.controller.buscador.PorActor
import org.example.IMB.rest.model.model.controller.buscador.PorDescripcion
import org.example.IMB.rest.model.model.controller.buscador.PorDirector
import org.example.IMB.rest.model.model.controller.buscador.PorTitulo


class PeliculaController{

    var peliculas : MutableList<Pelicula> = mutableListOf();

    constructor(peliculas : MutableList<Pelicula>){
        this.peliculas = peliculas
    }

    fun buscarPeliculas(ctx : Context){
        var titulo      = ctx.queryParam("title")
        var descripcion = ctx.queryParam("description")
        var actors      = ctx.queryParam("actors")
        var directors   = ctx.queryParam("directors")
        var result      = peliculas

        result = this.buscarPorEstrategia(PorTitulo(),      result, titulo)
        result = this.buscarPorEstrategia(PorDescripcion(), result, descripcion)
        result = this.buscarPorEstrategia(PorActor(),       result, actors)
        result = this.buscarPorEstrategia(PorDirector(),    result, directors)

        ctx.json(result)
    }

    fun buscarPorRating(ctx : Context){

    }

    fun buscarPorEstrategia(estrategia : ISercher, peliculas : MutableList<Pelicula>, filtro : String?) : MutableList<Pelicula>{
        return estrategia.buscarPor(peliculas, filtro)
    }
}