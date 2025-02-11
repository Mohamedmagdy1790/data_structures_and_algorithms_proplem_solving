package org.example;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Main {

            public static void main(String[] args) {
                // Create a Hashtable with an initial capacity of 3 and load factor of 2
                Hashtable<String, String> hashtable = new Hashtable<> (3, 2.0f);

                // Add entries to the hashtable
                hashtable.put ("01", "Mohamed");
                hashtable.put ("02", "Ahmed");
                hashtable.put ("03", "Bob");
                hashtable.put ("04", "Alice");
                hashtable.put ("05", "Bob");
                hashtable.put ("06", "Alice");

                // Print the entries grouped by their bucket index
                printBuckets (hashtable);
            }

            private static void printBuckets(Hashtable<String, String> hashtable) {
                int numBuckets = 3; // Initial capacity of Hashtable

                // Iterate over each entry in the hashtable
                for (Map.Entry<String, String> entry : hashtable.entrySet ()) {
                    String key = entry.getKey ();
                    String value = entry.getValue ();

                    // Calculate the bucket index using the hash code and the number of buckets
                    int bucketIndex = (key.hashCode () & 0x7FFFFFFF) % numBuckets;

                    // Print the bucket index and the entry
                    System.out.println ("Bucket " + bucketIndex + ": (" + key + ", " + value + ")");
                }
            }

}

