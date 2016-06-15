package base;

import com.google.common.base.Optional;

public class OptionalDemo {

    public static void main(String[] args){
        //GOOGLE Optional
        //Optional<String> o1 = Optional.of(null); // NullPointerException

        System.out.println();
        Optional<String> o2 = Optional.fromNullable(null);
        //System.out.println(o2.get()); // .IllegalStateException: Optional.get() cannot be called on an absent value
        System.out.println(o2.isPresent()); // false
        System.out.println(o2.orNull()); // null
        System.out.println(o2.or("ccc")); // ccc
        System.out.println(o2.asSet()); // []
        //System.out.println(o2.or()); // []

        System.out.println();
        Optional<String> o3 = Optional.fromNullable("abc");
        System.out.println(o3.get()); // abc
        System.out.println(o3.isPresent()); // ture
        System.out.println(o3.orNull()); // abc
        System.out.println(o3.or("ccc")); // ccc
        System.out.println(o3.asSet()); // [abc]

        System.out.println();
        System.out.println(o2.or(o3).get()); // abc

        //Java 8 Optional
        //java.util.Optional j1= java.util.Optional.of(null); // NullPointerException
        System.out.println();
        java.util.Optional<String> j2 = java.util.Optional.ofNullable(null);
        //System.out.println(j2.get()); // java.util.NoSuchElementException: No value present
        System.out.println(j2.isPresent()); // false

    }
}
