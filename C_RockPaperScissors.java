import java.util.Scanner;

public class C_RockPaperScissors {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");

        String answer = scan.nextLine();

        if (answer.equals("yes")) {
            System.out.println("\nGreat!");
            System.out.println("rock - paper - scissors, shoot!");

            String yourChoice = scan.nextLine();
            String compChoice = computerChoice();
            String result = result(yourChoice, compChoice);
            printResult(yourChoice, compChoice, result);

        } else {
            System.out.println("Darn, some other time...!");
        }
        scan.close();
    }

    /**
     * Function name: computerChoice - picks randomly between rock paper and
     * scissors
     * 
     * @return a choice (String).
     * 
     */
    public static String computerChoice() {
        int number = (int) (Math.random() * 3);
        switch (number) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return "Error in the app! Consider investigating this bug!";
        }
    }

    /**
     * Function name: result - It returns the result of the game.
     * 
     * @param yourChoice     (String)
     * @param computerChoice (String)
     * @return result (String)
     */

    public static String result(String yourChoice, String computerChoice) {
        String result = "";

        if (youWin(yourChoice, computerChoice)) {
            result = "You win!";
        } else if (youLose(yourChoice, computerChoice)) {
            result = "You Lose!";
        } else if (yourChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else {
            System.out.println("INVALID CHOICE");
        }

        return result;
    }

    public static boolean youWin(String yourChoice, String computerChoice) {
        return (yourChoice.equals("rock") && computerChoice.equals("scissors")
                || (yourChoice.equals("paper") && computerChoice.equals("rock"))
                || (yourChoice.equals("scissors") && computerChoice.equals("paper")));
    }

    public static boolean youLose(String yourChoice, String computerChoice) {
        return (yourChoice.equals("scissors") && computerChoice.equals("rock")
                || (yourChoice.equals("rock") && computerChoice.equals("paper"))
                || (yourChoice.equals("paper") && computerChoice.equals("scissors")));
    }

    // Task 5 – Write a function that prints your choice, the computer's, and the
    // result.

    /**
     * Name: printResult - It prints everything (your choice, computer choice,
     * result)
     * 
     * @param yourChoice     (String)
     * @param computerChoice (String)
     * @param result         (String)
     * 
     */
    public static void printResult(String yourChoice, String computerChoice, String result) {
        System.out.println("You choose: \t" + yourChoice);
        System.out.println("The computer chose: \t" + computerChoice);
        System.out.println(result);
    }

}
