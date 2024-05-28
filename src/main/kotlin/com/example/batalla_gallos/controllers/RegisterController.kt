package com.example.batalla_gallos

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.stage.Stage
import javafx.scene.control.Button
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import java.net.URL

class RegisterController {
    @FXML
    private lateinit var user: TextField

    @FXML
    private lateinit var password: PasswordField

    @FXML
    private lateinit var imageLink: TextField

    @FXML
    private lateinit var registerButton: Button

    @FXML
    private lateinit var exitButton: Button

    private val usersGuardados = mutableMapOf<String, Pair<String, String>>()

    @FXML
    private fun initialize() {
        registerButton.setOnAction {
            login()
        }
        exitButton.setOnAction {
            navigateToMenu()
        }
    }

    @FXML
    private fun login() {
        val username = user.text
        val pwd = password.text
        var imgLink = imageLink.text

        if (username.isNullOrEmpty() || pwd.isNullOrEmpty() || imgLink.isNullOrEmpty()) {
            showAlert(AlertType.ERROR, "Error", "El usuario, la contraseña y el enlace de la imagen no pueden estar vacíos.")
            return
        }

        if (usersGuardados.containsKey(username)) {
            showAlert(AlertType.ERROR, "Error", "El usuario ya está registrado.")
            return
        }

        usersGuardados[username] = Pair(pwd, imgLink)
        showAlert(AlertType.INFORMATION, "Registro Exitoso", "Usuario registrado correctamente.")
        navigateToMenu()
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

    private fun showAlert(alertType: AlertType, title: String, content: String) {
        val alert = Alert(alertType)
        alert.title = title
        alert.headerText = null
        alert.contentText = content
        alert.showAndWait()
    }


}