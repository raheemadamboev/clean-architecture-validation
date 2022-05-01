package xyz.teamgravity.cleanarchitecturevalidation.core.util

import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.util.MailMatcher

class FakeMailMatcher : MailMatcher {

    companion object {
        const val VALID_MAIL = "pitbull@gmail.com"
        const val INVALID_MAIL = "wtf"
    }

    override fun matches(mail: String): Boolean {
        return when(mail) {
            VALID_MAIL -> true
            else -> false
        }
    }
}