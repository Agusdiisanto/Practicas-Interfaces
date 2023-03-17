package ejercicios.practica.RedSocialTest

import ejercicios.practica.RedSocial.RedSocial
import ejercicios.practica.RedSocial.Usuario
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RedSocialTest {

    private val usuarioAgus : Usuario = Usuario("Agustin", "agus", "agus@gmail.com", LocalDate.of(2002,11,3))
    private val usuarioSanti : Usuario = Usuario("Santiago", "santi", "santi@hotmail.com", LocalDate.of(2000,2,17))
    private val usuarioValen : Usuario = Usuario("Valen", "Valen", "santi@hotmail.com", LocalDate.of(2000,2,17))
    private val instagram : RedSocial = RedSocial()

    @Before
    fun setUp(){
        instagram.agregarUsuario(usuarioSanti)
        instagram.agregarUsuario(usuarioValen)
        instagram.agregarUsuario(usuarioAgus)
    }

    @Test
    fun test01_usuariosQueSeSiguenMutuamente(){

        usuarioSanti.seguirA(usuarioAgus)
        usuarioAgus.seguirA(usuarioSanti)
        usuarioAgus.seguirA(usuarioValen)

        assertTrue(instagram.usuariosAmigosDe(usuarioSanti).contains(usuarioAgus))
        assertFalse(instagram.usuariosAmigosDe(usuarioSanti).contains(usuarioValen))

    }

    @Test
    fun test02_usuariosQueNoSeSiguenMutuamente(){

        usuarioSanti.seguirA(usuarioAgus)
        usuarioAgus.seguirA(usuarioValen)

        assertFalse(instagram.usuariosAmigosDe(usuarioSanti).contains(usuarioAgus))
        assertFalse(instagram.usuariosAmigosDe(usuarioSanti).contains(usuarioValen))

    }







}