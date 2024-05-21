package com.example.batalla_gallos

import com.example.batalla_gallos.model.Players
import javafx.fxml.FXML
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import java.awt.Button

class GameController {

    @FXML
    private lateinit var img_player1: ImageView

    @FXML
    private lateinit var img_player2: ImageView

    @FXML
    private lateinit var bt_start: Button

    @FXML
    private lateinit var cb_player1: ComboBox<String>

    @FXML
    private lateinit var cb_player2: ComboBox<String>

    @FXML
    private lateinit var lb_combatResult: Label

    private val players = ArrayList<Players>()
    private var selectedPlayer1 = ""
    private var selectedPlayer2 = ""



}