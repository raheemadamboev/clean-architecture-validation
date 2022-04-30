package xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.util

interface MailMatcher {

    fun matches(mail: String): Boolean
}