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

    fun filterPrimes(list : MutableList<Int>) : List<Int>{
        return list.filter{n -> isPrime(n)}
    }

    private fun isPrime(num : Int) : Boolean{
        var idx = 2
        while(idx < num && num % idx != 0){
            idx++
        }
        return num >= 2 && idx == num
    }

    fun powMap(list : MutableList<Int>) : List<Int>{
        return list.map {n -> n*n}
    }

    fun sumProdPros(list : MutableList<Int>) : Int{

        var listaModificada : MutableList<Int> = mutableListOf<Int>()
        var indice = 1

        for (i in list){
            listaModificada.add(i*indice)
            indice++
        }
        return listaModificada.sum()
    }
}