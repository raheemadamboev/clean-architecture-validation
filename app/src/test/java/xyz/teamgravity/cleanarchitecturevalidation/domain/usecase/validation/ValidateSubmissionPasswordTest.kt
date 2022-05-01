package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ValidateSubmissionPasswordTest {

    private lateinit var validateSubmissionPassword: ValidateSubmissionPassword

    @Before
    fun setUp() {
        validateSubmissionPassword = ValidateSubmissionPassword()
    }

    @Test
    fun `not identical to original password, returns error`() {
        val password = "raheemadamboev7"
        val submissionPassword = "raheemsterling7"
        val result = validateSubmissionPassword(password = password, submissionPassword = submissionPassword)
        assertThat(result is ValidationResult.Error).isTrue()
    }

    @Test
    fun `identical to original password, returns success`(){
        val password = "lionelmessi10"
        val submissionPassword = "lionelmessi10"
        val result = validateSubmissionPassword(password = password, submissionPassword = submissionPassword)
        assertThat(result is ValidationResult.Success).isTrue()
    }
}