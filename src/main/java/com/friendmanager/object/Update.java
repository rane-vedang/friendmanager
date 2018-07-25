package com.friendmanager.object;

public class Update {

    private Friend sender;
    private String text;

    public Update(Friend sender, String text) {
        super();
        this.sender = sender;
        this.text = text;
    }

    public Friend getSender() {
        return sender;
    }

    public void setSender(Friend sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
