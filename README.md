# clean-architecture-validation

<img src="https://github.com/raheemadamboev/clean-architecture-validation/blob/master/banner.png" />

<img align="right" width="296" height="600" src="https://github.com/raheemadamboev/clean-architecture-validation/blob/master/screen.gif" />

**Clean Architecture Validation**

Simple Clean Architecture android app. This project shows how to validate inputs in Clean Architecture architectural components using use-cases in domain layer. Domain layer should not contain any platform specific libraries, it should contain only pure kotlin code. As a result of this, unit testing them is possible and easy. In this project, use-cases also tested using JUnit4 framework. Dependencies are injected via Hilt. Thanks to Jetpack ViewModels and Jetpack SavedStateHandle, the application is robust to configuration changes and process death. Jetpack Compose is used for building simple material UI.

<a href="https://github.com/raheemadamboev/clean-architecture-validation/blob/master/app-debug.apk">Download demo</a>
