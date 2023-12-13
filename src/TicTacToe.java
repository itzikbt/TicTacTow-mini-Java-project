import java.util.*;
public class TicTacToe {
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


    static ArrayList<Integer> playersPositions = new ArrayList<>(); // the positions the player chose
    static ArrayList<Integer> cpuPositions = new ArrayList<>(); // the positions the cpu chose


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
