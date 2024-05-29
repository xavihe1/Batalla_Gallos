package com.example.batalla_gallos


import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.FileChooser
import javafx.stage.Stage
import kotlinx.coroutines.*
import java.io.File
import java.net.URL

class MenuController {
    @FXML
    lateinit var irJuego: Button

    @FXML
    lateinit var irlogin: Button

    @FXML
    lateinit var irRegister: Button

    @FXML
    lateinit var subirPalabras: Button

    @FXML
    fun irJuego() {
        val stage = irJuego.scene.window as Stage
        val url: URL? = javaClass.getResource("game.fxml")
        val root: Parent = FXMLLoader.load(url)
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }


    @FXML
    fun irLogin() {
        val stage = irlogin.scene.window as Stage
        val url: URL? = javaClass.getResource("login.fxml")
        val root: Parent = FXMLLoader.load(url)
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }


    @FXML
    fun irRegister() {
        val stage = irRegister.scene.window as Stage
        val url: URL? = javaClass.getResource("register.fxml")
        val root: Parent = FXMLLoader.load(url)
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }

    @OptIn(DelicateCoroutinesApi::class)
    @FXML
    fun subirPalabras() {
        GlobalScope.launch(Dispatchers.IO) {
            subir()
        }
    }

    suspend fun subir(){
        val ficheroSelected= withContext(Dispatchers.Main) { buscarFichero() }
        if (ficheroSelected != null) {
            val filtrar=subirArchivo(ficheroSelected)
            subirArchivoBD(filtrar)
        }
    }

    @FXML
    fun buscarFichero(): File? {
        val fileChooser = FileChooser()
        fileChooser.title = "Seleccionar archivo"

        fileChooser.extensionFilters.addAll(
            FileChooser.ExtensionFilter("Text Files", "*.txt"),
            FileChooser.ExtensionFilter("All Files", "*.*")
        )

        val stage = subirPalabras.scene.window as Stage

        val selectedFile = fileChooser.showOpenDialog(stage)
        if (selectedFile != null) {
            println("Archivo seleccionado: ${selectedFile.absolutePath}")
        }
        return selectedFile
    }

}
