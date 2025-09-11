@echo off
setlocal enabledelayedexpansion

REM Change this if your App is in a package, e.g. com.example.expenses.App
set MAIN_CLASS=App

REM Clean & prepare output
if exist out rmdir /s /q out
if exist MANIFEST.MF del /q MANIFEST.MF
if exist ExpenseTracker.jar del /q ExpenseTracker.jar
mkdir out

echo [1/3] Compiling sources -> out\
javac -encoding UTF-8 -d out src\*.java || goto :error

echo [2/3] Writing MANIFEST.MF
echo Main-Class: %MAIN_CLASS%> MANIFEST.MF

echo [3/3] Packaging ExpenseTracker.jar
jar cfm ExpenseTracker.jar MANIFEST.MF -C out . || goto :error

echo Done. Run with: java -jar ExpenseTracker.jar
goto :eof

:error
echo Build failed. Make sure JDK 17+ is installed and on PATH.
exit /b 1
