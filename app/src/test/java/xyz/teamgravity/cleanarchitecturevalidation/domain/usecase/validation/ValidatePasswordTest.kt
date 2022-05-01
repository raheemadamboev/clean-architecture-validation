package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ValidatePasswordTest {

    private lateinit var validatePassword: ValidatePassword

    @Before
    fun setUp() {
        validatePassword = ValidatePassword()
    }

    @Test
    fun `less than minimum length, returns error`() {
        val password = "raheem"
        val result = validatePassword(password)
        assertThat(result is ValidationResult.Error).isTrue()
    }

    @Test
    fun `not contains any letter, returns error`() {
        val password = "12345678"
        val result = validatePassword(password)
        assertThat(result is ValidationResult.Error).isTrue()
    }

    @Test
    fun `not contains any digit, returns error`() {
        val password = "raheemadamboev"
        val result = validatePassword(password)
        assertThat(result is ValidationResult.Error).isTrue()
    }

    @Test
    fun `more than minimum, contains a letter, contains a digit, returns success`() {
        val password = "cristianoronaldo7"
        val result = validatePassword(password)
        assertThat(result is ValidationResult.Success).isTrue()
    }
}