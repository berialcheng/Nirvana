package org.nirvana.core;

/**
 * Created by zhongch on 6/16/2016.
 */
public class Person {

    int id;

    String name;

    public Person(){
        
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
