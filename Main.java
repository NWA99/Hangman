import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] laenderArray = new String[20];

        laenderArray[0] = "Austria";
        laenderArray[1] = "Belgium";
        laenderArray[2] = "China";
        laenderArray[3] = "Denmark";
        laenderArray[4] = "England";
        laenderArray[5] = "France";
        laenderArray[6] = "Germany";
        laenderArray[7] = "Honduras";
        laenderArray[8] = "Italy";
        laenderArray[9] = "Japan";
        laenderArray[10] = "Korea";
        laenderArray[11] = "Latvia";
        laenderArray[12] = "Morrocco";
        laenderArray[13] = "Nigeria";
        laenderArray[14] = "Oman";
        laenderArray[15] = "Pakistan";
        laenderArray[16] = "Quebec";
        laenderArray[17] = "Romania";
        laenderArray[18] = "Spain";
        laenderArray[19] = "Tajikistan";

        Random random = new Random();
        int randomNumber = random.nextInt(20);
        Scanner landScanner = new Scanner(System.in);

        String randomLand = laenderArray[randomNumber];
        System.out.println(randomLand);

        String toGuessString = "";
        for (int i = 0; i < randomLand.length(); ++i) {
            toGuessString += "_";
        }
        System.out.println(toGuessString);

        int failCounter = 0;
        while (failCounter < 5) {
            if (toGuessString.equals(randomLand)) {
                System.out.println("Congratulations, you've solved it!");
                break;
            }
            Boolean validChar = true;
            char userInput = '\0';
            while (validChar) {
                try {
                    System.out.print("Please enter a letter you want to guess " + "(Fails: " + failCounter + "): \n");
                    userInput = landScanner.next().charAt(0);
                    if (toGuessString.contains(String.valueOf(userInput)))
                        System.out.println(toGuessString);
                    else
                        validChar = false;
                } catch (Exception e) {
                    System.err.println("Please enter a valid letter!");
                }
            }

            if (!Character.isSpaceChar(userInput)) {
                randomLand = randomLand.toLowerCase();
                if (randomLand.contains(String.valueOf(userInput))) {
                    char[] randomLandArray = toGuessString.toCharArray();
                    for (int c = 0; c < randomLand.length(); ++c) {
                        if (randomLand.charAt(c) == userInput) {
                            randomLandArray[c] = userInput;
                            toGuessString = String.valueOf(randomLandArray);
                        }
                    }
                    System.out.println(toGuessString);
                } else {
                    ++failCounter;
                    System.out.println(toGuessString);
                }
                if (failCounter > 4) {
                    System.out.println("GAME OVER!!!");
                    break;
                }
            }

        }

        landScanner.close();

    }
}