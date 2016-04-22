package battle

/**
 * Created on 4/18/16.
 */

class Screen {
    init {
        println("Prepare for battle!")
    }

    fun promptAction(): Action {
        for (action: Action in Action.values()) {
            var num = action.ordinal + 1
            println(num.toString() + ". " + action.name)
        }

        val input = promptInput()

        if (isInputValid(input)) {
            return performAction(input?.toInt() as Int)
        } else {
            println("Invalid action")
            return Action.NOTHING
        }
    }

    private fun promptInput(): String? {
        println("Pick an action: ")
        return readLine()
    }

    private fun isInputValid(input: String?): Boolean {
        if (input.isNullOrEmpty()) {
            return false
        }

        for (action: Action in Action.values()) {
            if (    (input?.toInt() == action.ordinal + 1) &&
                    (action != Action.NOTHING)) {
                return true
            }
        }

        return false
    }

    private fun performAction(input: Int): Action {
        when (input) {
            1 -> return Action.ATTACK
            2 -> return Action.DEFEND
            else -> return Action.NOTHING
        }
    }

    fun win() {
        println("You won! Congratulations!")
    }

    fun lose() {
        println("You lost. GAME OVER")
    }
}