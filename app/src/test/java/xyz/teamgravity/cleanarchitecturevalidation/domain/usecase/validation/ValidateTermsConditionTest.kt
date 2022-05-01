package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ValidateTermsConditionTest {

    private lateinit var validateTermsCondition: ValidateTermsCondition

    @Before
    fun setUp() {
        validateTermsCondition = ValidateTermsCondition()
    }

    @Test
    fun `terms condition not accepted, returns error`() {
        val accepted = false
        val result = validateTermsCondition(accepted)
        assertThat(result is ValidationResult.Error).isTrue()
    }

    @Test
    fun `terms condition accepted, returns success`() {
        val accepted = true
        val result = validateTermsCondition(accepted)
        assertThat(result is ValidationResult.Success).isTrue()
    }
}