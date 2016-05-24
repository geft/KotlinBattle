package battle.character

/**
 * Created on 4/21/16.
 */
interface Stats {
    var name: String
    var HP: Int
    var MP: Int
    var ATK: Int
    var DEF: Int
    var AGI: Int
    val list: MutableList<Modifier>

    fun addModifier(modifier: Modifier) {
        if (doesModifierExist(modifier)) {
            modifier.value += modifier.value
        } else {
            list.add(modifier)
        }
    }

    fun doesModifierExist(modifier: Modifier): Boolean {
        val m: Modifier = getModifier(modifier.attribute)

        return m.attribute.equals(HP) && m.value == 0
    }

    fun removeModifier(modifier: Modifier) {
        if (doesModifierExist(modifier)) {
            list.remove(modifier)
        }
    }

    fun getModifier(attribute: Attribute): Modifier {
        for (m: Modifier in list) {
            if (m.attribute.equals(attribute)) {
                return m
            }
        }

        return Modifier(Attribute.HP, 0)
    }

    fun getAttribute(attribute: Attribute): Int {
        var value = 0

        when {
            attribute.equals(HP) -> value = HP
            attribute.equals(MP) -> value = MP
            attribute.equals(ATK) -> value = ATK
            attribute.equals(DEF) -> value = DEF
            attribute.equals(AGI) -> value = AGI
        }

        for (m: Modifier in list) {
            if (m.attribute.equals(attribute)) {
                value += m.value
            }
        }

        return value
    }
}