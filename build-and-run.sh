#!/bin/bash
mkdir -p out
javac -d out src/com/chatbot/*.java
java -cp out com.chatbot.Main
