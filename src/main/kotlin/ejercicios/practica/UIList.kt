package ejercicios.practica

class UIList {

    fun isSorted( lista : MutableList<Int>) : Boolean{
        return (lista.size <= 1) || (esAcendente(lista) || esDescendente(lista))
    }

    private fun esDescendente(lista: MutableList<Int>): Boolean {
        var primerElemento = 0
        var longitud = lista.size

        while ((longitud > 1) && (lista[primerElemento] < lista[primerElemento + 1])) {
            longitud--
            primerElemento++
        }
        return (longitud <= 1) || lista[primerElemento] < lista[primerElemento + 1]
    }

    private fun esAcendente(lista:  MutableList<Int>): Boolean {
        var primerElemento = 0
        var longitud = lista.size

        while ((longitud > 1) && (lista[primerElemento] > lista[primerElemento + 1])) {
            longitud--
            primerElemento++
        }
        return (longitud <= 1) || lista[primerElemento] > lista[primerElemento + 1]
    }

    fun orderList(list : MutableList<Int>, asc : Boolean) : MutableList<Int>{

        if(asc){
            return this.orderAsc(list)
        }
        else{
            return this.orderDesc(list)
        }
    }

    private fun orderAsc(list :  MutableList<Int>):  MutableList<Int> {

        val listaActual = list
        val listaAsc = mutableListOf<Int>()

        for (i in 0 until list.size){
            listaAsc.add(listaActual.min())
            listaActual.remove(listaActual.min())
        }
        return listaAsc
    }

    private fun orderDesc(list :  MutableList<Int>):  MutableList<Int> {

        val listaActual = list
        val listaAsc = mutableListOf<Int>()

        for (i in 0 until list.size){
            listaAsc.add(listaActual.max())
            listaActual.remove(listaActual.max())
        }
        return listaAsc
    }




}