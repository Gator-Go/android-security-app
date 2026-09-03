#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"   # ~/android
APP="$ROOT/android-security-app"
BUILDER="$ROOT/droid-builder"

cd "$BUILDER"
git pull

cd "$ROOT"
rm -rf "$APP/template"
cp -R "$BUILDER"/* "$APP"

cd "$APP"
git pull
rm -rf security
groovy DroidBuilder

cd Extender
groovy SecurityExtender

cd ../security
chmod +x gradlew
./gradlew assembleRelease