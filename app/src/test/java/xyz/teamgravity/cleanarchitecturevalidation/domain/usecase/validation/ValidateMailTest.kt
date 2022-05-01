package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import xyz.teamgravity.cleanarchitecturevalidation.core.util.FakeMailMatcher
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.util.MailMatcher

class ValidateMailTest {

    private lateinit var mailMatcher: MailMatcher
    private lateinit var validateMail: ValidateMail

    @Before
    fun setUp() {
        mailMatcher = FakeMailMatcher()
        validateMail = ValidateMail(mailMatcher)
    }

    @Test
    fun `blank, returns error`() {
        val mail = "    "
        val result = validateMail(mail)
        assertThat(result is ValidationResult.Error).isTrue()
    }

    @Test
    fun `invalid mail, returns error`() {
        val mail = FakeMailMatcher.INVALID_MAIL
        val result = validateMail(mail)
        assertThat(result is ValidationResult.Error).isTrue()
    }

    @Test
    fun `not blank, valid mail, returns success`() {
        val mail = FakeMailMatcher.VALID_MAIL
        val result = validateMail(mail)
        assertThat(result is ValidationResult.Success).isTrue()
    }
}