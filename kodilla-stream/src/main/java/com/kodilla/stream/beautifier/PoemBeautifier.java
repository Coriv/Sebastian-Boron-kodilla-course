package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    private static int decorateCounter =1;
    public void beautify(String stringToDecorate, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(stringToDecorate);
        System.out.println("Decorating #" + decorateCounter +"\nBefore decorate: " + stringToDecorate + "\nResult of decorate: " + result);
        decorateCounter++;
    }
}
