package com.example.batalla_gallos.controllers

import com.example.batalla_gallos.sceneController
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.stage.Stage
import javafx.scene.control.Button
import java.awt.event.ActionEvent

class MenuController {


    fun goToGame(event: ActionEvent) {
        sceneController.switchToGame(event)
    }

    fun goToLogin(event: ActionEvent) {
        sceneController.switchToLogin(event)
    }


}