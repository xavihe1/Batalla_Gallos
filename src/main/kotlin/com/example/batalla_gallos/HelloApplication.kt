package com.example.batalla_gallos

import com.example.batalla_gallos.model.Cliente
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("menuView.fxml"))
        val scene = Scene(fxmlLoader.load(), 600.0, 400.0)
        stage.title = "Epicas batallas de rap!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}

var usuarios= listOf<Cliente>()
var palabras1player= listOf<String>()
var palabras2player= listOf<String>()

