package com.chatbot;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static final String HISTORY_FILE = "chat_history.txt";
    private static final Map<String, String> rules = new HashMap<>();

    static {
        rules.put("hello", "Hi there! How can I help you today?");
        rules.put("hi", "Hello! What's up?");
        rules.put("help", "I can chat, answer simple greetings and small talk. Type 'history' to see chat history, 'exit' to quit.");
        rules.put("bye", "Goodbye! Have a nice day.");
        rules.put("name", "I'm a Java rule-based chatbot.");
        rules.put("time", "I can tell you the current time if you ask.");
        rules.put("joke", "Why don't scientists trust atoms? Because they make up everything!");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Java Chatbot (type 'help' for commands)");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("You: ");
                String input = sc.nextLine().trim();
                if (input.isEmpty()) continue;

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Bot: Bye!");
                    break;
                }
                if (input.equalsIgnoreCase("help")) {
                    System.out.println("Bot: " + rules.get("help"));
                    continue;
                }

                String response = respond(input);
                System.out.println("Bot: " + response + "\n");
            }
        }
    }

    private static String respond(String input) {
        String lower = input.toLowerCase();
        for (String key : rules.keySet()) {
            if (lower.contains(key)) {
                if (key.equals("time")) {
                    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now());
                }
                return rules.get(key);
            }
        }
        return "I'm still learning! Try saying hello or help.";
    }
}
