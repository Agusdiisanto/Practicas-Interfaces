package org.example.IMB.rest.model.model

import java.util.*

class Pelicula{
    var titulo : String
    var descripcion : String
    // var fechadeEstreno : LocaleDate
    var directores : MutableList<String>
    var actores : MutableList<String>
    var rating : Float

    constructor(titulo : String, descripcion : String, directores : MutableList<String>, actores : MutableList<String>, rating : Float){
        this.titulo      = titulo
        this.descripcion = descripcion
        // this.fechadeEstreno = estreno
        this.directores  = directores
        this.actores     = actores
        this.rating      = rating
    }



}