package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String,Integer> m = new HashMap<> ();
// Immutable Map containing a single key/value pair
        Map<String,Integer> singleton = Collections.singletonMap("test", -1);
// Note this rarely used syntax to explicitly specify the parameter
// types of the generic emptyMap method. The returned map is immutable
        Map<String,Integer> empty = Collections.<String,Integer>emptyMap();
// Populate the map using the put method to define mappings
// from array elements to the index at which each element appears
        String[] words = { "this", "is", "a", "test" };
        for(int i = 0; i < words.length; i++) {
            m.put(words[i], i); // Note autoboxing of int to Integer
        }

        System.out.println (m.get ("this"));
// Each key must map to a single value. But keys may map to the
// same value
        for(int i = 0; i < words.length; i++) {
            m.put(words[i].toUpperCase(), i);
        }
        System.out.println (m.get ("THIS"));

        System.out.println (m.get ("test"));

//        m.putAll (singleton);
//        System.out.println (m.get ("test"));

        // Query the mappings with the get() method
        for(int i = 0; i < words.length; i++) {
            if (m.get(words[i]) != i) throw new AssertionError();
        }


        // Key and value membership testing
        System.out.println (m.containsKey(words[0]));; // true
        System.out.println (m.containsValue(4)); // false


        // Map keys, values, and entries can be viewed as collections
        Set<String> keys = m.keySet();
        Collection<Integer> values = m.values();
        Set<Map.Entry<String,Integer>> entries = m.entrySet();

       // The Map and its collection views typically have useful
       // toString methods
        System.out.printf("Map: %s%nKeys: %s%nValues: %s%nEntries: %s%n",
                m, keys, values, entries);

        System.out.println ("-------------------------------------------");
        // These collections can be iterated.
        // Most maps have an undefined iteration order (but see SortedMap)
        for(String key : m.keySet()) System.out.printf(key+" ");
        System.out.println ();
        for(Integer value: m.values()) System.out.printf(value+" ");
    }
}
