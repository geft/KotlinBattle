package battle

/**
 * Created on 4/18/16.
 */

class Battle {

    val screen: Screen
    val player: Player
    val enemy: Enemy

    init {
        screen = Screen()
        player = Player()
        enemy = Enemy()

        doBattle()
    }

    private fun doBattle() {
        var isGameOver = false

        while (!isGameOver) {
            val action: Action = screen.promptAction()

            when (action) {
                Action.ATTACK -> doAttack()
                Action.DEFEND -> doDefend()
                else -> doNothing()
            }

            if (player.HP == 0) {
                screen.lose()
                isGameOver = true
            } else if (enemy.HP == 0) {
                screen.win()
                isGameOver = true
            }
        }
    }

    private fun doAttack() {
        println("Attack!")
    }

    private fun doDefend() {
        println("Defend!")
    }

    private fun doNothing() {
    }
}