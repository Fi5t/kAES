package ru.freedomlogic.kaes.internal

import kotlin.experimental.xor


data class Word(val w0: Byte, val w1: Byte, val w2: Byte, val w3: Byte) {
    companion object {
        fun empty() = Word(0, 0, 0, 0)

        fun fromByteArray(array: ByteArray): Word {
            return Word(
                    array[0],
                    array[1],
                    array[2],
                    array[3]
            )
        }
    }

    override fun toString(): String {
        val h0 = String.format("%02x", w0)
        val h1 = String.format("%02x", w1)
        val h2 = String.format("%02x", w2)
        val h3 = String.format("%02x", w3)

        return "$h0 $h1 $h2 $h3"
    }

    infix fun xor(word: Word): Word {
        return Word(
                w0 xor word.w0,
                w1 xor word.w1,
                w2 xor word.w2,
                w3 xor word.w3
        )
    }

    fun toByteArray() = byteArrayOf(w0, w1, w2, w3)
}