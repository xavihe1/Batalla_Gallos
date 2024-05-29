package com.example.batalla_gallos

import com.example.batalla_gallos.model.Cliente
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.stage.Stage
import javafx.scene.control.Button
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class RegisterController {

    var clientes= listOf<Cliente>()
    @FXML
    private lateinit var user: TextField

    @FXML
    private lateinit var password: PasswordField

    @FXML
    private lateinit var imageLink: TextField

    @FXML
    private lateinit var register: Button

    @FXML
    private lateinit var exitButton: Button



    @OptIn(DelicateCoroutinesApi::class)
    @FXML
    fun register() {
        GlobalScope.launch(Dispatchers.IO) {
            subirCliente()
        }
    }
    @FXML
    private suspend fun subirCliente() {
        var sePuede=true
        val username = user.text
        val pwd = password.text
        val imgLink = imageLink.text
        val usuario="$username $pwd $imgLink 0"
        println(usuario)
        clientes=obtenerClientesBD()
        clientes.forEach {
            println(it.name)
            if(it.name==username){
                sePuede=false
            }
        }
        if (sePuede){
            subirClienteBD(usuario)
        }
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

    private fun showAlert(alertType: AlertType, title: String, content: String) {
        val alert = Alert(alertType)
        alert.title = title
        alert.headerText = null
        alert.contentText = content
        alert.showAndWait()
    }


}