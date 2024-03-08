package com.ematiej.maven_course;

import java.util.*;

public class MyCodeRevC {

    public final int value;

    public MyCodeRevC(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {

        return this.value == ((MyCodeRevC) o).value;
    }

    @Override
    public int hashCode() {
        return 1;
    }

}

class MyAllegro {
    public static void main(String[] args) {
        Map<MyCodeRevC, String> map = new HashMap<>();
        for (int i = 0; i < 10_000; ++i) {
            map.put(new MyCodeRevC(i), "somevalue" + i);
        }
        System.out.println( map.size());
        String s = map.get(new MyCodeRevC(9999));
        System.out.println(s);
    }

    public List<String> process(final List<String> items) {
        List items1 = new LinkedList<>();
        List<String> myStrings = new ArrayList<>();
        items.add("pro");
        return items;
    }
}

