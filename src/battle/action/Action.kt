package battle.action

import battle.BattleScreen
import battle.character.Stats

/**
 * Created on 4/22/16.
 */
class Action {

    val defenceBoost: Int = 3
    val screen: BattleScreen

    init {
        screen = BattleScreen()
    }

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
                restoreDefence(hero)
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
        var damage = attacker.ATK - defender.DEF

        if (damage <= 0) {
            damage = 1
        }

        defender.HP -= damage

        screen.attack(attacker.name, defender.name, damage)
    }

    private fun doDefend(defender: Stats) {
        boostDefence(defender)

        screen.defend(defender.name)
    }

    private fun boostDefence(defender: Stats) {
        defender.DEF += defenceBoost
    }

    private fun restoreDefence(defender: Stats) {
        defender.DEF -= defenceBoost
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