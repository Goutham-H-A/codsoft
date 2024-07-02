import java.util.Scanner;

public class RandomNumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int chances = 8;
        int finalscore = 0;
        boolean playAgain = true;
        System.out.println("Welcome to the Game");
        System.out.println("You have" + chances + "chances To Win the Game");
        while (playAgain) {
            boolean guess = false;
            int randomNumber = generateRandomNumber();
            for (int i = 0; i < chances; i++) {
                System.out.println("Now You Have Chance     " + (i + 1) + "/8");
                System.out.println("Enter Yout guess between 1 and 100:");
                int value = input.nextInt();

                if (value == randomNumber) { // checking entered value matches the random number
                    guess = true;
                    finalscore += 1;
                    System.out.println("YOU WON!!!!");
                    break;
                }

                else if (value > randomNumber) { // checking value greater than random number
                    System.out.println("Your guess  " + value + "   is TOO HIGH");
                }

                else { // value lesser than random number
                    System.out.println("Your guess  " + value + "   is TOO LOW");
                }

            } // close of For

            if (guess == false) { // wrong guess and out of given chances
                System.out.println("Sorry Buddy You missed the chances");
                System.out.println("The Answer is   " + randomNumber);
            }

            System.out.println("Want To Play Again (y/n)?"); // asking to play again or not
            String response = input.next();
            playAgain = response.equalsIgnoreCase("y");
        } // close of While

        System.out.println("Your Final Score is:    " + finalscore); // printing the final score

    }// close of Main

    public static int generateRandomNumber() { // function to generate random numbers
        return (int) (Math.floor(Math.random() * 100) + 1);
    }

}// close of Class