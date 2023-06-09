package org.example.IMB.rest.model.model.controller
import io.javalin.http.Context
import org.example.IMB.rest.model.model.Pelicula
import org.example.IMB.rest.model.model.controller.buscador.*
import java.lang.Float.max


class PeliculaController{

    var peliculas : MutableList<Pelicula> = mutableListOf();

    constructor(peliculas : MutableList<Pelicula>){
        this.peliculas = peliculas
    }

    fun buscarPeliculas(ctx : Context){
        val titulo      = ctx.queryParam("title")
        val descripcion = ctx.queryParam("description")
        val actors      = ctx.queryParams("actors")
        val directors   = ctx.queryParams("directors")
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
    fun buscarPorRanking(ctx : Context){
        val minRanking  = ctx.queryParam("min_rating")
        val limit       = ctx.queryParam("limit")
        var result: MutableList<Pelicula>
        result = peliculas.sortedBy{ -it.rating }.toMutableList()
        if(!minRanking.isNullOrEmpty()){
            result = result.filter {r -> r.rating > minRanking.toFloat() }.toMutableList()
        }
        if(!limit.isNullOrEmpty()){
            val new_limit = kotlin.math.min(limit.toInt(), result.size)
            result = result.slice(0..new_limit-1).toMutableList()
        }
        ctx.json(result)

    }
}