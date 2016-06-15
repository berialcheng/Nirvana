package base;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;


public class ObjectsDemo {

    static class Demo implements Comparable<Demo>{
        String id ;

        String name;

        public Demo(String id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode(){
        // Java 7 version
        //return java.util.Objects.hash(id, name);
        return Objects.hashCode(id, name);
    }

        @Override
        public String toString(){
            return MoreObjects.toStringHelper(this)
                    .add("id", this.id)
                    .add("name", this.name)
                    .toString();
        }

        public int compareTo(Demo o) {
            return ComparisonChain.start()
                    .compare(this.id, o.id)
                    .compare(this.name, o.name)
                    .result();
        }
    }

    public static void main(String[] args){
        System.out.println(new Demo("123", "nnn"));
    }
}
