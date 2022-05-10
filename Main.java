import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> countryArray = new ArrayList<>();
        Scanner sc = new Scanner(new File("countries.txt")).useDelimiter(",");
        while(sc.hasNextLine()){
            countryArray.add(sc.next().replace("\"", ""));
        }

        Random random = new Random();
        int randomNumber = random.nextInt(countryArray.size());
        Scanner countryScanner = new Scanner(System.in);

        String randomCountry = countryArray.get(randomNumber);

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