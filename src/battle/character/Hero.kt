package battle.character

/**
 * Created on 4/21/16.
 */
class Hero : Stats {
    override var name: String = "Hero"
    override var maxHP: Int = 10
    override var maxMP: Int = 5
    override var ATK: Int = 1
    override var DEF: Int = 1
    override var AGI: Int = 1
    override var HP: Int = maxHP
    override var MP: Int = maxMP
}