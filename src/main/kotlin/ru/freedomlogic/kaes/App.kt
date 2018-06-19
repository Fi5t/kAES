package ru.freedomlogic.kaes

fun main(args: Array<String>) {

    val aes = AES()
    val plainText = byteArrayOf(
            0x32, 0x43, 0xf6.toByte(), 0xa8.toByte(),
            0x88.toByte(), 0x5a, 0x30, 0x8d.toByte(),
            0x31, 0x31, 0x98.toByte(), 0xa2.toByte(),
            0xe0.toByte(), 0x37, 0x07, 0x34
    )

    val key = byteArrayOf(
            0x2b, 0x7e, 0x15, 0x16,
            0x28, 0xae.toByte(), 0xd2.toByte(), 0xa6.toByte(),
            0xab.toByte(), 0xf7.toByte(), 0x15, 0x88.toByte(),
            0x09, 0xcf.toByte(), 0x4f, 0x3c
    )

    println("Plain text: ${plainText.asHexString()}")
    println("Key: ${key.asHexString()}\n")

    val cipher = aes.encrypt(plainText, key)

    println("Cipher: ${cipher.asHexString()}")
    println("Decrypted text: ${aes.decrypt(cipher, key).asHexString()}")
}
