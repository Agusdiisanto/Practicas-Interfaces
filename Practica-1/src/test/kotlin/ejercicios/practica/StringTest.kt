package ejercicios.practica

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringTest {

    private val string : Strings = Strings()

    @Test
    fun test01_RevertDeString1(){
        assertEquals("aloh", string.revert1("hola"))
    }

    @Test
    fun test02_RevertDeString2(){
        assertEquals("aloh", string.revert2("hola"))
    }

    @Test
    fun test03_UnaPalabraEsCapicua(){
        assertTrue(string.isPalindrome("neuquen"))
    }

    @Test
    fun test04_UnaPalabraEsCapicua(){
        assertTrue(string.isPalindrome("aa"))
    }

    @Test
    fun test05_UnaPalabraEsCapicua(){
        assertTrue(string.isPalindrome("a"))
    }

    @Test
    fun test06_UnaPalabraNoEsCapicua(){
        assertTrue(string.isPalindrome(""))
    }

    @Test
    fun test07_UnaPalabraNoEsCapicua(){
        assertFalse(string.isPalindrome("as"))
    }

    @Test
    fun test08_UnaPalabraNoEsCapicua(){
        assertFalse(string.isPalindrome("AgustinYSanti"))
    }

    @Test
    fun test09_UnaPalabraTieneVocales(){
        assertEquals(7, string.vowels("Ácido clorhídrico"))
    }

    @Test
    fun test10_UnaOnomatopeyasNoTieneVocales(){
        assertEquals(0, string.vowels("Shhhh"))
    }

    @Test
    fun test11_CuandoUnaOracionTiene5Palabras(){
        assertEquals(1, string.words("a "))
    }

    @Test
    fun test12_CuandoUnaOracionTiene5Palabras(){
        assertEquals(5, string.words("construccion de interfaces de usuario "))
    }

}