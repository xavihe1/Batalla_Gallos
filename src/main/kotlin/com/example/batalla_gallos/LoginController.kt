package com.example.batalla_gallos

import com.sun.tools.javac.Main
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.awt.event.ActionEvent

class LoginController {

    @FXML
    private lateinit var user: TextField

    @FXML
    private lateinit var password: PasswordField

    fun login(actionEvent: ActionEvent) {
        val stage = user.scene.window as Stage
        val fxmlLoader = FXMLLoader(Main::class.java.getResource("game.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.scene = scene
    }
}