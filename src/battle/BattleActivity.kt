package battle

import battle.action.Action
import battle.character.Enemy
import battle.character.Hero

/**
 * Created on 4/18/16.
 */

class BattleActivity {

    val action: Action
    val hero: Hero
    val enemy: Enemy

    init {
        action = Action()
        hero = Hero()
        enemy = Enemy()

        doBattle()
    }

    private fun doBattle() {
        var isGameOver = false

        while (!isGameOver) {
            action.orderBattle(hero, enemy)

            isGameOver = checkHp()
        }
    }

    private fun checkHp(): Boolean {
        var isGameOver: Boolean = false

        if (hero.HP == 0) {
            action.lose()
            isGameOver = true
        } else if (enemy.HP == 0) {
            action.win()
            isGameOver = true
        }
        return isGameOver
    }


}