package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

    SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(3, 5));
        } catch (Exception ex) {
        System.out.println(ex.getStackTrace());
        }
        finally {
            System.out.println("Task is done");
        }
        }
}

