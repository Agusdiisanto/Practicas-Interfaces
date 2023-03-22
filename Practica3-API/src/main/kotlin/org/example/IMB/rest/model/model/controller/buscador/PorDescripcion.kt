package org.example.IMB.rest.model.model.controller.buscador

import org.example.IMB.rest.model.model.Pelicula
import org.example.IMB.rest.model.model.controller.ISercher

class PorDescripcion : ISercher {
    override fun buscarPor(peliculas: MutableList<Pelicula>, filtro: String?): MutableList<Pelicula> {
        var pelisPorDescripcion = peliculas
        if (!filtro.isNullOrEmpty()){
            pelisPorDescripcion = pelisPorDescripcion.filter { p -> p.descripcion == filtro }.toMutableList()
        }
        return pelisPorDescripcion
    }
}