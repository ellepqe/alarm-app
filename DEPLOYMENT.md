# Deployment Guide

## Local Development Build

```bash
# Clone the repository
git clone https://github.com/ellepqe/alarm-app.git
cd alarm-app

# Build debug APK
./gradlew assembleDebug

# Install on connected device
adb install app/build/outputs/apk/debug/app-debug.apk
```

## GitHub Actions CI/CD

Every push to `main` automatically:
1. Builds Debug and Release APKs
2. Runs unit tests
3. Checks code quality with Lint
4. Uploads artifacts to Actions
5. Creates GitHub Release

## Release APK Distribution

### Option 1: GitHub Releases (Recommended)
1. APKs are automatically uploaded
2. Available at: [GitHub Releases](https://github.com/ellepqe/alarm-app/releases)
3. Download and install directly

### Option 2: Google Play Store
1. Create signed APK: `./gradlew assembleRelease`
2. Create Play Store developer account
3. Upload APK with screenshots and description
4. Submit for review

### Option 3: Direct Download
1. Go to [Actions tab](https://github.com/ellepqe/alarm-app/actions)
2. Select latest build
3. Download artifact

## Version Management

Update version in `app/build.gradle.kts`:

```kotlin
android {
    defaultConfig {
        versionCode = 2  // Increment for each release
        versionName = "1.0.1"  // Use semantic versioning
    }
}
```

Then push changes:
```bash
git add .
git commit -m "Release v1.0.1"
git push origin main
```

## Rollback

If an issue is found:
```bash
git revert <commit-hash>
git push origin main
```

## Monitoring

### Check Build Status
- [Actions Page](https://github.com/ellepqe/alarm-app/actions)
- Look for green ✅ (success) or red ❌ (failure)

### View Logs
- Click on failed workflow
- Scroll to see detailed error messages
- Fix issues and push again

## Production Checklist

- [ ] All tests passing
- [ ] Code review completed
- [ ] Version number updated
- [ ] Changelog updated
- [ ] APK signed with release keystore
- [ ] Release notes written
- [ ] No console errors or warnings

---

**Your app is ready for production! 🚀**
