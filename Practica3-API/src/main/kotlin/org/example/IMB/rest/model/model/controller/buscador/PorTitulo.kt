package org.example.IMB.rest.model.model.controller.buscador

import org.example.IMB.rest.model.model.Pelicula
import org.example.IMB.rest.model.model.controller.ISercher

class PorTitulo : ISercher {

    override fun buscarPor(peliculas: MutableList<Pelicula>, filtro: String?): MutableList<Pelicula> {
        var pelisPorTitulo = peliculas
        if (!filtro.isNullOrEmpty()){
            pelisPorTitulo = pelisPorTitulo.filter { p -> p.titulo == filtro }.toMutableList()
        }
        return pelisPorTitulo
    }
}