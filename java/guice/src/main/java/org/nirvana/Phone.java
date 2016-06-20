package org.nirvana;

/**
 * Created by zhongch on 6/20/2016.
 */
public class Phone  implements Contact {

    private String number;

    public Phone(){
        this.number = "2222222";
    }

    public String toString(){
        return "[Phone: " + number + "]";
    }
}
