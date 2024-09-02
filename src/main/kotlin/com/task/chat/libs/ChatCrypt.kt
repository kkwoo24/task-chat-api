package com.task.chat.libs

import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

object ChatCrypt {
    private const val ALGORITHM = "AES"
    private const val TRANSFORMATION = "AES"
    private const val KEY = "1234567890123456"

    fun encrypt(input: String): String {

        Cipher.getInstance(TRANSFORMATION)
            .init(Cipher.ENCRYPT_MODE, SecretKeySpec(KEY.toByteArray(), ALGORITHM))

        val cipher = Cipher.getInstance(TRANSFORMATION)
        val secretKey = SecretKeySpec(KEY.toByteArray(), ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encryptedBytes = cipher.doFinal(input.toByteArray())

        return Base64.getEncoder().encodeToString(encryptedBytes)
    }

    fun decrypt(input: String): String {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        val secretKey = SecretKeySpec(KEY.toByteArray(), ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        val decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(input))

        return String(decryptedBytes)
    }
}