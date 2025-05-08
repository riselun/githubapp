---
title: GitHub Android App
author: Aaron Luo
date: May 7, 2025
---

# GitHub Android Application

A native Android application that allows users to browse GitHub content, search repositories, view repository details, and interact with GitHub using their account.
UML class diagram, architecture Diagram and design document is in the "docs" folder. You can use the test token：
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

## Features

### User Features
- Browse trending GitHub repositories without login
- View repository details including stars, forks, language, and issues
- Search repositories by name and filter by programming language
- Login with GitHub personal access token
- View personal profile and repositories
- Create issues for repositories
- Support for both portrait and landscape modes
- Proper error handling for network issues

### Technical Features
- Modern Android architecture with MVVM pattern
- Jetpack Compose UI
- Kotlin Coroutines for asynchronous operations
- Dependency Injection with Hilt
- GitHub REST API integration
- Persistent authentication using DataStore
- Unit tests and UI tests

## Architecture

The application follows the MVVM (Model-View-ViewModel) architecture pattern and is organized into the following layers:

### Data Layer
- **API**: Interfaces and implementations for the GitHub REST API
- **Models**: Data classes representing GitHub entities
- **Repository**: Single source of truth for the application data
- **Local**: Local storage for user preferences and authentication

### UI Layer
- **Screens**: Composable UI screens for different features
- **ViewModels**: Business logic and state management
- **Components**: Reusable UI components

### DI Layer
- **AppModule**: Dependency injection setup with Hilt

## Technologies Used

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Networking**: Retrofit, OkHttp
- **Image Loading**: Coil
- **Dependency Injection**: Hilt
- **Local Storage**: DataStore
- **Testing**: JUnit, Espresso

## Getting Started

### Prerequisites
- Android Studio Arctic Fox (2021.3.1) or newer
- JDK 11 or newer
- Android SDK 29+

### Building the Project
1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Run the app on an emulator or physical device

## Testing

The application includes both unit tests and UI tests:

- **Unit Tests**: Located in the `app/src/test` directory
- **UI Tests**: Located in the `app/src/androidTest` directory

To run the tests, use the following commands:

```bash
# Run unit tests
./gradlew test

# Run UI tests
./gradlew connectedAndroidTest
```

## Design Decisions

### UI/UX
- Material Design principles for consistent and modern UI
- Dark mode support for better user experience
- Responsive layout for both portrait and landscape orientations

### Architecture
- Clean Architecture principles for separation of concerns
- Repository pattern for data management
- ViewModel for UI state management
- Dependency Injection for better testability

### Security
- Secure storage of authentication tokens
- No hardcoded credentials
- Proper error handling for security-related issues

## Future Improvements

- Add support for GitHub OAuth authentication
- Implement pagination for repository and issue lists
- Add support for pull requests
- Enhance offline capabilities
- Add more advanced search filters
- Implement GitHub Actions integration

## License

This project is licensed under the MIT License - see the LICENSE file for details.
