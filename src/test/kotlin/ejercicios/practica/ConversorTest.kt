package ejercicios.practica

import org.junit.Test
import kotlin.test.assertEquals

class ConversorTest {

    private val conversor : Conversor = Conversor()

    @Test
    fun test01_millasAKilometros(){
        assertEquals(1.609,conversor.convertirMillasAKilometros(1.0))
    }

    @Test
    fun test02_KilometrosAMilla(){
        assertEquals(2.0,conversor.convertirKilometrosAMillas(3.218))
    }

    @Test
    fun test03_convertidorBidireccional(){

        assertEquals( 2.0,conversor.conversorBidireccional(3.218, "Kilometro"))
        assertEquals(1.609,conversor.conversorBidireccional(1.0 , "Milla"))
    }

}