package org.example.IMB.rest.model.model.controller

import org.example.IMB.rest.model.model.Pelicula

interface ISercher {
    fun buscarPor(peliculas: MutableList<Pelicula>, filtro: String?) : MutableList<Pelicula>
}