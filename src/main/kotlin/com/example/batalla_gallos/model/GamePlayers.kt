package com.example.batalla_gallos.model

abstract class GamePlayers (
    val nom: String,
    val ranking: Int,
    val avatar: String
) {
    val id: Int

    init {
        id = playerCounter++
    }

    private fun escriureNom(nom: String): String {
        return "%-7s".format(nom)
    }

    companion object {
        private var playerCounter = 1
    }
}