package com.example.batalla_gallos



import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL

class MenuController {
    @FXML
    lateinit var irJuego: Button

    @FXML
    lateinit var irlogin: Button

    @FXML
    fun handleCreatePlayer() {
        val stage = irJuego.scene.window as Stage
        val url: URL? = javaClass.getResource("game.fxml")
        val root: Parent = FXMLLoader.load(url)
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }


    @FXML
    fun loginGo() {
        val stage = irlogin.scene.window as Stage
        val url: URL? = javaClass.getResource("login.fxml")
        val root: Parent = FXMLLoader.load(url)
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }






}