package com.example.batalla_gallos

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.stage.Stage
import java.net.URL

class ConfigurationsController {

    @FXML
    lateinit var title: Label

    @FXML
    lateinit var timeText: Label

    @FXML
    lateinit var timeSlider: Slider

    @FXML
    private lateinit var tiempoSeleccionado: Label

    @FXML
    private lateinit var backButton: Button

    companion object {
        var tiempo: Int = 20
    }

    @FXML
    fun inicialize() {
        timeSlider.value = tiempo.toDouble()
        tiempoSeleccionado.text = "Time: ${timeSlider.value.toInt()} seconds"

        timeSlider.valueProperty().addListener { _, _, newValue ->
            tiempo = newValue.toInt()
            tiempoSeleccionado.text = "Time: $tiempo seconds"
        }
    }


    @FXML
    fun irJuego() {
        val stage = backButton.scene.window as Stage
        val url: URL? = javaClass.getResource("game.fxml")
        val root: Parent = FXMLLoader.load(url)
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }

}