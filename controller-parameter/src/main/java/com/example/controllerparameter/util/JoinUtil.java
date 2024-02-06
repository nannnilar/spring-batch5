package com.example.controllerparameter.util;

import java.util.*;

public class JoinUtil {

    public static String join(Enumeration<String> enumeration){
        return join(enumeration.asIterator());
    }

    public static String join(Iterator<String> elements){
        List<String> list = new LinkedList<>();
        elements.forEachRemaining(list::add);
        return String.join(", ",list);
    }
}
