package com.joeli.transfer

import com.joeli.transfer.utils.isValidAmount
import org.junit.Test

import org.junit.Assert.*

class ValidateUtilsUnitTest {
    @Test
    fun isValidAmount_isCorrect() {
        assertEquals(true, "1".isValidAmount())
        assertEquals(true, "100".isValidAmount())
        assertEquals(false, "".isValidAmount())
        assertEquals(false, "0".isValidAmount())
        assertEquals(false, "-1".isValidAmount())
        assertEquals(false, "1.1".isValidAmount())
        assertEquals(false, "abc".isValidAmount())
    }
}