package com.designpattern.singleton;

/**
 * the singleton pattern is a software design pattern that restricts the instantiation of a class to one "single"
 * instance. This is useful when exactly one object is needed to coordinate actions across the system. In below example,
 * a thread safe singleton in created so that singleton property is maintained even in multithreaded environment
 */
public class MySingleton {
    // private instance, so that it can be accessed by only by getInstance() method
    private static MySingleton instance = null;
    
    private MySingleton() {
        // private constructor
    }
    
    // Lazy initialization with Double check locking
    public static MySingleton getInstance() {
        if (null == instance) {
            // synchronized block to remove overhead
            synchronized (MySingleton.class) {
                if (null == instance) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }
}
