package ejercicios.practica

class Conversor {

    fun convertirMillasAKilometros( milla: Double) : Double{
        return (milla * 1.609)
    }

    fun convertirKilometrosAMillas(kilometro : Double) : Double{
        return (kilometro /  1.609)
    }

    fun conversorBidireccional (valor : Double, unidad : String): Double{
        if(unidad == "Kilometro"){
            return (valor /  1.609)
        }
        return (valor * 1.609)
    }



}