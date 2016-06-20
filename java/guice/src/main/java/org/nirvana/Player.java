package org.nirvana;

import javax.inject.Inject;

@javax.inject.Singleton
public class Player {

    private Contact mobile;
    private Laptop laptop;

    private static int initializeCount = 0;

    @Inject
    public Player(Contact mobile, Laptop laptop){
        this.mobile = mobile;
        this.laptop = laptop;
        this.initializeCount++;
    }

    public void diplayInfo(){
        System.out.println("Mobile:" + mobile);
        System.out.println("Laptop:" + laptop);
        System.out.println("Initialize:" + initializeCount);
    }
}
