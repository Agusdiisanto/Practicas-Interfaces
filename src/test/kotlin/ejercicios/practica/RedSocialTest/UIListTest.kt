package ejercicios.practica.RedSocialTest

import ejercicios.practica.UIList
import org.junit.Test
import kotlin.test.assertTrue

class UIListTest {

    private val lista : UIList = UIList()




    @Test
    fun test01_unaListaEstaOrdenada(){

        var listaDeNumeros : ArrayList<Int> = arrayListOf(3,2,1)
        assertTrue(lista.isSorted(listaDeNumeros))

    }


}