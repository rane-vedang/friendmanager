package com.friendmanager.object;

import java.util.HashSet;
import java.util.Set;

public class Friend {

    private String email;
    private Set<Friend> friendList;
    private Set<Friend> blockList;
    private Set<Friend> subscriberList;

    public Friend(String email) {
        super();
        this.email = email;
        friendList = new HashSet<Friend>();
        blockList = new HashSet<Friend>();
        subscriberList = new HashSet<Friend>();
    }

    public void addFriend(Friend f) {
        friendList.add(f);
    }

    public void blockFriend(Friend f) {
        blockList.add(f);
    }

    public void subscribeFriend(Friend f) {
        subscriberList.add(f);
    }

    public void unfriend(Friend f) {
        friendList.remove(f);
    }

    public void unblockFriend(Friend f) {
        blockList.remove(f);
    }

    public void unsubscribeFriend(Friend f) {
        subscriberList.remove(f);
    }

    
    //getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(Set<Friend> friendList) {
        this.friendList = friendList;
    }

    public Set<Friend> getBlockList() {
        return blockList;
    }

    public void setBlockList(Set<Friend> blockList) {
        this.blockList = blockList;
    }

    public Set<Friend> getSubscriberList() {
        return subscriberList;
    }

    public void setSubscriberList(Set<Friend> subscriberList) {
        this.subscriberList = subscriberList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Friend other = (Friend) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    
}
