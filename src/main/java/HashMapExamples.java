import java.util.HashMap;
import java.util.Map;

/**
 * HashMaps are a data structure that stores key-value pairs
 *  and allows for fast lookup, insertion, and deletion of
 *  elements based on their keys.
 *
 * Keys are unique, but Values can be duplicated
 * HashMaps does not maintain any order, but is memory efficent
 * Hashmap<Key, Value>
 */

public class HashMapExamples {

    /**
     * Example of a HashMap using BroCode's video, link below
     * https://youtu.be/NMHk1CGb28o?si=oNoJZhyZFWQEdNag
     */
    public static void broCodeExample() {
        //What we have told java here is that we have String as the
        // key and double as the value.
        HashMap<String, Double> map = new HashMap<>();

        //This puts the key-value pair into the map
        //To put things into a HashMap, we use the put() method and
        // that must have 2 parameters, the key and the value
        map.put("apple", 0.50);
        map.put("orange", 0.75);
        map.put("banana", 0.25);

        System.out.println(map);

        //Spacer line for readability
        System.out.println();

        //If you try and add a value with the same key, then the
        // newest instance of that key will overwrite the older ones.
        map.put("orange", 1000000.00);
        System.out.println(map);
        System.out.println("If you try and put a duplicate key, the newest instance of that key will overwrite the older ones.");

        //Spacer line for readability
        System.out.println();

        map.put("coconut", 1.00);
        System.out.println("Adding coconut to the map\n" + map + "\n");

        map.remove("apple");
        System.out.println("Removing apple from the map\n" + map + "\n");

        //the.get method returns the value associated with the key if it is in the map
        System.out.println("Get me the value with the key \"banana\": " + map.get("banana") + "\n");

        //Spacer line for readability
        System.out.println();

        //the.containsKey method returns a boolean and tells you if that key is in the map or not
        System.out.println("Does the map contain the key \"banana\": " + map.containsKey("banana"));
        System.out.println("Does the map contain the key \"pineapple\": " + map.containsKey("pineapple"));

        //Spacer line for readability
        System.out.println();

        System.out.println("Checking to see if map contains \"banana\":");
        if(map.containsKey("banana")) {
            System.out.println("map DOES contain \"banana\": " + map.get("apple"));
        } else {
            System.out.println("Key was not found");
        }

        //Spacer line for readability
        System.out.println();

        //There also is a containsValue method, and returns a boolean if that value is in the map or not
        System.out.println("Does the map contain the value 0.25: " + map.containsValue(0.25));

        //Spacer line for readability
        System.out.println();

        //The size method returns the number of key-value pairs in the map
        System.out.println("The map's size is: " + map.size());

        //Spacer line for readability
        System.out.println();

        //this says "for every key in our set of keys, we will do:
        //Printing the hash map in a more readable way
        for(String key: map.keySet()) {
            System.out.println(key + " : $" + map.get(key));
        }
    }

    /**
     * Example of a HashMap using chatGPT to help explain it
     */
    public static void chatGPTExample() {
        //Key = String, Value = Integer
        HashMap<String, Integer> ages = new HashMap<>();

        //put(key, value) inserts or replaces the value for that key
        ages.put("Jon", 18);
        ages.put("Alex", 20);
        ages.put("Joe", 50);

        System.out.println("Map: " + ages);

        //get(key) returns the value (or null if the key is missing)
        System.out.println("Alex's age: " + ages.get("Alex"));

        //containsKey checks if a key exists
        System.out.println("Has Jon? " + ages.containsKey("Jon"));

        //replace a value by putting again with the same key
        ages.put("Alex", 19);
        System.out.println("Updated Alex: " + ages.get("Alex"));

        //remove deletes the key-value pair
        ages.remove("Alex");
        System.out.println("After removing Alex: " + ages);

        //size
        System.out.println("Side of map: " + ages.size());

        //----------------------------------------------------
        //Spacer lines for readability
        System.out.println();
        System.out.println();
        //----------------------------------------------------

        String text = "to be or not to be";
        //Split the text into words and stores them in an array
        String[] words = text.split("\\s+");

        HashMap<String, Integer> freq = new HashMap<>();

        for (String w: words) {
            //getOrDefault avoids checking for null
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        System.out.println(freq); // {to=2, be=2, or=1, not=1}
        System.out.println("Count of 'to': " + freq.get("to"));

        //----------------------------------------------------
        //Spacer lines for readability
        System.out.println();
        System.out.println();
        //----------------------------------------------------

        HashMap<String, Double> prices = new HashMap<>();
        prices.put("Milk", 3.49);
        prices.put("Eggs", 2.99);
        prices.put("Bread", 2.50);

        // Loop through key-value pairs
        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        broCodeExample();

        //Spacer lines for readability
        System.out.println();
        System.out.println();

        chatGPTExample();
    }
}
