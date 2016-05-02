package battle.action

import battle.BattleScreen
import battle.character.Stats

/**
 * Created on 4/22/16.
 */
class Action {

    val screen: BattleScreen = BattleScreen()

    fun orderBattle(hero: Stats, enemy: Stats) {
        when (screen.promptAction()) {
            ActionType.ATTACK -> {
                if (isHeroFaster(hero, enemy)) {
                    doAttack(hero, enemy)
                    doAttack(enemy, hero)
                } else {
                    doAttack(enemy, hero)
                    doAttack(hero, enemy)
                }
            }

            ActionType.DEFEND -> {
                doDefend(hero)
                doAttack(enemy, hero)
            }

            else -> {
                doNothing(hero)
                doAttack(enemy, hero)
            }
        }

        screen.printStats(hero, enemy)
    }

    private fun isHeroFaster(hero: Stats, enemy: Stats) = hero.AGI >= enemy.AGI

    private fun doAttack(attacker: Stats, defender: Stats) {
        Attack(attacker, defender)
    }

    private fun doDefend(defender: Stats) {
        Defend(defender)
    }

    private fun doNothing(hero: Stats) {
        screen.idle(hero.name)
    }

    fun win() {
        screen.win()
    }

    fun lose() {
        screen.lose()
    }
}