package com.example.batalla_gallos

import com.example.batalla_gallos.model.GamePlayers
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.control.Button
import javafx.stage.Stage
import javafx.util.Duration
import java.awt.Image
import java.net.URL

class GameController {

    @FXML
    private lateinit var img_player1: ImageView

    @FXML
    private lateinit var img_player2: ImageView

    @FXML
    private lateinit var startButon: Button

    @FXML
    private lateinit var counter: Label

    @FXML
    private lateinit var cb_player1: ComboBox<String>

    @FXML
    private lateinit var cb_player2: ComboBox<String>

    @FXML
    private lateinit var exitButton: Button

    @FXML
    private lateinit var palabrasJugador1: Label

    @FXML
    private lateinit var palabrasJuagdor2: Label

    @FXML
    private lateinit var puntosJugador1: Label

    @FXML
    private lateinit var puntosJugador2: Label

    //variable para llamar a la base de datos aqui


    private val players = ArrayList<GamePlayers>()
    private var selectedPlayer1 = ""
    private var selectedPlayer2 = ""
    private var countdown: Timeline? = null

    @FXML
    fun initialize() {
        startButon.setOnAction {
            startCountdown()
        }

        exitButton.setOnAction {
            navigateToMenu()
        }

        val observableList = FXCollections.observableArrayList(usuariosLoged)
        cb_player1.items = observableList
        cb_player2.items = observableList

    }

    @FXML
    private fun startCountdown() {
        var time = 20

        countdown?.stop()

        countdown = Timeline(
            KeyFrame(Duration.seconds(1.0), {
                time--
                counter.text = time.toString()
                if (time <= 0) {
                    countdown?.stop()
                }
            })
        )
        countdown?.cycleCount = 20
        countdown?.play()
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

    /*
    fun loadImage(username: String, imageView: ImageView) {
        val playerData = database.getPlayerData(username)
        if (playerData?.imageUrl != null) {
            val image = Image(playerData.imageUrl)
            Platform.runLater {
                imageView.image = image
            }
        }
    }
     */


    /*
    fun imagesOfThePlayers(){
        val url:String = ""
        val image = Image(url)
        img_player1.image = image
    }
    */
}