import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] countryArray = new String[20];

        countryArray[0] = "Austria";
        countryArray[1] = "Belgium";
        countryArray[2] = "China";
        countryArray[3] = "Denmark";
        countryArray[4] = "England";
        countryArray[5] = "France";
        countryArray[6] = "Germany";
        countryArray[7] = "Honduras";
        countryArray[8] = "Italy";
        countryArray[9] = "Japan";
        countryArray[10] = "Korea";
        countryArray[11] = "Latvia";
        countryArray[12] = "Morrocco";
        countryArray[13] = "Nigeria";
        countryArray[14] = "Oman";
        countryArray[15] = "Pakistan";
        countryArray[16] = "Quebec";
        countryArray[17] = "Romania";
        countryArray[18] = "Spain";
        countryArray[19] = "Tajikistan";

        Random random = new Random();
        int randomNumber = random.nextInt(20);
        Scanner countryScanner = new Scanner(System.in);

        String randomCountry = countryArray[randomNumber];

        String toGuessString = "";
        for (int i = 0; i < randomCountry.length(); ++i) {
            toGuessString += "_";
        }
        System.out.println(toGuessString);

        int failCounter = 0;
        while (failCounter < 5) {
            if (toGuessString.equals(randomCountry)) {
                System.out.println("Congratulations, you've solved it!");
                break;
            }
            Boolean validChar = true;
            char userInput = '\0';
            while (validChar) {
                try {
                    System.out.print("Please enter a letter you want to guess " + "(Fails: " + failCounter + "): \n");
                    userInput = countryScanner.next().charAt(0);
                    if (toGuessString.contains(String.valueOf(userInput)))
                        System.out.println(toGuessString);
                    else
                        validChar = false;
                } catch (Exception e) {
                    System.err.println("Please enter a valid letter!");
                }
            }

            if (!Character.isSpaceChar(userInput)) {
                randomCountry = randomCountry.toLowerCase();
                if (randomCountry.contains(String.valueOf(userInput))) {
                    char[] randomCountryArray = toGuessString.toCharArray();
                    for (int c = 0; c < randomCountry.length(); ++c) {
                        if (randomCountry.charAt(c) == userInput) {
                            randomCountryArray[c] = userInput;
                            toGuessString = String.valueOf(randomCountryArray);
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

        countryScanner.close();

    }
}