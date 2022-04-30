package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation

import xyz.teamgravity.cleanarchitecturevalidation.core.util.UniversalText

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(val message: UniversalText)
}
