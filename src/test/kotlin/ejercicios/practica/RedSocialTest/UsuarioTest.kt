package ejercicios.practica.RedSocialTest

import ejercicios.practica.Conversor
import ejercicios.practica.RedSocial.Usuario
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UsuarioTest {

    private val usuarioAgus : Usuario = Usuario("Agustin", "agus", "agus@gmail.com", LocalDate.of(2002,11,3))

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
        assertEquals("Agustin" , usuarioAgus.getNombreYApellido())
    }

    @Test
    fun test04_unUsuarioTieneNombreDeUsuario(){
        assertEquals("Agustin" , usuarioAgus.getNombreYApellido())
    }


}