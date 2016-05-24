package battle.enemy

import battle.character.Enemy
import battle.character.Modifier

/**
 * Created on 5/24/16.
 */
class Goblin : Enemy() {
    override var name: String = "Goblin"
    override var HP: Int = 5
    override var MP: Int = 0
    override var ATK: Int = 2
    override var DEF: Int = 1
    override var AGI: Int = 3
    override val list: MutableList<Modifier> = mutableListOf<Modifier>()
}