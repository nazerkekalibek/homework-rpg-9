package com.narxoz.rpg.memento;

import com.narxoz.rpg.combatant.HeroMemento;
import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker{
    private final Deque<HeroMemento> history = new ArrayDeque<>();

    public void save(HeroMemento memento) {
        if(memento!=null){
            history.push(memento);
        }
    }

    public HeroMemento undo() {
        if(history.isEmpty()){
            return null;
        }
        return history.pop();
    }

    public HeroMemento peek() {
        if(history.isEmpty()){
            return null;
        }
        return history.peek();
    }

    public int size() {
        return history.size();
    }
}
