package org.example.toDoList.toDoList.controlador

import io.javalin.apibuilder.CrudHandler
import io.javalin.http.Context
import org.example.toDoList.toDoList.dao.TareaDoList
import org.example.toDoList.toDoList.error.NotFoundReason
import org.example.toDoList.toDoList.model.Tarea
import org.example.toDoList.toDoList.model.TareaEstado
import java.util.Objects

class TareaController  : CrudHandler {

    val tareaDo : TareaDoList = TareaDoList()

    override fun create(ctx: Context) {
        var tareaUsuario = ctx.bodyAsClass<Tarea>(Tarea::class.java)
        tareaDo.agregarTarea(tareaUsuario)
    }

    override fun delete(ctx: Context, resourceId: String) {
    }


    override fun getAll(ctx: Context) {
        ctx.json(tareaDo.tareas)
    }

    override fun getOne(ctx: Context, resourceId: String) {
        val tarea : Tarea = busquedaDeTarea(ctx.pathParam("id").toInt())
        ctx.json(tarea)
    }

    override fun update(ctx: Context, resourceId: String) {
        val tareaID : Tarea = busquedaDeTarea(resourceId.toInt())
        val tareaBody : Tarea = ctx.bodyAsClass<Tarea>(Tarea::class.java)

        if(tareaID.estado == TareaEstado.Pendiente){
            tareaID.titulo = tareaBody.titulo
            tareaID.descripcion = tareaBody.descripcion
            tareaID.estado = TareaEstado.Completado
        }
        ctx.json(tareaID)
    }


    // Lo defino en otra funcion para que sea mas entendible el codigo

    fun busquedaDeTarea( id : Int ) : Tarea {

        // Con el signo de pregunta admiten NULL
        val tarea : Tarea? = tareaDo.buscarTarea(id)
        if (Objects.isNull(tarea)){
            throw NotFoundReason("No hay una tarea con dicho ID")
        }
        // Hay que ponerle !! para decirle que si o si es Distinto de NULL
        return tarea!!
    }


    fun checkTarea(ctx: Context){
        val id = ctx.pathParam("id").toInt()
        val tareaID = this.busquedaDeTarea(id)
        tareaID.completado()
        ctx.json(tareaID)
    }

    fun unCheckTarea(ctx: Context){
        val id = ctx.pathParam("id").toInt()
        val tareaID : Tarea? = this.busquedaDeTarea(id)

        if (Objects.isNull(tareaID)){
            throw NotFoundReason("No hay ninguna tarea")
        }

        tareaID!!.pendiente()
        ctx.json(tareaID!!)
    }

}