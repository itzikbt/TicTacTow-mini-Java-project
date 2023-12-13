package TicTacToe_package;

import java.util.*;
public class TicTacToe {

    public static ArrayList<Integer> playersPositions = new ArrayList<>(); // the positions the player chose
    public static ArrayList<Integer> cpuPositions = new ArrayList<>(); // the positions the cpu chose


    public static void restartGame(char[][] gameBoard){
        gameBoard[0][0] = ' ';
        gameBoard[0][2] = ' ';
        gameBoard[0][4] = ' ';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';
        gameBoard[4][0] = ' ';
        gameBoard[4][2] = ' ';
        gameBoard[4][4] = ' ';

        playersPositions.clear();
        cpuPositions.clear();
    }


    public static String checkWinner(){
        List<Integer> topRow = Arrays.asList(1,2,3); //each list contains a winning path
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> botRow = Arrays.asList(7,8,9);
        List<Integer> leftCol = Arrays.asList(1,4,7);
        List<Integer> midCol = Arrays.asList(2,5,8);
        List<Integer> rightCol = Arrays.asList(3,6,9);
        List<Integer> cross1 = Arrays.asList(1,5,9);
        List<Integer> cross2 = Arrays.asList(7,5,3);

        List<List<Integer>> winningPaths = new ArrayList<>();
        winningPaths.add(topRow);
        winningPaths.add(midRow);
        winningPaths.add(botRow);
        winningPaths.add(leftCol);
        winningPaths.add(midCol);
        winningPaths.add(rightCol);
        winningPaths.add(cross1);
        winningPaths.add(cross2);

        for (List<Integer> path: winningPaths) {
            if (playersPositions.containsAll(path)) {
                return "Congratulations You Won!";
            } else if (cpuPositions.containsAll(path)) {
                return "You lost, Sorry :(";
            } else if (playersPositions.size() + cpuPositions.size() >= 9) {
                return "CAT!";
            }
        }
        return "";
    }


    public static void placePiece(char[][] gameBoard, int pos, String user){
        char symbol = ' ';
        if (user.equals("player"))
            symbol = 'X';
        else if (user.equals("cpu"))
            symbol = 'O';

        switch (pos){
            case 1:
                gameBoard[0][0] =symbol;
                break;
            case 2:
                gameBoard[0][2] =symbol;
                break;
            case 3:
                gameBoard[0][4] =symbol;
                break;
            case 4:
                gameBoard[2][0] =symbol;
                break;
            case 5:
                gameBoard[2][2] =symbol;
                break;
            case 6:
                gameBoard[2][4] =symbol;
                break;
            case 7:
                gameBoard[4][0] =symbol;
                break;
            case 8:
                gameBoard[4][2] =symbol;
                break;
            case 9:
                gameBoard[4][4] =symbol;
                break;
        }
    }

    public static void printGameBoard(char[][] gameBoard){
        for(char[] row : gameBoard){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

}
