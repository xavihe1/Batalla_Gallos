package com.example.batalla_gallos

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL

class RankingController {

    @FXML
    lateinit var imagenFondo: ImageView

    @FXML
    lateinit var imagenPrimero: ImageView

    @FXML
    lateinit var imagenSegundo: ImageView

    @FXML
    lateinit var imagenTercero: ImageView

    @FXML
    lateinit var exitButton: Button


    @FXML
    fun navigateToMenu() {
        val stage = exitButton.scene.window as Stage
        val url: URL? = javaClass.getResource("menuView.fxml")
        val root: Parent = FXMLLoader.load(url)
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }
}