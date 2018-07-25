package com.friendmanager.transfer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Standard response
 * @author vedang.rane
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FriendManagerResponse {

    private boolean success;
    private String error;
    private Integer count;
    private List<String> friends;
    private List<String> recipients;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

}
