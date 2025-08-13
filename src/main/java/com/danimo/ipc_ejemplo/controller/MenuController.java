package com.danimo.ipc_ejemplo.controller;

import java.util.Scanner;

import com.danimo.ipc_ejemplo.model.Game;
import com.danimo.ipc_ejemplo.model.Player;
import com.danimo.ipc_ejemplo.view.Menu;

public class MenuController {
    private Menu menu = new Menu();
    private Game game = new Game();
    private Scanner scanner = new Scanner(System.in);

    public void startGame(){

        System.out.println("Ingresa tu nombre");

        String name = scanner.nextLine();

        Player player = new Player(name);

        boolean exitGame = false;

        while(!exitGame){
            menu.showMainMenu();

            int option = scanner.nextInt();

            switch (option) {
                case 1:

                    playRound(player);
                case 2:
                    System.out.println("Gracias por JUgar ");
                    exitGame = true;
                    break;
            
                default:
                    System.out.println("Digite una opcion valida");
            }
        }

    }

    public void playRound(Player player){

        int choiceNumber = 0;

        while(choiceNumber != 4){
            menu.showOptionMenu();

            String playerChoice ="";
            choiceNumber = scanner.nextInt();

            switch (choiceNumber) {
                case 1:  playerChoice = "Piedra"; break;
                case 2: playerChoice = "Papel"; break;
                case 3: playerChoice = "Tijera"; break;
            
                default:
                    System.out.println("OPcion invalida");
                    return;
            }

            String computerChoice = game.getComputerChoice();

            System.out.println("La computadora escogio: " + computerChoice);

            String result = game.determinateWinner(playerChoice, computerChoice);

            if(result.equals("Jugador")){
                player.addPoint();
                System.out.println(player.getName() + " GANASTE LA RONDA");
            }else if( result.equals("Computadora")){
                System.out.println("La computadora gano :c ");
            }else{
                System.out.println("Es un empate");
            }

            System.out.println("Puntaje actual de "+ player.getName() + ": " + player.getScore());

        }


    }
    
}
