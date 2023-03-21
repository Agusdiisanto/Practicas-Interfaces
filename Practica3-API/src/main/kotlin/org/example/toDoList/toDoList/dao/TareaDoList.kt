package org.example.toDoList.toDoList.dao

import org.example.toDoList.toDoList.error.NotFoundReason
import io.javalin.http.NotFoundResponse
import io.javalin.security.accessManagerNotConfiguredException
import org.example.toDoList.toDoList.model.Tarea

class TareaDoList {

    var tareas : MutableList<Tarea>  =  mutableListOf(

        Tarea(1,"JavaScript","Curso"),
        Tarea(2,"HTML","Entrenamiento"),
        Tarea(3,"React","Dictado Por Materia"),
        Tarea(4,"Javalin","Carrera UNQUI")

    )

    // Aca se cumplen con el protocolo CRUD (Crear, eliminar, actualizar y leer)

    fun agregarTarea(tarea : Tarea){
        tareas.add(Tarea(tarea.id,tarea.titulo,tarea.descripcion))
    }

    fun buscarTarea(id : Int): Tarea? = tareas.find { tarea -> tarea.id == id }

    fun borrarTarea(tarea : Tarea){

        if(tareas.contains(tarea)){
            tareas.remove(tarea)
        }
        else{
            throw NotFoundReason("No Se encontro la tarea")
        }
    }



}