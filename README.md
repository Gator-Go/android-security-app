# Android Security App

Prototype. Factory-generated Security app from droid-builder.

Catalog: https://sw-builder.com/appstore/android/apps/android-security-app.html

Builder: https://github.com/Gator-Go/droid-builder

## Build (Unix)

Prerequisites: Git, Groovy, JDK, Android SDK.

Expected sibling directories:

    ~/android/droid-builder
    ~/android/android-security-app

```bash
cd ~/android/android-security-app
git pull
./android-security-build.sh
```
## Layout:
```text
android-security-app/
├── android-security-build.sh
├── Extender/
│   ├── SecurityExtender.groovy
│   ├── logo.png
│   ├── ldpi-logo.png
│   ├── mdpi-logo.png
│   ├── hdpi-logo.png
│   ├── xhdpi-logo.png
│   └── xxhdpi-logo.png
└── options/
    ├── APP_ENUMS.xml
    ├── APP_NAMES.xml
    └── APP_TABLES.xml
```
## Note:

The template/ and build/ dirs appear after a build. They come from
droid-builder.

DroidBuilder.groovy is copied in from droid-builder at build time.

SecurityExtender.groovy performs functions unique to the security app such
as deploying the security logo images.

The security/ dir appears after a build and is the build output where the
new app is created.
