package org.example.toDoList.toDoList

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.example.toDoList.toDoList.controlador.TareaController
import org.example.toDoList.toDoList.model.Tarea

fun main() {
    val app = Javalin.create().start(7070)
    val cotroller = TareaController()

    app.routes {
        crud("tareas/{id}", TareaController())
        path("/tareas") {
            put{ ctx -> cotroller.update(ctx, ctx.pathParam("id"))}

            path("/done"){
                put(cotroller :: checkTarea)
            }

            path("/undone"){
                put(cotroller :: unCheckTarea)
            }
        }
    }

}

