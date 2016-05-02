package battle.action

import battle.BattleScreen
import battle.character.Stats

/**
 * Created on 5/2/16.
 */
class Defend {

    val defender: Stats
    val screen: BattleScreen = BattleScreen()
    val defenceBoost: Int = 3

    constructor(defender: Stats) {
        this.defender = defender

        doDefend()
    }

    private fun doDefend() {
        boostDefence(defender)

        screen.defend(defender.name)
    }

    private fun boostDefence(defender: Stats) {
        defender.DEF += defenceBoost
    }

    // todo figure this out
    private fun restoreDefence(defender: Stats) {
        defender.DEF -= defenceBoost
    }
}