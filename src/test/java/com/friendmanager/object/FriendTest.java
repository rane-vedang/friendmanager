package com.friendmanager.object;

import org.junit.Assert;
import org.junit.Test;

public class FriendTest {

    @Test
    public void addFriend() {
        // arrange
        Friend friend = new Friend("test@test.com");
        Friend friend2 = new Friend("test2@test.com");

        // act
        friend.addFriend(friend2);

        // assert
        Assert.assertTrue(friend.getFriendList().contains(friend2));
    }

    @Test
    public void blockFriend() {
        // arrange
        Friend friend = new Friend("test@test.com");
        Friend friend2 = new Friend("test2@test.com");

        // act
        friend.blockFriend(friend2);
        // assert
        Assert.assertTrue(friend.getBlockList().contains(friend2));
    }

    @Test
    public void subscribeFriend() {
        // arrange
        Friend friend = new Friend("test@test.com");
        Friend friend2 = new Friend("test2@test.com");

        // act
        friend.subscribeFriend(friend2);
        // assert
        Assert.assertTrue(friend.getSubscriberList().contains(friend2));
    }

    @Test
    public void unfriend() {
        // arrange
        Friend friend = new Friend("test@test.com");
        Friend friend2 = new Friend("test2@test.com");
        friend.addFriend(friend2);

        // act
        friend.unfriend(friend2);
        // assert
        Assert.assertFalse(friend.getFriendList().contains(friend2));
    }

    @Test
    public void unblockFriend() {
        // arrange
        Friend friend = new Friend("test@test.com");
        Friend friend2 = new Friend("test2@test.com");
        friend.addFriend(friend2);

        // act
        friend.unblockFriend(friend2);
        // assert
        Assert.assertFalse(friend.getBlockList().contains(friend2));
    }

    @Test
    public void unsubscribeFriend() {
        // arrange
        Friend friend = new Friend("test@test.com");
        Friend friend2 = new Friend("test2@test.com");
        friend.addFriend(friend2);

        // act
        friend.unsubscribeFriend(friend2);
        // assert
        Assert.assertFalse(friend.getSubscriberList().contains(friend2));
    }
}
