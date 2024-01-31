import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.
            char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
            };

            printBoard(board);
            for (int i = 0; i < 9; i++) {
                if(i % 2 == 0){
                    System.out.println("Turn: X");
                    int[] choices = askUser(board);
                    board[choices[0]][choices[1]] = 'X';
                } else {
                    
                    System.out.println("Turn: O");
                    int[] choices = askUser(board);
                    board[choices[0]][choices[1]] = 'O';

                }
            }
            printBoard(board);
            System.out.println(checkWin(board));

              /*
              {  Task 3: Loop through turns.

                  if (X) turn {
                     Task 4: call askUser(). 
                     Task 5: populate the board using askUser's return value.
                  } else {
                      Task 4: call askUser(). 
                      Task 5: populate the board using askUser's return value. Then, print it.

                  }

                Task 6 - Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              } 
              */

            scan.close();
        }


    /**
     * 
     * @param chars
     */
    public static void printBoard(char [][] chars){
        System.out.print("\n");
        
        for (int i = 0; i < chars.length; i++) {  
            System.out.print("\t");  
            for(int j = 0; j < chars[i].length; j++){
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
    }      

   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     *  
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */
    public static int[] askUser(char[][] chars){
        System.out.print("Pick a row and column number: ");
        int[] choices = new int[2];
        int choice1 = scan.nextInt();
        int choice2 = scan.nextInt();
        while(Character.compare(chars[choice1][choice2], '-') != 0){
            System.out.print("Spot taken, try again: ");
            choice1 = scan.nextInt();
            choice2 = scan.nextInt();
        }
        choices[0] = choice1;
        choices[1] = choice2;
        
        return choices;
    }

    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */
    public static int checkWin(char[][] board){
        return checkRows(board);
    }

    // Helpers
    public static int checkRows(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                
                if(Character.compare(board[i][j], 'X') != 0){
                    break;
                } 
            }
            
        }
        return count;
    }
    
    
    public static int checkColumns(char[][] board) {
        int count = 0;
        return count;
    }
    
    
    public static int checkLeft(char[][] board) {
        int count = 0;
        return count;
    }
    
    
    public static int checkRight(char[][] board) {
        int count = 0;
        return count;
    }
    


}
