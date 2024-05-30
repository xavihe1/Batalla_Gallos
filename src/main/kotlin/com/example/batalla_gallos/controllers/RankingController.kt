package com.example.batalla_gallos

import com.almasb.fxgl.net.Client
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL
import com.example.batalla_gallos.model.*
import javafx.scene.control.Label

class RankingController {

    @FXML
    lateinit var textoPrimero: Label

    @FXML
    lateinit var imagenPrimero: ImageView

    @FXML
    lateinit var textoSegundo: Label

    @FXML
    lateinit var imagenSegundo: ImageView

    @FXML
    lateinit var textoTercero: Label

    @FXML
    lateinit var imagenTercero: ImageView

    @FXML
    lateinit var exitButton: Button

    @FXML
    fun initialize() {
        mostrarRanking()
    }

    @FXML
    fun navigateToMenu() {
        val stage = exitButton.scene.window as Stage
        val url: URL? = javaClass.getResource("menuView.fxml")
        val root: Parent = FXMLLoader.load(url)
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }

    @FXML
    fun mostrarRanking() {
        //llamar funcion bajar usuarios

        usuarios = usuarios.sortedByDescending { it.puntuacion }
        if (usuarios.isNotEmpty()) {
            textoPrimero.text = usuarios[0].name
            imagenPrimero.image = Image(usuarios[0].urlPFP)
        }
        if (usuarios.size >= 2) {
            textoSegundo.text = usuarios[1].name
            imagenSegundo.image = Image(usuarios[1].urlPFP)
        }
        if (usuarios.size >= 3) {
            textoTercero.text = usuarios[2].name
            imagenTercero.image = Image(usuarios[2].urlPFP)
        }
    }
}