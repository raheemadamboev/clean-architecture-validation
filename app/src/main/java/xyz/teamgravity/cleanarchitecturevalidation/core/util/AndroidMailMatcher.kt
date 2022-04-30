package xyz.teamgravity.cleanarchitecturevalidation.core.util

import android.util.Patterns
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.util.MailMatcher

class AndroidMailMatcher : MailMatcher {

    override fun matches(mail: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(mail).matches()
    }
}