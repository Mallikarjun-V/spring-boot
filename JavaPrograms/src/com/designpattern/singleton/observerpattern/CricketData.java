package com.designpattern.singleton.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class CricketData implements Subject {
    int runs; 
    int wickets; 
    float overs;
    
    List<Observer> observers = new ArrayList<>();
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        
    }
    
    @Override
    public void unRegisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(runs, wickets, overs));
    }
    
    
    private int getLatestRuns() 
    { 
        // return 90 for simplicity 
        return 90; 
    } 
  
    // get latest wickets from stadium 
    private int getLatestWickets() 
    { 
        // return 2 for simplicity 
        return 2; 
    } 
  
    // get latest overs from stadium 
    private float getLatestOvers() 
    { 
        // return 90 for simplicity 
        return (float)10.2; 
    } 
  
    // This method is used update displays 
    // when data changes 
    public void dataChanged() 
    { 
        //get latest data 
        runs = getLatestRuns(); 
        wickets = getLatestWickets(); 
        overs = getLatestOvers(); 
  
        notifyObservers(); 
    } 
    
}
