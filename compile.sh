#!/bin/bash

find src -iname "*.java" > classes.txt
javac -d . @classes.txt
rm classes.txt

find jphoto -iname "*.class" > classes.txt
echo "Main-Class: jphoto.Main" > Manifest.txt
jar cfm JPhoto.jar Manifest.txt @classes.txt res

rm Manifest.txt
rm classes.txt
rm -rf jphoto
