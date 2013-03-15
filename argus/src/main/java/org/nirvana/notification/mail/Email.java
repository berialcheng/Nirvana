package org.nirvana.notification.mail;

import java.sql.Timestamp;

import com.mongodb.ReflectionDBObject;

public class Email extends ReflectionDBObject
{
    private String subject;

    private String body;

    private String from;

    private String to;

    private String cc;
    
    public Timestamp getInsertTs()
    {
        return insertTs;
    }

    public void setInsertTs(Timestamp insertTs)
    {
        this.insertTs = insertTs;
    }

    public Timestamp getSendTs()
    {
        return sendTs;
    }

    public void setSendTs(Timestamp sendTs)
    {
        this.sendTs = sendTs;
    }

    private Timestamp insertTs;

    private Timestamp sendTs;

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }

    public String getCc()
    {
        return cc;
    }

    public void setCc(String cc)
    {
        this.cc = cc;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }
}
