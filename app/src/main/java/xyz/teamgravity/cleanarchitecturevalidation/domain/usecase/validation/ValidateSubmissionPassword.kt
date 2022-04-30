package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation

import xyz.teamgravity.cleanarchitecturevalidation.R
import xyz.teamgravity.cleanarchitecturevalidation.core.util.UniversalText

class ValidateSubmissionPassword {

    operator fun invoke(password: String, submissionPassword: String): ValidationResult {
        return when {
            notSame(
                password = password,
                submissionPassword = submissionPassword
            ) -> ValidationResult.Error(UniversalText.Resource(id = R.string.error_password_not_same))
            else -> ValidationResult.Success
        }
    }

    private fun notSame(password: String, submissionPassword: String): Boolean {
        return password != submissionPassword
    }
}