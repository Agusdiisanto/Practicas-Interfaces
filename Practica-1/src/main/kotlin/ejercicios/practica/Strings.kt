package ejercicios.practica

class Strings {

    fun revert1(palabra : String) : String{
        return palabra.reversed()
    }

    fun revert2(palabra : String) : String{

        var reverse : String = ""

        for ( i in palabra){
            reverse = i + reverse;
        }
        return reverse
    }

    fun isPalindrome(palabra : String) : Boolean {

        var longitud : Int  = palabra.length;
        var primero : Int = 0
        var ultimo : Int = palabra.length - 1

        while ( longitud > 0 && palabra[primero] == palabra[ultimo]){
            longitud -= 2;
            primero += 1
            ultimo -= 1;
        }
        return longitud <= 0 || palabra[primero] == palabra[ultimo]
    }

    fun vowels(palabra : String) : Int{
        var contador : Int = 0
        for (i in palabra){
            if (i=='a' || i=='e' || i=='i' || i=='o' || i=='u' ||
                i=='á' || i=='é' || i=='í' || i=='ó' || i=='ú' ||
                i=='A' || i=='E' || i=='I' || i=='O' || i=='U' ||
                i=='Á' || i=='É' || i=='Í' || i=='Ó' || i=='Ú' ){
                contador++
            }
        }
        return contador
    }

    fun words(oracion : String) : Int{
        if(oracion == ""){
            return 0
        }
        else if (oracion != " " && oracion.length == 1 ) {
            return 1
        }
        else{

            var longitud  : Int = oracion.length
            var contador  : Int = 0
            var primero   : Int = 0
            var siguiente : Int = 1

            while (longitud > 1){
                if (oracion[primero] != ' ' && oracion[siguiente] == ' '){
                    contador++
                }
                longitud--
                primero++
                siguiente++
            }
            return if (oracion[primero] == ' ') contador else contador+1;
        }
    }

}