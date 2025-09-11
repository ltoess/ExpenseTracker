#!/usr/bin/env bash
set -euo pipefail

MAIN_CLASS="App"

# Clean & prepare output
rm -rf out MANIFEST.MF ExpenseTracker.jar 2>/dev/null || true
mkdir -p out

# Compile
echo "[1/3] Compiling sources → out/"
javac -encoding UTF-8 -d out src/*.java

# Manifest
echo "[2/3] Writing MANIFEST.MF"
printf "Main-Class: %s\n" "$MAIN_CLASS" > MANIFEST.MF

# Jar
echo "[3/3] Packaging ExpenseTracker.jar"
jar cfm ExpenseTracker.jar MANIFEST.MF -C out .

echo "Done. Run with: java -jar ExpenseTracker.jar"
