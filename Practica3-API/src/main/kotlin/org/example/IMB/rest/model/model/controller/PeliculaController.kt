package org.example.IMB.rest.model.model.controller
import io.javalin.http.Context
import org.example.IMB.rest.model.model.Pelicula
import org.example.IMB.rest.model.model.controller.buscador.*


class PeliculaController{

    var peliculas : MutableList<Pelicula> = mutableListOf();

    constructor(peliculas : MutableList<Pelicula>){
        this.peliculas = peliculas
    }

    fun buscarPeliculas(ctx : Context){
        var titulo      = ctx.queryParam("title")
        var descripcion = ctx.queryParam("description")
        var actors      = ctx.queryParams("actors")
        var directors   = ctx.queryParams("directors")
        var result      = peliculas

        result = this.buscarPorEstrategia(PorTitulo(),      result, titulo)
        result = this.buscarPorEstrategia(PorDescripcion(), result, descripcion)
        result = this.buscarPorEstrategiaParaListas(PorActor(),       result, actors.toMutableList())
        result = this.buscarPorEstrategiaParaListas(PorDirector(),    result, directors.toMutableList())

        ctx.json(result)
    }
    private fun buscarPorEstrategia(estrategia : ISercher, peliculas : MutableList<Pelicula>, filtro : String?) : MutableList<Pelicula>{
        return estrategia.buscarPor(peliculas, filtro)
    }
    private fun buscarPorEstrategiaParaListas(estrategia : ISercherForLists, peliculas : MutableList<Pelicula>, filtro : MutableList<String?>) : MutableList<Pelicula>{
        return estrategia.buscarPor(peliculas, filtro)
    }
    fun buscarPorRating(ctx : Context){

    }
}