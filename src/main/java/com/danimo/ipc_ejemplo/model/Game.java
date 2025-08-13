package com.danimo.ipc_ejemplo.model;

import java.util.Random;

public class Game {
    private final String[] option = {"Piedra", "Papel", "Tijera"};
    private final Random random = new Random();

    public String getComputerChoice(){
        int index = random.nextInt(option.length);
        return option[index];
    }

    public String determinateWinner(String playerChoice, String computerChoice){
        if(playerChoice.equals(computerChoice)){
            return "Empate / Draw";
        }

        switch (playerChoice) {
            case "Piedra":
                return (computerChoice.equals("Tijera") ? "Jugador" : "Computadora");

            case "Papel":
                if(computerChoice.equals("Tijera")){
                    return "Computadora";
                }else{
                    return "Jugador";
                }
            
            case "Tijera":
                return ( computerChoice.equals("Papel") ? "Jugador" : "Computadora");
        
            default:
                return "Opcion Invalida";
        }
    }
    
}
