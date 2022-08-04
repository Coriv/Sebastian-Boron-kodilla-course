package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;
import org.springframework.test.context.NestedTestConfiguration;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.print("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Test for posts")
    class TestPosts {
        @Test
        public void testAddPost() {
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            forumUser.addPost("mrsmith", "Hello everyone, this is my first contribution here!");
            Assertions.assertEquals(1, forumUser.getPostQuantity());
        }

        @Test
        public void testGetPost() {
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);

            Assertions.assertEquals(thePost, retrievedPost);
        }

        @Test
        public void testRemovePostNotExisting() {
            ForumUser forumUser = new ForumUser("mr smith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone this is my first contribution here!", "mrsmith");

            boolean result = forumUser.removePost(thePost);

            Assertions.assertFalse(result);
        }

        @Test
        public void testRemovePost() {
            ForumUser forumUser = new ForumUser("mr smith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone this is my first contribution here!", "mrsmith");

            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            boolean result = forumUser.removePost(thePost);

            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for Comments")
    class TestComments {

        @Test
        public void testAddComment() {
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " + "this is my first contribution here!", "mrsmith");
            forumUser.addComment(thePost, "mrsmith", "Thank you for all good words!");

            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }


        @Test
        public void testGetComment() {
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            ForumComment retrivedComment = forumUser.getComment(0);

            Assertions.assertEquals(theComment, retrivedComment);
        }


        @Test
        public void testRemoveCommentNotExisting() {
            ForumUser forumUser = new ForumUser("mr smith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith", "Thank you for all good words!");

            boolean result = forumUser.removeComment(theComment);

            Assertions.assertFalse(result);
        }


        @Test
        public void testRemoveComment() {
            ForumUser forumUser = new ForumUser("mr smith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith", "Thank you for all good words!");

            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            boolean result = forumUser.removeComment(theComment);

            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}