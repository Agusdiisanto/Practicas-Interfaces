package org.example.toDoList.model

import java.time.LocalDate

class Tarea{

    var id : Int
    var titulo : String
    var descripcion : String
    var creacion : LocalDate
    var estado : TareaEstado

    constructor( id : Int, titulo : String , descripcion : String , creacion : LocalDate, estado : TareaEstado){
        this.id = id
        this.titulo = titulo
        this.descripcion = descripcion
        this.creacion = LocalDate.now()
        this.estado = TareaEstado.Pendiente
    }






}