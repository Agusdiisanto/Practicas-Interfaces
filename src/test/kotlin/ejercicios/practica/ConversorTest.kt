package ejercicios.practica

import ejercicios.practica.Conversor.Conversor
import ejercicios.practica.Conversor.Kilometro
import ejercicios.practica.Conversor.Milla
import org.junit.Test
import kotlin.test.assertEquals

class ConversorTest {

    private val conversor : Conversor = Conversor()
    private val kilometro : Kilometro = Kilometro()
    private val milla : Milla = Milla()

    @Test
    fun test01_millasAKilometros(){
        assertEquals(1.609,conversor.conversor(1.0 , milla))
    }

    @Test
    fun test02_KilometrosAMilla(){
        assertEquals(2.0,conversor.conversor(3.218 , kilometro))
    }

    @Test
    fun test03_convertidorBidireccional(){

        assertEquals( 2.0,conversor.conversor(3.218, kilometro))
        assertEquals(1.609,conversor.conversor(1.0 , milla))
    }

}