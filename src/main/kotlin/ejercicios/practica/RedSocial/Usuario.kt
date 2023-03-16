package ejercicios.practica.RedSocial

import java.time.LocalDate

class Usuario {
    private var nombreYApellido: String
    private var nombreID: String
    private var email : String
    private var fechaNacimiento : LocalDate
    private var seguidores : ArrayList<Usuario>
    private var seguidos : ArrayList<Usuario>

    constructor(nombre: String, nombreID: String, email: String, nacimiento: LocalDate) {
                    this.nombreYApellido = nombre
                    this.nombreID = nombreID
                    this.email = email
                    this.fechaNacimiento = nacimiento
                    this.seguidores = ArrayList()
                    this.seguidos = ArrayList()
    }

    fun edad() : Int {
        val añoActual : Int = LocalDate.now().year
        val añoNacimiento : Int = this.fechaNacimiento.year

        return añoActual - añoNacimiento;
    }

    fun seguirA( usuario : Usuario){
        this.seguidos.add(usuario);
        usuario.agregarSeguidor(this);
    }

    private fun agregarSeguidor(usuario: Usuario) {
        this.seguidores.add(usuario)
    }

    fun tieneGmail() : Boolean{
        return "@gmail" in this.email
    }

    fun getNombreYApellido(): String {
        return this.nombreYApellido;
    }

    fun cambioDeMail(mail: String) {
        this.email = mail;
    }

    fun getAmigos(): ArrayList<Usuario> {
        var amigos : ArrayList<Usuario> = ArrayList()
        for (usuario in this.seguidores){
           if(usuario.meSigue(this)){
               amigos.add(usuario)
           }
        }
        return amigos;  // Se puede hacer tambien con filter
    }

    fun meSigue(usuario: Usuario) : Boolean {
        return this.seguidores.contains(usuario);
    }

    fun sigueA(usuario: Usuario) : Boolean {
        return this.seguidos.contains(usuario);
    }

    fun getFechaNacimiento(): LocalDate {
        return this.fechaNacimiento
    }

    fun cantidadSeguidores(): Int {
        return this.seguidores.size
    }

    fun cantidadDeSeguidos(): Int {
        return this.seguidos.size
    }


}
