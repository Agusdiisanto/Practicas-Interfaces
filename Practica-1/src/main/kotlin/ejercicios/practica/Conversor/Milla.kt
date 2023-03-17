package ejercicios.practica.Conversor

class Milla :IConversor {

    override fun convertidorGeneral(unidad : Double) : Double{
        return (unidad * 1.609)
    }

}