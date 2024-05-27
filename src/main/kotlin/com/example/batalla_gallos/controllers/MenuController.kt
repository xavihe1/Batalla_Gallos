package com.example.batalla_gallos.controllers

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.stage.Stage
import javafx.scene.control.Button

class MenuController {
    @FXML
    private lateinit var playButton: Button

    @FXML
    private lateinit var registerButton: Button

    @FXML
    private lateinit var loginPlayer1: Button

    @FXML
    private lateinit var loginPlayer2: Button

    @FXML
    private lateinit var wordsButton: Button


    @FXML
    private fun inicialize() {
        playButton.setOnAction { navigate("game.fxml") }
        registerButton.setOnAction { navigate("register.fxml") }
        loginPlayer1.setOnAction { navigate("login.fxml") }
        loginPlayer2.setOnAction { navigate("login.fxml") }
        wordsButton.setOnAction { navigate("") }
    }

    private fun navigate(fxmlFile: String) {
        val loader = FXMLLoader(javaClass.getResource(fxmlFile))
        val root = loader.load<Parent>()
        val stage = playButton.scene.window as Stage
        stage.scene.root = root
    }
}