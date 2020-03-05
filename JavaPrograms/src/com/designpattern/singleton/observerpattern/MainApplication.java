package com.designpattern.singleton.observerpattern;

/**
 * The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its
 * dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their
 * methods.
 */
public class MainApplication {
    public static void main(String[] args) {
        // create objects for testing
        Observer currentScoreDisplay = new CurrentScoreDisplay();
        Observer averageScoreDisplay = new AverageScoreDisplay();
        
        // pass the displays to Cricket data
        CricketData cricketData = new CricketData();
        
        // register display elements
        cricketData.registerObserver(currentScoreDisplay);
        cricketData.registerObserver(averageScoreDisplay);
        
        // in real app you would have some logic to call this function when data changes
        cricketData.dataChanged();
        
        // remove an observer
        cricketData.unRegisterObserver(averageScoreDisplay);
        
        // now only currentScoreDisplay gets the notification
        cricketData.dataChanged();
    }
}
