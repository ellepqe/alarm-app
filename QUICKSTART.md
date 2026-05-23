# Alarm App - Getting Started

## Quick Setup

### 1. Clone & Open
```bash
git clone https://github.com/ellepqe/alarm-app.git
cd alarm-app
```
Open in Android Studio (File → Open)

### 2. Build
```bash
./gradlew clean build
```

### 3. Run
```bash
./gradlew installDebug
```
Or press `Shift + F10` in Android Studio

## Key Files

- `build.gradle.kts` - Project dependencies
- `AndroidManifest.xml` - App configuration & permissions
- `MainActivity.kt` - Entry point with navigation
- `data/` - Database and repositories
- `ui/screens/` - UI Fragments
- `services/` - Background services

## Debugging

### View Logs
```bash
adb logcat
```

### Install Release Build
```bash
./gradlew installRelease
```

### Uninstall App
```bash
adb uninstall com.ellepqe.alarmapp
```

## Device Testing

### Connect Device
1. Enable USB Debugging on device
2. Connect via USB
3. Verify connection: `adb devices`
4. Build and run

### Emulator
Use Android Studio's AVD Manager to create and launch emulator

## Common Issues

**Build fails with gradle error**
- Clean: `./gradlew clean`
- Invalidate cache in Android Studio
- Update Gradle: `./gradlew wrapper --gradle-version latest`

**App crashes on startup**
- Check logcat for errors
- Verify all permissions are granted
- Ensure Android SDK 21+ is installed

**Database issues**
- Clear app data
- Reinstall app
- Check Room migration code

## Next Steps

1. Read the full [README.md](README.md)
2. Check [CONTRIBUTING.md](CONTRIBUTING.md) for contribution guidelines
3. Explore the codebase structure
4. Test on different Android versions

## Resources

- [Kotlin Docs](https://kotlinlang.org/docs/)
- [Android Dev Docs](https://developer.android.com/)
- [Jetpack Libraries](https://developer.android.com/jetpack)
- [Room Database](https://developer.android.com/training/data-storage/room)
