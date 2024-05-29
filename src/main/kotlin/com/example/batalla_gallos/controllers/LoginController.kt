package com.example.batalla_gallos

import com.sun.tools.javac.Main
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.awt.event.ActionEvent
import java.net.URL

class LoginController {

    @FXML
    private lateinit var user: TextField

    @FXML
    private lateinit var password: PasswordField

    @FXML
    private lateinit var loginButton: Button

    @FXML
    lateinit var exitButton: Button

    @FXML
    fun comprobarLogin() {

    }

    @FXML
    fun irMenu() {
        val stage = exitButton.scene.window as Stage
        val url: URL? = javaClass.getResource("menuView.fxml")
        val root: Parent = FXMLLoader.load(url)
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }



}