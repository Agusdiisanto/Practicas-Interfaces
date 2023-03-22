package org.example.IMB.rest.model.model.controller.buscador

import org.example.IMB.rest.model.model.Pelicula
import org.example.IMB.rest.model.model.controller.ISercher

class PorActor : ISercher {
    override fun buscarPor(peliculas: MutableList<Pelicula>, filtro: String?): MutableList<Pelicula> {
        var pelisPorActor = peliculas
        if (!filtro.isNullOrEmpty()){
            pelisPorActor = pelisPorActor.filter { p -> p.actores.contains(filtro) }.toMutableList()
        }
        return pelisPorActor
    }
}