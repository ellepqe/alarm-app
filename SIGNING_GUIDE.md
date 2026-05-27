# Signing Configuration

To sign your Release APK for production use, follow these steps:

## Generate a Keystore File

### Using Android Studio (Easiest):
1. Open Android Studio
2. Go to **Build → Generate Signed Bundle / APK**
3. Select **APK**
4. Click **Create new...**
5. Fill in the details:
   - **Key store path**: `alarm-app.jks` (in project root)
   - **Password**: Create a strong password
   - **Key alias**: `alarm-key`
   - **Key password**: Same as keystore or different
   - **Validity (years)**: 25+
   - **Certificate fields**: Fill in your info
6. Click **OK** and then **Finish**

### Using Command Line:
```bash
keytool -genkey -v -keystore alarm-app.jks -keyalg RSA -keysize 2048 -validity 10000 -alias alarm-key
```

## Store Keystore Safely

⚠️ **IMPORTANT**: Keep `alarm-app.jks` file safe!
- Store it in a secure location
- Add to `.gitignore` (don't commit to GitHub)
- Backup copy somewhere safe
- **Never share the keystore file**

## Create signing.properties

1. Create a file named `signing.properties` in the project root
2. Add the following content:
```properties
STORE_FILE=alarm-app.jks
STORE_PASSWORD=your_keystore_password
KEY_ALIAS=alarm-key
KEY_PASSWORD=your_key_password
```

3. Add to `.gitignore`:
```
signing.properties
alarm-app.jks
```

## Configure Build Gradle

Add this to `app/build.gradle.kts`:

```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("../alarm-app.jks")
            storePassword = "your_keystore_password"
            keyAlias = "alarm-key"
            keyPassword = "your_key_password"
        }
    }
    
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
```

## Build Signed Release APK

```bash
./gradlew assembleRelease
```

The signed APK will be at:
```
app/build/outputs/apk/release/app-release.apk
```

## Publish to Play Store

1. Create Google Play Developer account ($25 one-time fee)
2. Create new app
3. Upload the signed APK
4. Fill in app details and screenshots
5. Submit for review

---

**Your Release APK is now ready for production! 🎉**
