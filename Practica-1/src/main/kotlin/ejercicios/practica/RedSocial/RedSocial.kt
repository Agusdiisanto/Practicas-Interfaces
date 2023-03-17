package ejercicios.practica.RedSocial

class RedSocial {

    private val usuarios : ArrayList<Usuario> = ArrayList();

    fun agregarUsuario( usuario : Usuario){
        usuarios.add(usuario)
    }

    fun usuariosAmigosDe(usuario : Usuario) : ArrayList<Usuario>{
        return usuario.getAmigos()
    }



}