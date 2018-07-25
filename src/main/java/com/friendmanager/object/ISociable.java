package com.friendmanager.object;

import java.util.Map;
import java.util.Set;

import com.friendmanager.exception.FriendManagerException;

public interface ISociable {

    void connect(String a, String b) throws FriendManagerException;
    Set<Friend> list(String a) throws FriendManagerException;
    Set<Friend> listCommon(String a, String b) throws FriendManagerException;
    void subscribe(String a, String b) throws FriendManagerException;
    void block(String a, String b) throws FriendManagerException;
    Set<Friend> listReceivers(String a, String text) throws FriendManagerException;
    
    Map<String, Friend> getFriendMap();
}
