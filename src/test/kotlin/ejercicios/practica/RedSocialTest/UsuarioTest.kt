package ejercicios.practica.RedSocialTest

import ejercicios.practica.RedSocial.Usuario
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UsuarioTest {

    private val usuarioAgus : Usuario = Usuario("Agustin", "agus", "agus@gmail.com", LocalDate.of(2002,11,3))
    private val usuarioSanti : Usuario = Usuario("Santiago", "santi", "santi@hotmail.com", LocalDate.of(2000,2,17))
    private val usuarioValen : Usuario = Usuario("Valen", "Valen", "santi@hotmail.com", LocalDate.of(2000,2,17))


    @Test
    fun test01_unUsuarioTieneGmail(){
        assertTrue(usuarioAgus.tieneGmail())
    }

    @Test
    fun test02_unUsuarioNoTieneGmail(){
        usuarioAgus.cambioDeMail("agus@hotmail.com");
        assertFalse(usuarioAgus.tieneGmail())
    }

    @Test
    fun test03_unUsuarioTieneNombreYApellido(){
        assertEquals("Agustin" , usuarioAgus.nombreYApellido)
    }

    @Test
    fun test04_unUsuarioTieneNombreDeUsuario(){
        assertEquals("Agustin" , usuarioAgus.nombreID)
    }

    @Test
    fun test05_unUsuarioTieneUnaFechaDeNacimiento(){
        assertEquals(LocalDate.of(2002,11,3) , usuarioAgus.fechaNacimiento)
    }

    @Test
    fun test06_unUsuarioTienePuedeTenerSeguidores(){

        usuarioValen.seguirA(usuarioAgus)
        usuarioSanti.seguirA(usuarioAgus)

        assertEquals(2 , usuarioAgus.cantidadSeguidores())
        assertTrue(usuarioAgus.meSigue(usuarioSanti))
        assertTrue(usuarioAgus.meSigue(usuarioValen))
    }

    @Test
    fun test07_unUsuarioTienePuedeTenerSeguidos(){

        usuarioAgus.seguirA(usuarioSanti)
        usuarioAgus.seguirA(usuarioValen)

        assertEquals(2 , usuarioAgus.cantidadDeSeguidos())
        assertTrue(usuarioAgus.sigueA(usuarioSanti))
        assertTrue(usuarioAgus.sigueA(usuarioValen))
    }


}