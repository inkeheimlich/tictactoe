package oata;
import java.util.Scanner;

/**
*   Tic Tac Toe Spiel
*   @author Inke Christine Heimlich
*/
public class TicTacToe {

    private char pos[] = new char[10];
    private char player;
    
    public static void main (String args[]){
        TicTacToe Game = new TicTacToe();
        do {
            Game.newBoard();
            Game.play();
        } while (Game.checkNewGame() .equals("ja"));
        System.out.println ("Auf wiedersehen!");
    }

    public void newBoard (){
        char posdef[] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
        player = 'X';
        for (int i=1; i<10; i++) {
            pos[i] = posdef[i];
        }
        System.out.println("\033[35mDer Spieler " + player + " beginnt das Spiel und hat das Zeichen 'X'.\033[37m" );
    }

    public void play(){
        int spot;
        char blank = ' ';
        do {
            currentBoard();      
            if(player == 'X') {
                System.out.println( "\033[35m\n\nSpieler " + player + ": Wähle eine Position.\033[37m" );
            }else{
                System.out.println( "\033[33m\n\nSpieler " + player + ": Wähle eine Position.\033[37m" );
            }
            boolean posTaken = true;
            while (posTaken) {
                Scanner inputConsole = new Scanner (System.in);
                spot = inputConsole.nextInt();
                posTaken = checkPos(spot);
                if (posTaken == false) {
                    pos[spot] = player;
                }
            }
            nextPlayer();
        }while (checkWinner() == blank);
    }

    public String currentBoard (){
        System.out.println( "_____________________________________" );
        System.out.println(  "\n\n" + pos[1] + "|" + pos[2] + "|" + pos[3]);
        System.out.println(  "_|_|_ " );
        System.out.println(  "" + pos[4] + "|" + pos[5] + "|" + pos[6]);
        System.out.println(  "_|_|_ " );
        System.out.println(  "" + pos[7] + "|" + pos[8] + "|" + pos[9]);
        System.out.println(  "\n\n" );
        return "currentBoard";
    }

    public boolean checkPos (int spot){
        if (pos.length > spot){
                
            if (pos[spot] == 'X' || pos[spot] == 'O'){
                System.out.println ("Diese Position ist besetzt!");
                return true;
            }
            else {
                return false;
            }
        }else{
            System.out.println ("Die Position war missverständlich!");
            return true; 
        }
    }
    
    public void nextPlayer (){
        if (player == 'X') {
            player = 'O';     
        }
        else {
            player = 'X';
        }
    }

    public char checkWinner(){
        char Winner = ' ';
        if (pos[1] == 'X' && pos[2] == 'X' && pos[3] == 'X'){
            Winner = 'X';
        } 
        if (pos[4] == 'X' && pos[5] == 'X' && pos[6] == 'X'){
            Winner = 'X';
        } 
        if (pos[7] == 'X' && pos[8] == 'X' && pos[9] == 'X'){
            Winner = 'X';
        } 
        if (pos[1] == 'X' && pos[4] == 'X' && pos[7] == 'X'){
            Winner = 'X';
        } 
        if (pos[2] == 'X' && pos[5] == 'X' && pos[8] == 'X'){
            Winner = 'X';
        } 
        if (pos[3] == 'X' && pos[6] == 'X' && pos[9] == 'X'){
            Winner = 'X';
        } 
        if (pos[1] == 'X' && pos[5] == 'X' && pos[9] == 'X'){
            Winner = 'X';
        } 
        if (pos[3] == 'X' && pos[5] == 'X' && pos[7] == 'X'){
            Winner = 'X';
        } 
        if (Winner == 'X' ){   
            System.out.println("\033[35mDer erste Spieler hat gewonnen.\033[37m");
            return Winner;
        }
        
        if (pos[1] == 'O' && pos[2] == 'O' && pos[3] == 'O'){
            Winner = 'O';
        } 
        if (pos[4] == 'O' && pos[5] == 'O' && pos[6] == 'O'){
            Winner = 'O';
        } 
        if (pos[7] == 'O' && pos[8] == 'O' && pos[9] == 'O'){
            Winner = 'O';
        } 
        if (pos[1] == 'O' && pos[4] == 'O' && pos[7] == 'O'){
            Winner = 'O';
        } 
        if (pos[2] == 'O' && pos[5] == 'O' && pos[8] == 'O'){
            Winner = 'O';
        } 
        if (pos[3] == 'O' && pos[6] == 'O' && pos[9] == 'O'){
            Winner = 'O';
        } 
        if (pos[1] == 'O' && pos[5] == 'O' && pos[9] == 'O'){
            Winner = 'O';
        } 
        if (pos[3] == 'O' && pos[5] == 'O' && pos[7] == 'O'){
            Winner = 'O';
        } 
        if (Winner == 'O' ){
            System.out.println("\033[33mDer zweite Spieler hat das Spiel gewonnen.\033[37m");
            return Winner; 
        }
        
        for (int i=1; i<10; i++){
            if (pos[i]=='X' || pos[i]=='O') {
                if (i==9) {
                    char Draw='D';
                    System.out.println("\033[34mDas Spiel war unendschieden!\033[37m");
                    return Draw;
                }
                continue;
            }
            else {
               break;
            }       
        }
        return Winner;
    }

    public String checkNewGame (){
        String userInput;
        System.out.println ("Möchten Sie erneut spiel (Eingabe: 'ja')? ");
        Scanner inputConsole = new Scanner(System.in);
        userInput = inputConsole.nextLine();
        System.out.println("Die Eingabe war " + userInput);
        return userInput;
    }
}