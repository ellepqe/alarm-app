# Alarm App - Advanced Android Alarm Management

A lightweight, feature-rich Android alarm application built with **Kotlin** and **Jetpack** libraries. Manage alarms, track sun/moon times, create notes, and customize language settings - all offline!

## Features

### 🔔 Alarms
- Create, edit, and delete custom alarms
- Categorize alarms for better organization
- Enable/disable alarms with smooth toggles
- Set custom alarm sounds and vibration
- Link alarms together for chaining
- Mute other alarms when one is active

### 🌅 Sun & Moon Times
- Track sunrise and sunset times
- Monitor moon phases (Full, Half, New)
- Set notifications for celestial events
- Customizable text color and size
- Automatic time calculations

### 📝 Notes
- Create quick notes linked to alarms
- Customize text color and size
- Edit and delete notes easily
- Search and filter functionality

### ⚙️ Settings
- Multi-language support with custom values
- Export data as JSON or Text
- Restore default settings
- Backup and recovery features

## Tech Stack

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **Database**: Room Persistence Library
- **UI Framework**: Android Jetpack Components
- **Asynchronous**: Coroutines & Flow
- **Build System**: Gradle

## Project Structure

```
app/src/main/kotlin/com/ellepqe/alarmapp/
├── MainActivity.kt                 # Main activity with navigation
├── data/
│   ├── model/                      # Data models (Alarm, Note, Category, etc.)
│   ├── dao/                        # Database DAOs
│   ├── database/                   # Room database setup
│   └── repository/                 # Data access repositories
├── ui/
│   ├── screens/                    # Fragment screens (Alarms, Notes, Settings, Sun/Moon)
│   ├── viewmodel/                  # ViewModels for state management
│   └── adapters/                   # RecyclerView adapters
├── services/
│   ├── AlarmService.kt             # Alarm triggering service
│   └── SunMoonNotificationService.kt # Notification service
├── receivers/
│   ├── AlarmReceiver.kt            # Alarm broadcast receiver
│   └── SunMoonReceiver.kt          # Sun/Moon event receiver
└── utils/
    ├── AlarmScheduler.kt           # System alarm scheduling
    ├── TimeUtils.kt                # Time utilities
    ├── ExportManager.kt            # Data export functionality
    ├── NotificationHelper.kt        # Notification creation
    └── PreferencesManager.kt        # Shared preferences management
```

## Installation

### Prerequisites
- Android Studio Giraffe or newer
- Android SDK 21 or higher
- Kotlin 1.9+
- Gradle 8.0+

### Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ellepqe/alarm-app.git
   cd alarm-app
   ```

2. **Open in Android Studio**:
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory

3. **Build the project**:
   ```bash
   ./gradlew build
   ```

4. **Run on emulator or device**:
   ```bash
   ./gradlew installDebug
   ```
   Or use Android Studio's Run button (Shift + F10)

## Dependencies

### Core Android
- `androidx.core:core-ktx:1.10.1`
- `androidx.appcompat:appcompat:1.6.1`
- `com.google.android.material:material:1.9.0`
- `androidx.constraintlayout:constraintlayout:2.1.4`

### Database
- `androidx.room:room-runtime:2.5.2`
- `androidx.room:room-ktx:2.5.2`

### Lifecycle & Coroutines
- `androidx.lifecycle:lifecycle-runtime-ktx:2.6.1`
- `androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1`

### Serialization
- `com.google.code.gson:gson:2.10.1`

### Testing
- `junit:junit:4.13.2`
- `androidx.test.ext:junit:1.1.5`
- `androidx.test.espresso:espresso-core:3.5.1`

## Usage

### Adding an Alarm
1. Navigate to the **Alarms** tab
2. Click **Add Alarm**
3. Set time, title, sound, and category
4. Enable vibration if needed
5. Save

### Managing Sun/Moon Times
1. Go to the **Sun/Moon** tab
2. Click on sunrise, sunset, or moon phase buttons
3. Set the desired time
4. Save and receive notifications

### Creating Notes
1. Open the **Notes** tab
2. Click **Add Note**
3. Enter title and content
4. Customize text color and size
5. Link to an alarm (optional)
6. Save

### Exporting Data
1. Open **Settings**
2. Click **Export JSON** or **Export Text**
3. Data is saved to device storage
4. Restore from Settings anytime

## Architecture Details

### MVVM Pattern
- **Model**: Room database entities and repositories
- **View**: Fragments and Adapters (UI)
- **ViewModel**: Manages UI state and business logic

### Data Flow
```
UI (Fragment) → ViewModel → Repository → Room Database
     ↓
  (Observers via LiveData & Flow)
```

### Coroutines
All database operations run on background threads using Kotlin Coroutines:
```kotlin
viewModelScope.launch {
    val alarm = repository.getAlarmById(id)
    // Update UI on main thread
}
```

## Permissions

The app requires the following permissions:
- `INTERNET` - General connectivity
- `READ_EXTERNAL_STORAGE` - Import/export data
- `WRITE_EXTERNAL_STORAGE` - Save backups
- `SCHEDULE_EXACT_ALARM` - Set precise alarms
- `VIBRATE` - Vibration feedback
- `RECEIVE_BOOT_COMPLETED` - Resume alarms on reboot
- `POST_NOTIFICATIONS` - Show notifications

## Building & Testing

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

### Run Tests
```bash
./gradlew test
```

### Run Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

## Troubleshooting

### Alarms not triggering
- Check if app has alarm permission
- Verify system time is correct
- Ensure app is not in restricted battery mode

### Database errors
- Clear app data from Settings
- Uninstall and reinstall the app
- Check logcat for detailed errors

### Notifications not showing
- Enable notifications in app settings
- Check system notification settings
- Verify notification channel is created

## Contributing

We welcome contributions! To contribute:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For issues, feature requests, or questions:
- Open an issue on GitHub
- Contact: ellepqe@github.com

## Roadmap

- [ ] Widget support
- [ ] Sleep timer
- [ ] Advanced analytics
- [ ] Cloud backup sync
- [ ] Repeat patterns
- [ ] Custom alarm tones
- [ ] Dark mode optimization
- [ ] Wear OS integration

## Changelog

### v1.0 (2026-05-21)
- Initial release
- Core alarm functionality
- Sun/Moon time tracking
- Notes feature
- Language settings
- Data export/import

---

**Made with ❤️ by ellepqe**
