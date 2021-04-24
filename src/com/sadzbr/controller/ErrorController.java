package com.sadzbr.controller;

import java.util.Stack;

public class ErrorController {
    private final Stack<String> errorStack = new Stack<>();
    private final static ErrorController INSTANCE = new ErrorController();

    private  ErrorController() {}

    public static ErrorController getInstance() {
        return INSTANCE;
    }

    public void addMessage(String message) {
        errorStack.push(message);
    }

    public String getLastMessage() {
        return errorStack.pop();
    }

    public boolean isEmpty() {
        return errorStack.isEmpty();
    }

    public String getAllMessages() {
        String message = "";
        while(!errorStack.isEmpty()) {
            message = message + errorStack.pop() + "\n";
        }
        if(!message.equals("")) {
            message = message.substring(0, message.length()-1);
        }
        return message;
    }
}
