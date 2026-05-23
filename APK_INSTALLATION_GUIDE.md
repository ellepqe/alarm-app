# Build APK Installation Guide

## How to Download and Install Your APK

### Step 1: Get the APK from GitHub

1. Go to your repository: [https://github.com/ellepqe/alarm-app](https://github.com/ellepqe/alarm-app)
2. Click on **Actions** tab at the top
3. Click on the latest successful build (green checkmark)
4. Scroll down to **Artifacts** section
5. Download either:
   - **alarm-app-debug** - For testing
   - **alarm-app-release** - For regular use (recommended)

### Step 2: Transfer APK to Your Phone

**Option A: Direct Download (Easiest)**
- Download the APK directly on your phone browser
- Open the downloaded APK file
- Follow the installation prompts

**Option B: Using Email**
- Download APK on PC
- Email it to yourself
- Open email on phone
- Tap the APK attachment
- Install

**Option C: Using Cloud Storage**
- Upload APK to Google Drive or Dropbox
- Open on phone
- Download and install

### Step 3: Install the APK

1. Open the APK file on your phone
2. You may see a warning: "Install apps from unknown sources"
3. Tap **Install**
4. Wait for installation to complete
5. Tap **Open** to launch the app

### Step 4: Grant Permissions

When you first open the app, it will ask for:
- Calendar access (for alarms)
- Notification permissions
- Storage access (for export)

Tap **Allow** for each permission.

---

## What's Included in Each Build

### Debug APK (alarm-app-debug.apk)
- Full functionality
- Easier to debug if issues occur
- Slightly larger file size
- Good for testing new features

### Release APK (alarm-app-release.apk)
- Optimized and compressed
- Ready for daily use
- Smaller file size
- Better performance
- **Recommended for regular use**

---

## Automatic Builds

Every time code is pushed to the `main` branch:
✅ GitHub automatically builds new APKs
✅ New releases are created
✅ You can download the latest version

---

## Troubleshooting

### "Unknown app" warning
This is normal for side-loaded apps. Tap **Install anyway**.

### Installation fails
- Check if you have enough storage space
- Uninstall any previous version first
- Try the debug APK instead

### App crashes on startup
- Check Android version (needs 5.0+)
- Clear app cache and data
- Reinstall the app

### Where to find installed app
- Check your phone's app drawer
- Search for "Alarm App"
- Create a shortcut on home screen

---

## Updates

Whenever you make changes to the code:
1. Push to GitHub main branch
2. GitHub Actions automatically builds new APKs
3. Download the latest version from Actions/Releases
4. Install the new APK (replaces the old one)

---

**Your app is ready to use! 🚀📱**
