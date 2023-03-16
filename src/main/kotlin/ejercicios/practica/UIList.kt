package ejercicios.practica

class UIList {

    fun isSorted( lista : ArrayList<Int>) : Boolean{

        var primerElemento = 0
        var longitud = lista.size

        while ((longitud >= 0) && (lista[primerElemento] > lista[primerElemento + 1])){
            longitud--
            primerElemento++
        }
        return lista[primerElemento] > lista[primerElemento+1]
    }

    fun orderList( lista : ArrayList<Int> , asc : Boolean) {

        var longitud = lista.size
        var primerElemento = 0



    }


}