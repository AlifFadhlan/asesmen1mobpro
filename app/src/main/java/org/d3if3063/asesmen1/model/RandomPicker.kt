package org.d3if3063.asesmen1.model

import org.d3if3063.asesmen1.db.RanPickEntity
import java.util.*

fun RanPickEntity.generateRandomNumber() : RandomNumber {
    return RandomNumber(maxNumber, number)
}