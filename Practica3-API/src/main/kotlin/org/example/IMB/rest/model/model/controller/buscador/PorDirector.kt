package org.example.IMB.rest.model.model.controller.buscador

import org.example.IMB.rest.model.model.Pelicula
import org.example.IMB.rest.model.model.controller.ISercher

class PorDirector : ISercherForLists {
    override fun buscarPor(peliculas: MutableList<Pelicula>, filtro: MutableList<String?>): MutableList<Pelicula> {
        var pelisPorDirector = peliculas
        if (!filtro.isNullOrEmpty()){
            pelisPorDirector = pelisPorDirector.filter { p -> p.directores.any { d -> filtro.contains(d) } }.toMutableList()
        }
        return pelisPorDirector
    }
}