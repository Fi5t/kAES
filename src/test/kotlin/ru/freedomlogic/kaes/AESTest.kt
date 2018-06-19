package ru.freedomlogic.kaes

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

internal class AESTest {
    lateinit var aesInstance: AES

    private val plainText = byteArrayOf(
            0x32, 0x43, 0xf6.toByte(), 0xa8.toByte(),
            0x88.toByte(), 0x5a, 0x30, 0x8d.toByte(),
            0x31, 0x31, 0x98.toByte(), 0xa2.toByte(),
            0xe0.toByte(), 0x37, 0x07, 0x34
    )

    private val cipher = byteArrayOf(
            0x39, 0x25, 0x84.toByte(), 0x1d,
            0x02, 0xdc.toByte(), 0x09, 0xfb.toByte(),
            0xdc.toByte(), 0x11, 0x85.toByte(), 0x97.toByte(),
            0x19, 0x6a, 0x0b, 0x32
    )

    private val key = byteArrayOf(
            0x2b, 0x7e, 0x15, 0x16,
            0x28, 0xae.toByte(), 0xd2.toByte(), 0xa6.toByte(),
            0xab.toByte(), 0xf7.toByte(), 0x15, 0x88.toByte(),
            0x09, 0xcf.toByte(), 0x4f, 0x3c
    )

    @BeforeEach
    fun setUp() {
        aesInstance = AES()
    }

    @Test
    fun encrypt() {
        val result = aesInstance.encrypt(plainText, key)
        assertArrayEquals(cipher, result, "Arrays aren't identical")
    }

    @Test
    fun decrypt() {
        val result = aesInstance.decrypt(cipher, key)
        assertArrayEquals(plainText, result, "Arrays aren't identical")
    }
}