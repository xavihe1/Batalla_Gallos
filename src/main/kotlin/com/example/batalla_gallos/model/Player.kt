package com.example.batalla_gallos.model

abstract class Player (
    nom: String,
    ranking: Int,
    avatar: String
): GamePlayers(nom, ranking, avatar) {

    var victories: Int = 0
        protected set

    var defeats: Int = 0
        protected set

    abstract fun fight(player2: GamePlayers): Boolean

    protected fun win() {
        victories++
    }

    protected fun lose() {
        defeats++
    }

    override fun toString(): String {
        return super.toString() +
                "victories = $victories" +
                ", defeats = $defeats"
    }
}