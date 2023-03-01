
/*
В этом классе нужно реализовать методы для: хода человека, хода компьютера, проверки победителя и проверки правильности
хода человека
 */

/**
 * @author - group 24.01-23
 * @version - 2.0
 * @date - 01.03.2023
 */

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class GameUtils {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    static final String MESSAGE_1 = "Player 1 wins";
    static final String MESSAGE_2 = "Player 2 wins";
    static final String SCISSORS = "Scissors";
    static final String PAPER = "Paper";
    static final String ROCK = "Rock";
    static final String MISTAKE = "Mistake";


    /**
     * Метод для создания хода игрока
     * @param count - указывает номер игрока
     * @return - ход игрока
     */

    public static String playerMove(int count){
        String move = "";
        while (true){
            System.out.println("Make your move, player" + count + ": ");
            move = scanner.next();
            if(isRight(move)){

                break;
            }
            else
            {
                System.out.println(MISTAKE);
            }
        }
        return move;
    }

    /**
     * Генерация хода компьютера при помощи Random
     * @return - Ход компьютера
     */

    public static String computerMove(){
        String move = "";
        int rand = random.nextInt(3) + 1;

        if(rand == 1){
            move = SCISSORS;
        }

        if(rand == 2){
            move = PAPER;
        }

        if(rand == 3){
            move = ROCK;
        }

        return move;
    }

    /**
     * Проверка победителя
     * @param player1 - Первый игрок
     * @param player2 - Второй игрок
     * @return - Победителя
     */

    public static String checkWinner(String player1, String player2){
        System.out.println("Player 1: " + player1 + " Player 2: " + player2);

        if(player1.equals(SCISSORS) && player2.equals(ROCK)){
            return MESSAGE_2;
        }
        else if(player1.equals(SCISSORS) && player2.equals(PAPER)){
            return MESSAGE_1;
        }
        else if(player1.equals(PAPER) && player2.equals(ROCK)){
            return MESSAGE_1;
        }
        else if(player1.equals(PAPER) && player2.equals(SCISSORS)){
            return MESSAGE_2;
        }
        else if(player1.equals(ROCK) && player2.equals(SCISSORS)){
            return MESSAGE_1;
        }
        else if(player1.equals(ROCK) && player2.equals(PAPER)){
            return MESSAGE_2;
        }
        else
            return "Draw";
    }


    /**
     * Проверяем корректность ввода пользователя
     * @param move  - ход пользователя
     * @return   - Правильность ввода
     */

    public static boolean isRight(String move) {
        if( !move.equals(SCISSORS) && !move.equals(ROCK) && !move.equals(PAPER)){
            return false;
        }
        else
            return true;
    }

}
