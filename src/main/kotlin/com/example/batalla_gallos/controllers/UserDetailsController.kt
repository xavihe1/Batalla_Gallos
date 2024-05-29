package com.example.batalla_gallos

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.awt.Label
import java.net.URL

class UserDetailsController {

    @FXML
    lateinit var name: Label

    @FXML
    lateinit var rank: Label

    @FXML
    lateinit var exitButton: Button

    @FXML
    lateinit var image: ImageView

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