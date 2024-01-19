dir /s /b "*.java" > classes.txt
javac -d . @classes.txt
del /f classes.txt

setlocal disableDelayedExpansion
for /f "delims=" %%A in ('forfiles /s /m *.class /c "cmd /c echo @relpath"') do (
  set "file=%%~A"
  setlocal enableDelayedExpansion
  echo !file:~2! >> classes.txt
  endlocal
)
echo Main-Class: jphoto.Main > Manifest.txt
jar cfm JPhoto.jar Manifest.txt @classes.txt res

del /f Manifest.txt
del /f classes.txt
rmdir /s /q jphoto