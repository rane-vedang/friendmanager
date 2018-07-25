package com.friendmanager.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.friendmanager.exception.FriendManagerException;
import com.friendmanager.object.Friend;
import com.friendmanager.object.FriendManager;
import com.friendmanager.transfer.FriendManagerRequest;
import com.friendmanager.transfer.FriendManagerResponse;

@Controller
public class FriendManagerController {

    @Autowired
    FriendManager friendManager;

    @PostMapping(path = "/connect", consumes = "application/json", produces = "application/json")
    public @ResponseBody FriendManagerResponse connect(@RequestBody FriendManagerRequest request) {
        FriendManagerResponse response = new FriendManagerResponse();
        String a = request.getFriends().get(0);
        String b = request.getFriends().get(1);

        try {
            friendManager.connect(a, b);
            response.setSuccess(true);

        } catch (FriendManagerException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());

        }

        return response;

    }

    @PostMapping(path = "/list", consumes = "application/json", produces = "application/json")
    public @ResponseBody FriendManagerResponse list(@RequestBody FriendManagerRequest request) {
        FriendManagerResponse response = new FriendManagerResponse();
        String a = request.getEmail();
        try {
            Set<Friend> friends = friendManager.list(a);
            response.setSuccess(true);
            response.setFriends(friends.stream().map(f -> f.getEmail()).collect(Collectors.toList()));
            response.setCount(friends.size());

        } catch (FriendManagerException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());

        }

        return response;

    }

    @PostMapping(path = "/common", consumes = "application/json", produces = "application/json")
    public @ResponseBody FriendManagerResponse listCommon(@RequestBody FriendManagerRequest request) {
        FriendManagerResponse response = new FriendManagerResponse();
        String a = request.getFriends().get(0);
        String b = request.getFriends().get(1);

        try {
            Set<Friend> friends = friendManager.listCommon(a, b);
            response.setSuccess(true);
            response.setFriends(friends.stream().map(f -> f.getEmail()).collect(Collectors.toList()));
            response.setCount(friends.size());

        } catch (FriendManagerException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());

        }

        return response;

    }

    @PostMapping(path = "/subscribe", consumes = "application/json", produces = "application/json")
    public @ResponseBody FriendManagerResponse subscribe(@RequestBody FriendManagerRequest request) {
        FriendManagerResponse response = new FriendManagerResponse();
        String a = request.getRequestor();
        String b = request.getTarget();

        try {
            friendManager.subscribe(a, b);
            response.setSuccess(true);

        } catch (FriendManagerException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());

        }

        return response;

    }

    @PostMapping(path = "/block", consumes = "application/json", produces = "application/json")
    public @ResponseBody FriendManagerResponse block(@RequestBody FriendManagerRequest request) {
        FriendManagerResponse response = new FriendManagerResponse();
        String a = request.getRequestor();
        String b = request.getTarget();

        try {
            friendManager.block(a, b);
            response.setSuccess(true);
        } catch (FriendManagerException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());

        }

        return response;

    }

    @PostMapping(path = "/receivers", consumes = "application/json", produces = "application/json")
    public @ResponseBody FriendManagerResponse listReceivers(@RequestBody FriendManagerRequest request) {
        FriendManagerResponse response = new FriendManagerResponse();
        String a = request.getSender();
        String text = request.getText();
        try {
            Set<Friend> recipients = friendManager.listReceivers(a, text);
            response.setSuccess(true);
            response.setRecipients(recipients.stream().map(f -> f.getEmail()).collect(Collectors.toList()));
        } catch (FriendManagerException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());

        }

        return response;

    }

}
