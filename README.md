# SQLDelightKMP

**SQLDelightKMP** is a Kotlin Multiplatform (KMP) learning and practice project. Its primary focus is to demonstrate and explore the integration of modern KMP libraries, specifically **Koin** for dependency injection, **SQLDelight** for database management, and **Navigation3** for type-safe navigation in Compose Multiplatform.

This project targets **Android** and **iOS**.

## 🚀 Tech Stack

- **[Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)**: Shared business logic and UI.
- **[Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)**: Declarative UI framework sharing code across Android and iOS.
- **[Koin](https://insert-koin.io/)** (`v4.1.1`): A pragmatic lightweight dependency injection framework for Kotlin.
- **[SQLDelight](https://cashapp.github.io/sqldelight/)** (`v2.2.1`): Generates typesafe Kotlin APIs from SQL statements.
- **[Navigation3](https://developer.android.com/guide/navigation)** (`v1.0.0-alpha06`): The latest iteration of navigation for Compose, exploring type-safe and flexible navigation patterns in a multiplatform environment.
- **[Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)**: For JSON serialization/deserialization.

## 📂 Project Structure

- **`/composeApp`**: The core shared module containing all common code, UI (Compose), and platform-specific implementations (Android/iOS).
  - `commonMain`: Shared code for all platforms.
  - `androidMain`: Android-specific implementations.
  - `iosMain`: iOS-specific implementations.
- **`/iosApp`**: The iOS application entry point (Xcode project).

## 🛠️ Setup & Running

### Prerequisites
- **JDK 17+**
- **Android Studio** (latest recommended) with the Kotlin Multiplatform Mobile plugin.
- **Xcode** (for iOS development).
- **CocoaPods** (optional, but often used in KMP iOS setups, though this project uses standard framework linking).

### Android
To build and run the Android application:
1. Open the project in Android Studio.
2. Select the `composeApp` run configuration.
3. Run on an emulator or connected device.

Or via terminal:
```bash
./gradlew :composeApp:installDebug
```

### iOS
To build and run the iOS application:
1. Open the `iosApp/iosApp.xcodeproj` in Xcode.
2. Ensure the build target is set to your simulator or device.
3. Run the app (Cmd+R).

Or via terminal (to build the framework):
```bash
./gradlew :composeApp:embedAndSignAppleFrameworkForXcode
```
*(Note: Running the iOS app typically requires opening the Xcode project.)*

## 📚 Learning Goals
This project serves as a reference for:
- Configuring **SQLDelight** in a KMP environment (defining schemas, generating queries, platform drivers).
- Setting up **Koin** for dependency injection across shared and platform-specific modules.
- Implementing **Navigation3** to handle screen transitions and deep linking in a Compose Multiplatform app.

---
*Created for learning purposes.*
# KMP-CMP-SQLDelight
