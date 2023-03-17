package ejercicios.practica.Conversor
class Conversor {

    fun conversor(valor : Double , metodo : IConversor) : Double{
        return metodo.convertidorGeneral(valor)
    }

}

