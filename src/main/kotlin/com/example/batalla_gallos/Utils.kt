package com.example.batalla_gallos

import com.example.batalla_gallos.model.Cliente
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.*
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun subirArchivo(file: File):String{
    val lector = FileReader(file)
    val buffer = BufferedReader(lector)
    var salir = false
    var line: String = buffer.readLine()

    var textoFiltrado=""
    while (!salir) {
        val paraulas = line.split(" ", ", ", ". ", ".", "·", "―", "'", ":", ";","?","!","\"")
        for (paraula in paraulas) {
            if (paraula != "" && paraula.length >= 4) {
                textoFiltrado+="${paraula.toLowerCase()} "
            }
        }
        try {
            line = buffer.readLine()
        } catch (e: Exception) {
            salir = true
        }
    }

    textoFiltrado = tratarTexto(textoFiltrado)
    return textoFiltrado
}



fun tratarTexto(texto: String): String {
    var textoFinal = texto

    // Partes de la expresión regular para números romanos
    val miles = "M{0,4}"
    val centenas = "(CM|CD|D?C{0,4})"
    val decenas = "(XC|XL|L?X{0,4})"
    val unidades = "(IX|IV|V?I{0,4})"

    // Expresión regular completa uniendo las partes
    val regexRomanos = "\\b$miles$centenas$decenas$unidades\\b".lowercase().toRegex()
    val regexPalabrasConNumeros = "\\b\\w*\\d+\\w*\\b".toRegex()

    //Aplicamos las expreciones regulares
    textoFinal = texto.replace(regexRomanos,"")
    textoFinal = textoFinal.replace(regexPalabrasConNumeros,"")

    //Eliminamos palabras repetidas
    val palabras = textoFinal.split("\\s+".toRegex())
    textoFinal = palabras.toCollection(LinkedHashSet()).joinToString(" ")
    textoFinal = textoFinal.replace("- ", " ")


    return textoFinal
}

@OptIn(InternalAPI::class)
suspend fun subirArchivoBD(texto:String){
    val client = HttpClient()

    client.post("http://127.0.0.1:8080/words") {
        body = texto
    }
}

@OptIn(InternalAPI::class)
suspend fun subirClienteBD(texto:String){
    val client = HttpClient()

    client.post("http://127.0.0.1:8080/clients") {
        body = texto
    }
}

suspend fun obtenerClientesBD():List<Cliente>{
    var clientes= listOf<Cliente>()
    val client = HttpClient()
    val mensaje=client.get("http://127.0.0.1:8080/clients/all")
    var x=mensaje.bodyAsText()
    val json = Json { ignoreUnknownKeys = true }
    clientes = json.decodeFromString<List<Cliente>>(x)
    return clientes
}

suspend fun obtenerPalabrasBD():List<String> {
    var palabras = listOf<String>()
    val client = HttpClient()
    val mensaje = client.get("http://127.0.0.1:8080/words")
    var x=mensaje.bodyAsText()
    val json = Json { ignoreUnknownKeys = true }
    palabras = json.decodeFromString<List<String>>(x)
    println(palabras)
    return palabras
}

@OptIn(InternalAPI::class)
suspend fun aumentarPuntuacion(name: String, puntuacion: Int) {
    var client = HttpClient()
    client.post("http://127.0.0.1:8080/clients/addPuntuacion") {
        body = "$name $puntuacion"
    }
}

