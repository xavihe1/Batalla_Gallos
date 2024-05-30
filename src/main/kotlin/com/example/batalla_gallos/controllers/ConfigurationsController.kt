package com.example.batalla_gallos

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.Slider

class ConfigurationsController {

    @FXML
    lateinit var title: Label

    @FXML
    lateinit var timeText: Label

    @FXML
    lateinit var timeSlider: Slider

    @FXML
    private lateinit var tiempoSeleccionado: Label

    private var tiempo: Int = 20

    @FXML
    fun inicialize() {
        timeSlider.valueProperty().addListener { _, _, newValue ->
            tiempo = newValue.toInt()
            tiempoSeleccionado.text = "Time: $tiempo seconds"
        }
    }

    fun getTiempo(): Int {
        return tiempo
    }

}