import java.util.Random;

public class MaxFinder {

    public static void main (String[] args) {

        // two highest numbers of array with 10 random numbers

        int[] randomNumbers = new int[10];

        Random rand = new Random();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(50);
        }

        int indexOfHighest = 0;
        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i] > randomNumbers[indexOfHighest]) {
                indexOfHighest = i;
            }
        }

        int highestNumber = randomNumbers[indexOfHighest];
        randomNumbers[indexOfHighest] = -1;

        for(var i: r)
        System.out.println(highestNumber);

    }
}