package ru.freedomlogic.kaes

import ru.freedomlogic.kaes.internal.Word
import kotlin.experimental.xor

fun ByteArray.asHexString() = this.map { String.format("%02x ", it) }.reduce { acc, s -> acc + s }

fun Array<Word>.getBytes() = this.map { it.toByteArray() }.reduce { acc, bytes -> acc.plus(bytes) }

infix fun ByteArray.xor(byteArray: ByteArray): ByteArray {
    val result = ByteArray(this.size)

    for (i in this.indices) {
        result[i] = this[i] xor byteArray[i]
    }

    return result
}

infix fun Byte.gmul(b: Byte): Byte {
    var tmpA = this.toInt()
    var tmpB = b.toInt()

    var p = 0
    var hiBitSet: Int

    for (i in 0 until 8) {
        if ((tmpB and 0x01) == 1) {
            p = (p xor tmpA) and 0xff
        }

        hiBitSet = tmpA and 0x80
        tmpA = tmpA shl 1

        if (hiBitSet == 0x80) {
            tmpA = tmpA xor 0x1b
        }

        tmpB = (tmpB shr 1) and 0x7f
    }

    return p.toByte()
}