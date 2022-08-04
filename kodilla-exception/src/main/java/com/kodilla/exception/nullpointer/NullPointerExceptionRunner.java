package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hey");
        } catch (MessageNotSentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Processing other logic!");
    }
}
