package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests of calculateAdvStatistics method")
public class ForumStatisticsTestSuite {
    private static int testCounter = 1;
    @BeforeEach
    void beforeEveryTest(){
        System.out.println("Test #" + testCounter + " is starting");
        testCounter++;
    }
    @Mock
    Statistics statisticsMock;

    @DisplayName("Test without any post")
    @Test
    void testWithoutAnyPost(){
        ForumStatistics forumStatistics = new ForumStatistics();

        List<String> list = new ArrayList<>();
        list.add("user1");

        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(list);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        double result =forumStatistics.getAverageCommentsPerPost();
        double result2 = forumStatistics.getAveragePostPerUser();
        double result3 = forumStatistics.getAverageCommentsPerUser();
        Assertions.assertEquals(0, result);
        Assertions.assertEquals(0, result2);
        Assertions.assertEquals(0, result3);

    }

    @DisplayName("Test with 1000 posts")
    @Test
    void testWith1000Posts(){
        ForumStatistics forumStatistics = new ForumStatistics();

        List<String> list = new ArrayList<>();
        list.add("user1");

        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(list);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        double result =forumStatistics.getAverageCommentsPerPost();
        double result2 = forumStatistics.getAveragePostPerUser();
        double result3 = forumStatistics.getAverageCommentsPerUser();
        Assertions.assertEquals(0, result);
        Assertions.assertEquals(100, result2);
        Assertions.assertEquals(0, result3);
    }
    @DisplayName("Test with no comments")
    @Test
    void testWithNoComments(){
        ForumStatistics forumStatistics = new ForumStatistics();

        List<String> list = new ArrayList<>();
        list.add("user1");

        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(list);

        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(list);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        double result =forumStatistics.getAverageCommentsPerPost();
        double result2 = forumStatistics.getAveragePostPerUser();
        double result3 = forumStatistics.getAverageCommentsPerUser();
        Assertions.assertEquals(0, result);
        Assertions.assertEquals(0, result2);
        Assertions.assertEquals(0, result3);
    }

    @DisplayName("Test with higher amount of comments then posts")
    @Test
    void testOfHigherAmountCommentsThenPosts(){
        ForumStatistics forumStatistics = new ForumStatistics();

        List<String> list = new ArrayList<>();
        list.add("user1");

        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(40);
        when(statisticsMock.usersNames()).thenReturn(list);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        double result =forumStatistics.getAverageCommentsPerPost();
        double result2 = forumStatistics.getAveragePostPerUser();
        double result3 = forumStatistics.getAverageCommentsPerUser();
        Assertions.assertEquals(2.0, result);
        Assertions.assertEquals(20, result2);
        Assertions.assertEquals(40, result3);
    }

    @DisplayName("Test with higher amount of posts then comments")
    @Test
    void testOfHigherAmountPostsThenComments(){
        ForumStatistics forumStatistics = new ForumStatistics();

        List<String> list = new ArrayList<>();
        list.add("user1");
        list.add("user2");

        when(statisticsMock.postsCount()).thenReturn(40);
        when(statisticsMock.commentsCount()).thenReturn(20);
        when(statisticsMock.usersNames()).thenReturn(list);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        double result =forumStatistics.getAverageCommentsPerPost();
        double result2 = forumStatistics.getAveragePostPerUser();
        double result3 = forumStatistics.getAverageCommentsPerUser();

        Assertions.assertEquals(0.5, result);
        Assertions.assertEquals(20, result2);
        Assertions.assertEquals(10, result3);
    }

    @DisplayName("Test with 0 users")
    @Test
    void testWith0Users(){
        ForumStatistics forumStatistics = new ForumStatistics();

        List<String> list = new ArrayList<>();

        when(statisticsMock.postsCount()).thenReturn(40);
        when(statisticsMock.commentsCount()).thenReturn(20);
        when(statisticsMock.usersNames()).thenReturn(list);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        double result =forumStatistics.getAverageCommentsPerPost();
        double result2 = forumStatistics.getAveragePostPerUser();
        double result3 = forumStatistics.getAverageCommentsPerUser();

        Assertions.assertEquals(0.5, result);
        Assertions.assertEquals(40, result2);
        Assertions.assertEquals(20, result3);
    }

    @DisplayName("Test 100 users")
    @Test
    void testWith100Users(){
        ForumStatistics forumStatistics = new ForumStatistics();

        List<String> list = new ArrayList<>();
        for(int i=0; i<100; i++){
            list.add("user");
        }
        when(statisticsMock.postsCount()).thenReturn(40);
        when(statisticsMock.commentsCount()).thenReturn(20);
        when(statisticsMock.usersNames()).thenReturn(list);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        double result =forumStatistics.getAverageCommentsPerPost();
        double result2 = forumStatistics.getAveragePostPerUser();
        double result3 = forumStatistics.getAverageCommentsPerUser();

        Assertions.assertEquals(0.5, result);
        Assertions.assertEquals(0.4, result2);
        Assertions.assertEquals(0.2, result3);
    }

    @DisplayName("Test of showStatistics method")
    @Test
    void testOfShowStatistics(){

        List<String> list = new ArrayList<>();
        for(int i=0; i<100; i++){
            list.add("user");
        }
        when(statisticsMock.postsCount()).thenReturn(40);
        when(statisticsMock.commentsCount()).thenReturn(20);
        when(statisticsMock.usersNames()).thenReturn(list);
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
    }
}
