package battle.enemy

import battle.character.Enemy
import battle.character.Modifier

/**
 * Created on 5/24/16.
 */
class Slime : Enemy() {
    override var name: String = "Slime"
    override var HP: Int = 10
    override var MP: Int = 3
    override var ATK: Int = 1
    override var DEF: Int = 2
    override var AGI: Int = 1
    override val list: MutableList<Modifier> = mutableListOf<Modifier>()
}