package com.designpattern.singleton.observerpattern;

public interface Subject {
    void registerObserver(Observer observer);
    void unRegisterObserver(Observer observer);
    void notifyObservers();
}
