package ejercicios.practica

import ejercicios.practica.UIList
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UIListTest {
    private val lista : UIList = UIList()

    @Test
    fun test01_unaListaEstaOrdenada(){
        var listaDeNumeros : MutableList<Int> = mutableListOf(1,2,3)
        assertTrue(lista.isSorted(listaDeNumeros))
    }

    @Test
    fun test02_unaListaEstaOrdenada(){
        var listaDeNumeros : MutableList<Int> = mutableListOf(3,2,1)
        assertTrue(lista.isSorted(listaDeNumeros))
    }

    @Test
    fun test03_unaListaNoEstaOrdenada(){
        var listaDeNumeros : MutableList<Int> = mutableListOf(1,3,2)
        assertFalse(lista.isSorted(listaDeNumeros))
    }
    @Test
    fun test04_unaListaTieneUnSoloElemento(){
        var listaDeNumeros : MutableList<Int> = mutableListOf(2)
        assertTrue(lista.isSorted(listaDeNumeros))
    }

    @Test
    fun test05_unaListaNoTieneNingunElemento(){
        var listaDeNumeros : MutableList<Int> = mutableListOf()
        assertTrue(lista.isSorted(listaDeNumeros))
    }

    @Test
    fun test06_unaListaSeOrdenaDeFormaAcendente(){

        var listaDeNumeros : MutableList<Int> = mutableListOf(24,46,35,78)
        var listaOrdenadaAcendente : MutableList<Int> = mutableListOf(24,35,46,78)

        assertEquals(listaOrdenadaAcendente, lista.orderList(listaDeNumeros,true))
    }

    @Test
    fun test07_unaListaSeOrdenaDeFormaDescendente(){

        var listaDeNumeros : MutableList<Int> = mutableListOf(24,46,35,78)
        var listaDescendente : MutableList<Int> = mutableListOf(78,46,35,24)

        assertEquals(listaDescendente, lista.orderList(listaDeNumeros,false))

    }

    @Test
    fun test08_unaListaTieneUnElementosPrimos(){
        var nums : MutableList<Int> = mutableListOf(1,2,3,4,5)
        var numsPrimes : MutableList<Int> = mutableListOf(2,3,5)

        assertEquals(numsPrimes, lista.filterPrimes(nums))
    }

    @Test
    fun test09_unaListaTieneUnElementosPrimos(){
        var nums : MutableList<Int> = mutableListOf(1,2,3,4,5)
        var numsPowMap : MutableList<Int> = mutableListOf(1,4,9,16,25)
        assertEquals(numsPowMap, lista.powMap(nums))
    }

    @Test
    fun test10_unaLista(){
        var nums : MutableList<Int> = mutableListOf(1,1,2,3,5,8)
        assertEquals(94, lista.sumProdPros(nums))
    }

}