import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        while (true){
            switch (choose()){
                case 1:
                    System.out.println(GameUtils.checkWinner(GameUtils.playerMove(1), GameUtils.playerMove(2)));
                break;

                case 2:
                    System.out.println(GameUtils.checkWinner(GameUtils.playerMove(1), GameUtils.computerMove()));
                break;

                case 3:
                    System.out.println(GameUtils.checkWinner(GameUtils.computerMove(), GameUtils.computerMove()));
                break;

                default:
                  System.exit(0); // Выход из приложения. Статус ноль - значит ошибки нет

            }
        }


    }

    private static int choose() {
        System.out.println("Choose game mode: \n" +
                "1 - Player VS Player\n" +
                "2 - Player VS Computer\n" +
                "3 - Computer VS Computer\n" +
                "4 - Exit");

        int answer = 0;
        while (true){
          answer = GameUtils.scanner.nextInt();
          if(isRight(answer)){
              break;
          }
          else {
              System.out.println(GameUtils.MISTAKE);
          }
        }
        return answer;
    }

    private static boolean isRight(int answer) {
        if(answer != 1 && answer != 2 && answer != 3 && answer != 4){
            return false;
        }
        else
            return true;
    }
}
