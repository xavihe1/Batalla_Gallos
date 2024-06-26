package com.example.batalla_gallos

import com.example.batalla_gallos.model.Cliente
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
import javafx.scene.image.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameController {

    @FXML
    private lateinit var img_player1: ImageView

    //LABELS PLY1
    @FXML
    private lateinit var palabra11: Label
    @FXML
    private lateinit var palabra12: Label
    @FXML
    private lateinit var palabra13: Label
    @FXML
    private lateinit var palabra14: Label
    @FXML
    private lateinit var palabra15: Label

    //LABELS PLY2

    @FXML
    private lateinit var palabra21: Label
    @FXML
    private lateinit var palabra22: Label
    @FXML
    private lateinit var palabra23: Label
    @FXML
    private lateinit var palabra24: Label
    @FXML
    private lateinit var palabra25: Label

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
    private lateinit var puntuacio1player: Label

    @FXML
    private var puntuacio1: Int = 0

    @FXML
    private lateinit var puntuacio1playerButton: Button

    @FXML
    private lateinit var puntuacio2player: Label

    @FXML
    private var puntuacio2: Int = 0

    @FXML
    private lateinit var puntuacio2playerButton: Button

    @FXML
    private lateinit var configurationImage: ImageView

    @FXML
    private lateinit var configurationButton: Button

    private var jugador1Finish = false


    //variable para llamar a la base de datos aqui

    private var countdown: Timeline? = null
    private var tiempo: Int = 20

    @FXML
    fun initialize() {
        startButon.setOnAction {
            startCountdown()
        }

        exitButton.setOnAction {
            navigateToMenu()
        }

        configurationButton.setOnAction {
            navigateToSettings()
        }
        val observableList = FXCollections.observableArrayList(usuarios.map { it.name })
        cb_player1.items = observableList
        cb_player2.items = observableList

        tiempo = ConfigurationsController.tiempo

        palabra11.text = palabras1player[0]
        palabra12.text = palabras1player[1]
        palabra13.text = palabras1player[2]
        palabra14.text = palabras1player[3]
        palabra15.text = palabras1player[4]

        palabra21.text = palabras2player[0]
        palabra22.text = palabras2player[1]
        palabra23.text = palabras2player[2]
        palabra24.text = palabras2player[3]
        palabra25.text = palabras2player[4]
    }

    @FXML
    private fun startCountdown() {
        var time = tiempo

        countdown?.stop()

        countdown = Timeline(
            KeyFrame(Duration.seconds(1.0), {
                time--
                counter.text = time.toString()
                if (time <= 0) {
                    //si ha acabado el jugaro 1 empieza el dos
                    if (!jugador1Finish) {
                        time = tiempo
                        jugador1Finish = true
                    } else { // si ya acabo el segundo, stop
                        countdown?.stop()
                    }
                }
            })
        )
        countdown?.cycleCount = tiempo
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

    @FXML
    fun navigateToSettings() {
        val stage = configurationButton.scene.window as Stage
        val url: URL? = javaClass.getResource("configurations.fxml")
        val loader = FXMLLoader(url)
        val root: Parent = loader.load<Parent>()
        val scene = Scene(root)
        stage.scene = scene
        stage.show()
    }

    @FXML
    fun imageOfThePlayer1(){
        var player= Cliente( "", "", 0)
        for (i in usuarios){
            if (i.name == cb_player1.value){
                player = i
            }
        }
        val image = Image(player.urlPFP)
        img_player1.image = image
    }


    @FXML
    fun imageOfThePlayer2(){
        var player= Cliente( "", "", 0)
        for (i in usuarios){
            if (i.name == cb_player2.value){
                player = i
            }
        }
        val image = Image(player.urlPFP)
        img_player2.image = image
    }

    @OptIn(DelicateCoroutinesApi::class)
    @FXML
    fun sumarPuntuacion1(){
        var puntuacion= Random.nextInt(1, 101)
        puntuacio1 += puntuacion
        puntuacio1player.text = "Points: ${puntuacio1+puntuacion}"

        GlobalScope.launch(Dispatchers.IO) {
            aumentarPuntuacion(cb_player1.value,puntuacion)
        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    @FXML
    fun sumarPuntuacion2(){
        var puntuacion= Random.nextInt(1, 101)
        puntuacio2 += puntuacion
        puntuacio2player.text = "Points: ${puntuacio2+puntuacion}"

        GlobalScope.launch(Dispatchers.IO) {
            aumentarPuntuacion(cb_player2.value,puntuacion)
        }
    }
}