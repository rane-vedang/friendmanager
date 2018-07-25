package com.friendmanager.object;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.friendmanager.exception.FriendManagerException;

public class FriendManagerTest {

    @Test
    public void connect_success() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String email2 = "test2@test.com";

        // act
        fm.connect(email1, email2);

        // assert
        Assert.assertTrue(fm.list(email1).contains(new Friend(email2)));
    }

    @Test(expected = FriendManagerException.class)
    public void connect_fail() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String email2 = "test2@test.com";
        String email3 = "test3@test.com";
        fm.connect(email1, email2);
        fm.block(email1, email3);

        // act
        fm.connect(email1, email3);
    }

    @Test
    public void list_success() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String email2 = "test2@test.com";
        fm.connect(email1, email2);

        // act
        Set<Friend> result = fm.list(email1);

        // assert
        Assert.assertEquals(1, result.size());
    }

    @Test(expected = FriendManagerException.class)
    public void list_fail() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";

        // act
        fm.list(email1);
    }

    @Test
    public void listCommon_success() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String email2 = "test2@test.com";
        String email3 = "test3@test.com";
        fm.connect(email1, email2);
        fm.connect(email2, email3);

        // act
        Set<Friend> result = fm.listCommon(email1, email3);

        // assert
        Assert.assertEquals(1, result.size());
    }

    @Test(expected = FriendManagerException.class)
    public void listCommon_fail() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String email2 = "test2@test.com";

        // act
        fm.listCommon(email1, email2);
    }

    @Test
    public void subscribe_success() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String email2 = "test2@test.com";
        fm.connect(email1, email2);
        
        // act
        fm.subscribe(email1, email2);

        // assert
        Assert.assertTrue(fm.getFriendMap().get(email1).getSubscriberList().size() == 1);
    }

    @Test(expected = FriendManagerException.class)
    public void subscribe_fail() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String email2 = "test2@test.com";
        
        // act
        fm.subscribe(email1, email2);
    }
    
    @Test
    public void block_success() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String email2 = "test2@test.com";
        fm.connect(email1, email2);
        
        // act
        fm.block(email1, email2);

        // assert
        Assert.assertTrue(fm.getFriendMap().get(email1).getBlockList().size() == 1);
    }

    @Test(expected = FriendManagerException.class)
    public void block_fail() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String email2 = "test2@test.com";
        
        // act
        fm.block(email1, email2);
    }
    
    
    @Test
    public void listReceiver_success_friend() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String text = "HELLO";
        String email2 = "test2@test.com";
        fm.connect(email1, email2);

        // act
        Set<Friend> result = fm.listReceivers(email1, text);

        // assert
        Assert.assertEquals(1, result.size());
    }
    
    @Test
    public void listReceiver_success_subscribed() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String text = "HELLO";
        String email2 = "test2@test.com";
        fm.connect(email1, email2);
        fm.subscribe(email2, email1);

        // act
        Set<Friend> result = fm.listReceivers(email1, text);

        // assert
        Assert.assertEquals(1, result.size());
    }
    
    @Test
    public void listReceiver_success_text() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String text = "HELLO test3@test.com";
        String email2 = "test2@test.com";
        String email3 = "test3@test.com";
        fm.connect(email1, email2);
        fm.connect(email2, email3);
        // act
        Set<Friend> result = fm.listReceivers(email1, text);

        // assert
        Assert.assertEquals(2, result.size());
    }

    @Test(expected = FriendManagerException.class)
    public void listReceiver_fail() throws FriendManagerException {
        // assert
        ISociable fm = new FriendManager();
        String email1 = "test1@test.com";
        String text = "Hello test2@test.com";

        // act
        fm.listReceivers(email1, text);
    }
    
    

}
