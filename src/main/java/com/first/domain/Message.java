package com.first.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by yujuekong on 2017/6/5.
 */
@Entity
@Table(name = "MESSAGE_PRACTICE")
@XmlRootElement
public class Message {
    @Id
    @Column(name = "M_ID")
    private String mId;

    @Column(name = "MESSAGE_NAME")
    private String messageName;

    @Column(name = "MESSAGE_NOTE")
    private String messageNote;

    public Message() {
    }

    public Message(String mId, String messageName, String messageNote) {
        this.mId = mId;
        this.messageName = messageName;
        this.messageNote = messageNote;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageNote() {
        return messageNote;
    }

    public void setMessageNote(String messageNote) {
        this.messageNote = messageNote;
    }
}
