package com.friendmanager.object;

import java.util.Map;
import java.util.Set;

import com.friendmanager.exception.FriendManagerException;

public interface ISociable {

    /**
     * connects 2 friends
     * @param a
     * @param b
     * @throws FriendManagerException if blocked
     */
    void connect(String a, String b) throws FriendManagerException;
    
    /**
     * lists all friends of friend with email a
     * @param a
     * @return
     * @throws FriendManagerException
     */
    Set<Friend> list(String a) throws FriendManagerException;
    
    /**
     * lists common friends of friend with email a and b
     * @param a
     * @param b
     * @return
     * @throws FriendManagerException
     */
    Set<Friend> listCommon(String a, String b) throws FriendManagerException;
    
    /**
     * adds friend b to subscribers list of friend a
     * @param a
     * @param b
     * @throws FriendManagerException
     */
    void subscribe(String a, String b) throws FriendManagerException;
    /**
     * adds friend b to block list of friend a
     * @param a
     * @param b
     * @throws FriendManagerException
     */
    void block(String a, String b) throws FriendManagerException;
    /**
     * lists receivers for friend a
     * @param a
     * @param text
     * @return
     * @throws FriendManagerException
     */
    Set<Friend> listReceivers(String a, String text) throws FriendManagerException;
    
    Map<String, Friend> getFriendMap();
}
