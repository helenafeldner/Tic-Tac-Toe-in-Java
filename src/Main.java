import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    //Print the board to the terminal.
    private static void printBoard(char[] board) {
            System.out.println(" -----------");
            System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
            System.out.println(" -----------");
            System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
            System.out.println(" -----------");
            System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
            System.out.println(" -----------");
        }
    
    //Checks if X or O has won and returns true. Else false.
    static boolean checkWinner(char[] board) {
        int[][] wins = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //columns
            {0, 4, 8}, {2, 4, 6}             //diagonals
        };
        //Check if 3 spots are the same:
        for (int[] combination : wins) {
            if (board[combination[0]] == board[combination[1]] && board[combination[1]] == board[combination[2]]) {
                return true;
            }
        }
        return false;
    }

    // Check if the board cell at given index is out of range or is already taken by 'X' or 'O'.
    static boolean isPositionValid(int position) {
        //Position should be from 1 to 9
        if (position >= 1 && position <= 9 && board[position - 1] != 'X' && board[position - 1] != 'O') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Game start
        System.out.println();
        System.out.println("Welcome to Tic-Tac-Toe");
        printBoard(board);
        
        char currentPlayer = 'X';

        //Game play
        while (true) {
            System.out.println("Player " + currentPlayer + ": Please choose a position (1-9)");

            int position;
            //Check if input is valid
            try {
                position = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Input not valid. Try again");
                scanner.next();
                continue;
            }

            //Check if position is taken or out of range
            if (isPositionValid(position) == false) {
                System.out.println("Position is taken or out of range. Try again ");
                continue;
            }

            //Place char on board
            board[position - 1] = currentPlayer;
            printBoard(board);

            //Check win
            if (checkWinner(board) == true) {
                System.out.println("CONGRATULATIONS! Player " + currentPlayer + " has won!!!");
                break;
            }

            //switch turns
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
        }
    }
}