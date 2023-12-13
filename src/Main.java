import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static TicTacToe_package.TicTacToe.*;

public class Main {
    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-','+','-','+','-'},{' ', '|', ' ', '|', ' '},
                {'-','+','-','+','-'},{' ', '|', ' ', '|', ' '}};

        while(true) {
            printGameBoard(gameBoard);
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your placement (1-9):"); // 1-9 are the positions on the board from left to right
            int playerPos = scan.nextInt();
            while(playersPositions.contains(playerPos) || cpuPositions.contains(playerPos) || playerPos > 9 || playerPos < 1 ){
                System.out.println("Position not valid! Enter a correct position");
                playerPos = scan.nextInt();
            }
            playersPositions.add(playerPos);
            placePiece(gameBoard, playerPos, "player");

            String gamePos = checkWinner(); //check if the player won or it's a cat

            if (gamePos.equals("")) {
                Random rand = new Random();
                int cpuPos = rand.nextInt(9) + 1;
                while (playersPositions.contains(cpuPos) || cpuPositions.contains(cpuPos))
                    cpuPos = rand.nextInt(9) + 1;
                cpuPositions.add(cpuPos);

                placePiece(gameBoard, cpuPos, "cpu");
            }

            gamePos = checkWinner(); // check if the cpu won

            if(!gamePos.equals("")) { // check winner not returning "" unless the game finished
                printGameBoard(gameBoard);
                System.out.printf("%s\n", gamePos);
                System.out.println("Would you like to play another round? Answer with y/n");
                String answer = scan.next();
                while (!answer.equals("y") && !answer.equals("n")){
                    System.out.println("Answer not valid! Enter a correct answer");
                    answer = scan.next();
                }
                if (answer.equals("y")){
                    restartGame(gameBoard);
                }else {
                    System.out.println("GoodBye :)");
                    break;
                }
            }

            System.out.println();
        }

    }
}