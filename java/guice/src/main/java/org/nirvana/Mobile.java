package org.nirvana;

public class Mobile implements Contact {

    private String number;

    public Mobile(){
        this.number = "988438434";
    }

    public String toString(){
        return "[Mobile: " + number + "]";
    }
}