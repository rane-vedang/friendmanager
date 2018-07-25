package com.friendmanager.object;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.friendmanager.exception.FriendManagerException;

@Component
public class FriendManager implements ISociable {

    protected Map<String, Friend> friendMap;

    public FriendManager() {
        this.friendMap = new HashMap<>();
    }

    @Override
    public void connect(String a, String b) throws FriendManagerException {
        friendMap.putIfAbsent(a, new Friend(a));
        friendMap.putIfAbsent(b, new Friend(b));
        Friend friend1 = friendMap.get(a);
        Friend friend2 = friendMap.get(b);
        if (friend1.getBlockList().contains(friend2) || friend2.getBlockList().contains(friend1))
            throw new FriendManagerException(String.format("one of the friend has blocked the other"));
        friend1.addFriend(friend2);
        friend2.addFriend(friend1);
    }

    @Override
    public Set<Friend> list(String a) throws FriendManagerException {
        Friend friend = friendMap.get(a);
        if (friend == null)
            throw new FriendManagerException(String.format("friend with email %s does not exist", a));
        return friend.getFriendList();
    }

    @Override
    public Set<Friend> listCommon(String a, String b) throws FriendManagerException {
        Friend friend1 = friendMap.get(a);
        if (friend1 == null)
            throw new FriendManagerException(String.format("friend with email %s does not exist", a));
        Friend friend2 = friendMap.get(b);
        if (friend2 == null)
            throw new FriendManagerException(String.format("friend with email %s does not exist", b));

        Set<Friend> commonFriends = new HashSet<>();

        for (Friend f : friend1.getFriendList()) {
            if (friend2.getFriendList().contains(f)) {
                commonFriends.add(f);
            }
        }
        return commonFriends;
    }

    @Override
    public void subscribe(String a, String b) throws FriendManagerException {
        Friend friend1 = friendMap.get(a);
        if (friend1 == null)
            throw new FriendManagerException(String.format("friend with email %s does not exist", a));
        Friend friend2 = friendMap.containsKey(b) ? friendMap.get(a) : new Friend(b);
        friend1.subscribeFriend(friend2);
    }

    @Override
    public void block(String a, String b) throws FriendManagerException {
        Friend friend1 = friendMap.get(a);
        if (friend1 == null)
            throw new FriendManagerException(String.format("friend with email %s does not exist", a));
        Friend friend2 = friendMap.containsKey(b) ? friendMap.get(a) : new Friend(b);
        friend1.blockFriend(friend2);
    }

    @Override
    public Set<Friend> listReceivers(String a, String text) throws FriendManagerException {
        Friend sender = friendMap.get(a);
        if (sender == null)
            throw new FriendManagerException(String.format("friend with email %s does not exist", a));
        Set<Friend> receivers = new HashSet<>();
        for (Entry<String, Friend> entry : friendMap.entrySet()) {
            Friend friend = entry.getValue();
            // check if he is not blocked
            if (!friend.getBlockList().contains(sender)) {
                if (friend.getFriendList().contains(sender) || friend.getSubscriberList().contains(sender)
                        || text.contains(friend.getEmail())) {
                    receivers.add(friend);
                }
            }

        }
        return receivers;
    }

    @Override
    public Map<String, Friend> getFriendMap() {
        return friendMap;
    }

    public void setFriendMap(Map<String, Friend> friendMap) {
        this.friendMap = friendMap;
    }
    
    

}
