package battle.character

/**
 * Created on 4/21/16.
 */
class Enemy : Stats {
    override var name: String = "Enemy"
    override var maxHP: Int = 5
    override var maxMP: Int = 2
    override var HP: Int = maxHP
    override var MP: Int = maxMP
    override var ATK: Int = 1
    override var DEF: Int = 1
    override var AGI: Int = 1
}