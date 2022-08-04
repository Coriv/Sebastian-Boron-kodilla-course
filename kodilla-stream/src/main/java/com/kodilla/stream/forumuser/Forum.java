package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> listOfForumUsers = new ArrayList<>();

    public Forum() {

        listOfForumUsers.add(new ForumUser(10001, "user1", 'M', LocalDate.of(1994, 3, 23), 11));
        listOfForumUsers.add(new ForumUser(10002, "user2", 'F', LocalDate.of(1944, 12, 13), 33));
        listOfForumUsers.add(new ForumUser(10003, "user3", 'F', LocalDate.of(1965, 3, 1), 0));
        listOfForumUsers.add(new ForumUser(10004, "user4", 'M', LocalDate.of(1992, 5, 5), 67));
        listOfForumUsers.add(new ForumUser(10005, "user5", 'F', LocalDate.of(1978, 7, 19), 0));
        listOfForumUsers.add(new ForumUser(10006, "user6", 'M', LocalDate.of(1955, 1, 27), 65));
        listOfForumUsers.add(new ForumUser(10007, "user7", 'M', LocalDate.of(1977, 2, 12), 32));
        listOfForumUsers.add(new ForumUser(10008, "user8", 'F', LocalDate.of(2003, 3, 5), 12));
    }

    public List<ForumUser> getListOfForumUsers() {
        return new ArrayList<>(listOfForumUsers);
    }
}
