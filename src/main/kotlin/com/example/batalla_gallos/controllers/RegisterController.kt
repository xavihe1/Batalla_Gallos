package com.example.batalla_gallos.controllers

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.stage.Stage
import javafx.scene.control.Button
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField

class RegisterController {
    @FXML
    private lateinit var user: TextField

    @FXML
    private lateinit var password: PasswordField

    @FXML
    private lateinit var registerButton: Button

    private val usersGuardados = mutableMapOf<String, String>()

    @FXML
    private fun initialize() {
        registerButton.setOnAction {
            navigateToMenu()
        }
    }

    @FXML
    private fun login() {
        val username = user.text
        val pwd = password.text

        if (username.isNullOrEmpty() || pwd.isNullOrEmpty()) {
            showAlert(AlertType.ERROR, "Error", "El usuario y la contraseña no pueden estar vacíos.")
            return
        }

        if (usersGuardados.containsKey(username)) {
            showAlert(AlertType.ERROR, "Error", "El usuario ya está registrado.")
            return
        }

        usersGuardados[username] = pwd
        showAlert(AlertType.INFORMATION, "Registro Exitoso", "Usuario registrado correctamente.")
        navigateToMenu()
    }

    private fun navigateToMenu() {
        val loader = FXMLLoader(javaClass.getResource("login.fxml"))
        val root = loader.load<Parent>()
        val stage = registerButton.scene.window as Stage
        stage.scene.root = root
    }

    private fun showAlert(alertType: AlertType, title: String, content: String) {
        val alert = Alert(alertType)
        alert.title = title
        alert.headerText = null
        alert.contentText = content
        alert.showAndWait()
    }
}