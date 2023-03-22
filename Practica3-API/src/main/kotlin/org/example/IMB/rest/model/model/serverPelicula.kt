package org.example.IMB.rest.model.model

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.example.IMB.rest.model.model.controller.PeliculaController



fun main() {
    val app = Javalin.create().start(7000)

    var directores1 = mutableListOf("Santi","Pepe","Roberto")
    var directores2 = mutableListOf("Agus","Santi")
    var actores1    = mutableListOf("Juan","Ari")
    var actores2    = mutableListOf("Juan", "Sebastian", "Ariel")

    var pelicula1 : Pelicula = Pelicula("Rapidos y Furioso", "Accion", directores1, actores1, 10f)
    var pelicula2 : Pelicula = Pelicula("Avengers", "Comedia",directores2, actores1, 10f)
    var pelicula3 : Pelicula = Pelicula("Batman", "Accion",directores1, actores2, 3f)
    var pelicula4 : Pelicula = Pelicula("IronMan", "Terror" ,directores2, actores2, 100f)

    var muchasPeliculas : MutableList<Pelicula> = mutableListOf(pelicula1,pelicula2,pelicula3,pelicula4)
    val controller = PeliculaController(muchasPeliculas)

    app.routes {
        path("searchBy") {
            get(controller::buscarPeliculas)
        }
    }
}