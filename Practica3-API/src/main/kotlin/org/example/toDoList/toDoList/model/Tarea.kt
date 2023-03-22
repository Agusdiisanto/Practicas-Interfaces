package org.example.toDoList.toDoList.model

import java.time.LocalDate

class Tarea{

    var id : Int
    var titulo : String
    var descripcion : String
    //var creacion : LocalDate
    var estado : TareaEstado

    constructor( id : Int, titulo : String , descripcion : String){
        this.id = id
        this.titulo = titulo
        this.descripcion = descripcion
        //this.creacion = LocalDate.now()
        this.estado = TareaEstado.Pendiente
    }

    fun completado(){
        this.estado = TareaEstado.Completado
    }

    fun pendiente(){
        this.estado = TareaEstado.Pendiente
    }




}