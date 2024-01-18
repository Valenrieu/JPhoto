dir /s /b "*.java" > classes.txt
javac -d bin @classes.txt
del /f classes.txt

dir /s /b "*.class" > classes.txt
echo "Main-Class: jphoto.Main" > Manifest.txt
jar cfm JPhoto.jar Manifest.txt @classes.txt res

del /f Manifest.txt
del /f classes.txt
rmdir /s /q jphoto