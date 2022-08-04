package com.kodilla.stream.forumuser;

import java.time.LocalDate;

final public class ForumUser {

    private final int userID;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int postsCounter;

    public ForumUser(int userID, String userName, char sex, LocalDate dateOfBirth, int postsCounter) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.postsCounter = postsCounter;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsCounter() {
        return postsCounter;
    }

    @Override
    public String toString() {
        return "ForumUser: " +
                "userName= " + userName;
    }
}
