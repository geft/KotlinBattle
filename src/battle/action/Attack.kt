package battle.action

import battle.BattleScreen
import battle.character.Stats
import java.util.*

/**
 * Created on 5/2/16.
 */
class Attack {

    var attacker: Stats
    var defender: Stats
    val screen: BattleScreen = BattleScreen()

    constructor(attacker: Stats, defender: Stats) {
        this.attacker = attacker
        this.defender = defender

        doAttack()
    }

    private fun doAttack() {
        var damage = attacker.ATK - defender.DEF

        if (damage <= 0) damage = 1

        defender.HP -= damage

        val isCritical: Boolean = calculateCritical()

        if (isCritical) damage *= 2

        screen.attack(attacker.name, defender.name, damage, isCritical)
    }

    private fun calculateCritical(): Boolean {
        var isCritical: Boolean = false

        if (Random().nextInt(5) == 1) {
            isCritical = true
        }
        return isCritical
    }
}