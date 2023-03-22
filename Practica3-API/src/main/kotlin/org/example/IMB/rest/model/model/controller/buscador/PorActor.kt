package org.example.IMB.rest.model.model.controller.buscador

import org.example.IMB.rest.model.model.Pelicula
import java.util.*

class PorActor : ISercherForLists {

    // private fun anySatisfy(directores: MutableList<String>, filtro : MutableList<String?>) : Boolean {
//         return directores.stream().anyMatch { d -> filtro.stream().anyMatch {  } }
//     }

    override fun buscarPor(peliculas: MutableList<Pelicula>, filtro: MutableList<String?>): MutableList<Pelicula> {
        var pelisPorActor = peliculas
        //var filtro2 = filtro
        // println(filtro)
        // println(filtro2)
        // println(Objects.isNull(filtro2))
        if (!filtro.isNullOrEmpty()){
            println("ACA TENES TU FILTRO: " + filtro)
            println(pelisPorActor)
            pelisPorActor = pelisPorActor.filter { p -> p.directores.stream().anyMatch {d->filtro.contains(d)} }.toMutableList()
            println("PELIS FILTRADAS: " + pelisPorActor)
        }
        return pelisPorActor
    }

}