package com.example.batalla_gallos.controllers

import com.example.batalla_gallos.HelloApplication
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import java.awt.event.ActionEvent

class SceneController {
    lateinit var stage:Stage
    lateinit var scene:Scene
    lateinit var root:Parent

    fun switchToGame(event: ActionEvent) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("game-view.fxml"))
        root = fxmlLoader.load()
        stage = (event.source as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
    }
    fun switchToLogin(event: ActionEvent) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("login-view.fxml"))
        root = fxmlLoader.load()
        stage = (event.source as Node).scene.window as Stage
        scene = Scene(root)
        stage.scene = scene
        stage.show()
    }
}