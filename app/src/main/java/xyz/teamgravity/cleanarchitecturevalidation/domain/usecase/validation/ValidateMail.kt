package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation

import xyz.teamgravity.cleanarchitecturevalidation.R
import xyz.teamgravity.cleanarchitecturevalidation.core.util.UniversalText
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.util.MailMatcher

class ValidateMail(
    private val matcher: MailMatcher
) {

    operator fun invoke(mail: String): ValidationResult {
        return when {
            blank(mail) -> ValidationResult.Error(UniversalText.Resource(id = R.string.error_mail_blank))
            notMatches(mail) -> ValidationResult.Error(UniversalText.Resource(id = R.string.error_mail_not_matches))
            else -> ValidationResult.Success
        }
    }

    private fun blank(mail: String): Boolean {
        return mail.isBlank()
    }

    private fun notMatches(mail: String): Boolean {
        return !matcher.matches(mail)
    }
}