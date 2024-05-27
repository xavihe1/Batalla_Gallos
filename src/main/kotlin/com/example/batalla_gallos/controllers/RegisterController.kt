package com.example.batalla_gallos.controllers

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
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

    @FXML
    private fun initialize() {
        registerButton.setOnAction {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        val loader = FXMLLoader(javaClass.getResource("login.fxml"))
        val root = loader.load<Parent>()
        val stage = registerButton.scene.window as Stage
        stage.scene.root = root
    }
}