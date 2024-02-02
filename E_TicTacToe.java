import java.util.Scanner;

public class E_TicTacToe {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nLet's play tic tac toe");

        // Task 1: Create an array with three rows of '_' characters.
        char[][] board = {
                { '-', '-', '-' },
                { '-', '-', '-' },
                { '-', '-', '-' }
        };

        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("Turn: X");
                int[] choices = askUser(board);
                board[choices[0]][choices[1]] = 'X';
                printBoard(board);
            } else {

                System.out.println("Turn: O");
                int[] choices = askUser(board);
                board[choices[0]][choices[1]] = 'O';
                printBoard(board);
            }
            // printBoard(board);

            int result = checkWin(board);
            if (result == 3) {
                System.out.println("X wins !!");
                break;
            } else if (result == -3) {
                System.out.println("O wins !!");
                break;
            } else if (i == 8) {
                System.out.println("It's a Tie !!");
                break;
            }

        }

        scan.close();
    }

    /**
     * Function that prints the board of the gameplay
     * 
     * @param chars
     */
    public static void printBoard(char[][] chars) {
        System.out.print("\n");

        for (int i = 0; i < chars.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Function that lets the user choose a spot
     * 
     * @param board (char[][] board)
     * @return spot (int[])
     */
    public static int[] askUser(char[][] chars) {
        System.out.print("Pick a row and column number: ");
        int[] choices = new int[2];
        int choice1 = scan.nextInt();
        int choice2 = scan.nextInt();
        while (Character.compare(chars[choice1][choice2], '-') != 0) {
            System.out.print("Spot taken, try again: ");
            choice1 = scan.nextInt();
            choice2 = scan.nextInt();
        }
        choices[0] = choice1;
        choices[1] = choice2;

        return choices;
    }

    /**
     * Function that determines the winner
     * 
     * @param board (char[][])
     * @return count (int)
     * 
     */
    public static int checkWin(char[][] board) {

        int rows = checkRows(board);
        if (Math.abs(rows) == 3)
            return rows;

        int columns = checkColumns(board);
        if (Math.abs(columns) == 3)
            return columns;

        int leftDiagonal = checkLeft(board);
        if (Math.abs(leftDiagonal) == 3)
            return leftDiagonal;

        int rightDiagonal = checkRight(board);
        if (Math.abs(rightDiagonal) == 3)
            return rightDiagonal;

        return 0;
    }

    // Checks
    public static int checkRows(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (Character.compare(board[i][j], 'X') == 0) {
                    count++;
                    if (count == 3)
                        return count;
                } else if (Character.compare(board[i][j], 'O') == 0) {
                    count--;
                    if (count == -3)
                        return count;
                }
            }
        }
        return count;
    }

    public static int checkColumns(char[][] board) {
        int count = 0;
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (Character.compare(board[i][j], 'X') == 0) {
                    count++;
                    if (count == 3)
                        return count;
                } else if (Character.compare(board[i][j], 'O') == 0) {
                    count--;
                    if (count == -3)
                        return count;
                }
            }
        }
        return count;
    }

    /*
     * Another way is to use one for loop as it will loop equal indexes, 
     * board[i][i] = board[1][1] ...
     */
    public static int checkLeft(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == j && Character.compare(board[i][j], 'X') == 0) {
                    count++;
                    if (count == 3)
                        return count;
                } else if (i == j && Character.compare(board[i][j], 'O') == 0) {
                    count--;
                    if (count == -3)
                        return count;
                }
            }
        }
        return count;
    }

    public static int checkRight(char[][] board) {
        int count = 0;
        /*
         * 2 - 0 = 2
         * 2 - 1 = 1
         * 2 - 2 = 0
         * [0][2]
         * [1][1]
         * [2][0]
         * board[2 - i][i] would work but would start from row 2
         */
        for (int i = 0; i < board.length; i++) {
            if (Character.compare(board[i][2 - i], 'X') == 0) {
                count++;
            } else if (Character.compare(board[i][2 - i], 'O') == 0) {
                count--;
            }
        }
        return count;
    }
}
