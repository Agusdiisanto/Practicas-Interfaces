package org.example.IMB.rest.model.model.controller.buscador

import org.example.IMB.rest.model.model.Pelicula

interface ISercherForLists {
    fun buscarPor(peliculas: MutableList<Pelicula>, filtro: MutableList<String?>) : MutableList<Pelicula>
}