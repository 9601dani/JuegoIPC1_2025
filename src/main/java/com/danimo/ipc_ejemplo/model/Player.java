package com.danimo.ipc_ejemplo.model;

public class Player {
    
    private String name;

    private int score;

    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    public void addPoint(){
        this.score++;
    }

    public int getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }
}
