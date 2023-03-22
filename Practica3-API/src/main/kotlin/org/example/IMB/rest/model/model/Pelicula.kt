package org.example.IMB.rest.model.model

import java.util.*

class Pelicula{

    var titulo : String
    var descripcion : String
   // var fechadeEstreno : LocaleDate
    var directores : MutableList<String> = mutableListOf("Agus","Santi","Pepe")
    var actores : MutableList<String> = mutableListOf("Juan","Ari","Sebastian")
    var rating : Float

    constructor(titulo : String , descripcion : String , rating : Float){
        this.titulo = titulo
        this.descripcion = descripcion
       // this.fechadeEstreno = estreno
        this.rating = rating
    }


}