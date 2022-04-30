package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation

import xyz.teamgravity.cleanarchitecturevalidation.R
import xyz.teamgravity.cleanarchitecturevalidation.core.util.UniversalText

class ValidateTermsCondition {

    operator fun invoke(accepted: Boolean): ValidationResult {
        return when {
            notAccepted(accepted) -> ValidationResult.Error(UniversalText.Resource(id = R.string.error_terms_condition_not_accepted))
            else -> ValidationResult.Success
        }
    }

    private fun notAccepted(accepted: Boolean): Boolean {
        return !accepted
    }
}