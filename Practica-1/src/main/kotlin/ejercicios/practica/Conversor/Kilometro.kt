package ejercicios.practica.Conversor

class  Kilometro : IConversor  {

    override fun convertidorGeneral(unidad : Double) : Double{
        return (unidad / 1.609)
    }
}