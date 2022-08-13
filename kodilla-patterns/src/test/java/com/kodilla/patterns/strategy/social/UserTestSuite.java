package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        User john = new Millenials("John");
        User orlando = new YGeneration("Orlando");
        User david = new ZGeneration("David");

        String johnUsing = john.sharePost();
        System.out.println("John: " + johnUsing);
        String orlandoUsing = orlando.sharePost();
        System.out.println("Orlando: " + orlandoUsing);
        String davidUsing = david.sharePost();
        System.out.println("David: " + davidUsing);

        assertEquals("Sharing Twitter post..", johnUsing);
        assertEquals("Sharing Facebook post..", orlandoUsing);
        assertEquals("Sharing Snapchat post..", davidUsing);
    }

    @Test
    void testIndividualSharingStrategy() {
        User john = new Millenials("John");

        String johnUsing = john.sharePost();
        System.out.println("John: ");
        john.setSocialPublisher(new SnapchatPublisher());
        String johnNowIsUsing = john.sharePost();
        System.out.println("John now: " + johnNowIsUsing);

        assertEquals("Sharing Snapchat post..", johnNowIsUsing);

    }

}
