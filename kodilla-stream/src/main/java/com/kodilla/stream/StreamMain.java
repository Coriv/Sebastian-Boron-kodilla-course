package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {


        Forum forum = new Forum();


        Map<Integer,ForumUser> mapOfForumUsers = forum.getListOfForumUsers().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getDateOfBirth().getYear() <2002)
                .filter(user -> user.getPostsCounter() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));


        System.out.println("Size of map:" + mapOfForumUsers.size());
        mapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}