package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation

import xyz.teamgravity.cleanarchitecturevalidation.R
import xyz.teamgravity.cleanarchitecturevalidation.core.util.UniversalText

class ValidatePassword {

    companion object {
        private const val MINIMUM_LENGTH = 8
    }

    operator fun invoke(password: String): ValidationResult {
        return when {
            lessThanMinimum(password) -> ValidationResult.Error(
                UniversalText.Resource(
                    id = R.string.error_password_less_than_minimum,
                    MINIMUM_LENGTH
                )
            )
            notContainsLetter(password) -> ValidationResult.Error(UniversalText.Resource(id = R.string.error_password_not_contains_letter))
            notContainsDigit(password) -> ValidationResult.Error(UniversalText.Resource(id = R.string.error_password_not_contains_digit))
            else -> ValidationResult.Success
        }
    }

    private fun lessThanMinimum(password: String): Boolean {
        return password.length < MINIMUM_LENGTH
    }

    private fun notContainsLetter(password: String): Boolean {
        return !password.any { it.isLetter() }
    }

    private fun notContainsDigit(password: String): Boolean {
        return !password.any { it.isDigit() }
    }
}