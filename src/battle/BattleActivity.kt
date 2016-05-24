package battle

import battle.action.Action
import battle.character.Enemy
import battle.character.Hero
import battle.enemy.Goblin
import battle.enemy.Slime
import java.util.*

/**
 * Created on 4/18/16.
 */

class BattleActivity {

    val action: Action
    val hero: Hero
    var enemy: Enemy

    init {
        action = Action()
        hero = Hero()
        enemy = selectEnemy()

        doBattle()
    }

    private fun selectEnemy(): Enemy {
        val list: List<Enemy> = listOf(
                Goblin(),
                Slime())
        val selected: Int = Random().nextInt(list.size)

        return list.get(selected)
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