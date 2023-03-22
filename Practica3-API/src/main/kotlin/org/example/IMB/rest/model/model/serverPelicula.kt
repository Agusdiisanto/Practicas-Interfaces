package org.example.IMB.rest.model.model

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.example.IMB.rest.model.model.controller.PeliculaController



fun main() {
    val app = Javalin.create().start(7000)

    val directores1 = mutableListOf("Santi","Pepe","Roberto")
    val directores2 = mutableListOf("Agus","Santi")
    val actores1    = mutableListOf("Juan")
    val actores2    = mutableListOf("Juan", "Sebastian", "Ariel")
    val actores3    = mutableListOf("Ariel", "Sebastian")
    val actores4    = mutableListOf("Ariel", "Raul")


    val pelicula1 : Pelicula = Pelicula("Rapidos y Furioso", "Accion", directores1, actores4, 10f)
    val pelicula2 : Pelicula = Pelicula("Avengers", "Comedia",directores2, actores1, 20f)
    val pelicula3 : Pelicula = Pelicula("Batman", "Accion",directores1, actores3, 3f)
    val pelicula4 : Pelicula = Pelicula("IronMan", "Terror" ,directores2, actores2, 100f)

    val muchasPeliculas : MutableList<Pelicula> = mutableListOf(pelicula1,pelicula2,pelicula3,pelicula4)
    val controller = PeliculaController(muchasPeliculas)

    app.routes {
        path("searchBy") {
            get(controller::buscarPeliculas)
        }
        path("ranking") {
            get(controller::buscarPorRanking)
        }
    }
}