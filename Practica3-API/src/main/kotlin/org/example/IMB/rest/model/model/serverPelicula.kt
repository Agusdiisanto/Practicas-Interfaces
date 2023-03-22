package org.example.IMB.rest.model.model

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.example.IMB.rest.model.model.controller.PeliculaController



fun main() {
    val app = Javalin.create().start(7000)

    var pelicula1 : Pelicula = Pelicula("Rapidos y Furioso", "Accion" ,10f)
    var pelicula2 : Pelicula = Pelicula("Avengers", "Comedia" ,10f)
    var pelicula3 : Pelicula = Pelicula("Batman", "Policial" ,3f)
    var pelicula4 : Pelicula = Pelicula("IronMan", "Terror" ,100f)

    var muchasPeliculas : MutableList<Pelicula> = mutableListOf(pelicula1,pelicula2,pelicula3,pelicula4)
    val controller = PeliculaController(muchasPeliculas)

    app.routes {
        path("searchBy") {
            get(controller::buscarPeliculas)
        }
    }
}