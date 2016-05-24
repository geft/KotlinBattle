package battle.character

/**
 * Created on 4/21/16.
 */
class Hero : Stats {
    override var name: String = "Hero"
    override var HP: Int = 20
    override var MP: Int = 10
    override var ATK: Int = 1
    override var DEF: Int = 1
    override var AGI: Int = 1
    override val list: MutableList<Modifier> = mutableListOf<Modifier>()
}