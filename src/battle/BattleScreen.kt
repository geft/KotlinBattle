package battle

import battle.action.ActionType
import battle.character.Stats

/**
 * Created on 4/18/16.
 */

class BattleScreen {
    init {
        printSeparator()
    }

    fun promptAction(): ActionType {
        var actionType: ActionType

        for (action: ActionType in ActionType.values()) {
            var num = action.ordinal + 1
            println(num.toString() + ". " + action.name)
        }

        val input = promptInput()

        if (isInputValid(input)) {
            actionType = performAction(input?.toInt() as Int)
        } else {
            actionType = ActionType.NOTHING
        }

        printSeparator()

        return actionType
    }

    fun printStats(hero: Stats, enemy: Stats) {
        printSeparator()
        printHpMp(hero)
        printHpMp(enemy, true)
        printSeparator()
    }

    private fun printSeparator() {
        println("===================================")
    }

    private fun printHpMp(input: Stats, hideMP: Boolean = false) {
        var mpString = ", MP ${input.MP}/${input.maxMP}"

        if (hideMP) mpString = ""

        println("${input.name} HP ${input.HP}/${input.maxHP}$mpString")
    }

    private fun promptInput(): String? {
        println("Pick an action: ")
        return readLine()
    }

    private fun isInputValid(input: String?): Boolean {
        if (input.isNullOrEmpty()) {
            return false
        }

        for (action: ActionType in ActionType.values()) {
            if (    (input?.toInt() == action.ordinal + 1) &&
                    (action != ActionType.NOTHING)) {
                return true
            }
        }

        return false
    }

    private fun performAction(input: Int): ActionType {
        when (input) {
            1 -> return ActionType.ATTACK
            2 -> return ActionType.DEFEND
            else -> return ActionType.NOTHING
        }
    }

    fun win() {
        println("You won! Congratulations!")
    }

    fun lose() {
        println("You lost. GAME OVER")
    }

    fun attack(input: String, output: String, damage: Int, isCritical: Boolean = false) {
        if (isCritical) {
            println("Critical strike!")
        }

        println("$input attacked $output for $damage damage!")
    }

    fun defend(input: String) {
        println("$input's defence rose!")
    }

    fun idle(input: String) {
        println("$input did nothing")
    }
}