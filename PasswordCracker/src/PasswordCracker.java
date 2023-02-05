import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PasswordCracker implements Runnable {
    static int nThreads = Runtime.getRuntime().availableProcessors() / 2;
    static ExecutorService executor = Executors.newFixedThreadPool(nThreads);
    String password = "";
    char[] arrayPassword;
    char[] index = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0','1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', ',', '.', '\\', '/', '<', '>', '~', '!', '@', '#', '$', '%', '&', '&', '*', '(', ')', '-', '_', '=', '+', '[', ']', '{', '}', '?', '\'', '"', '|'};
    int size = 0;
    ArrayList<Character> arrayListPassword = new ArrayList<>();
    public PasswordCracker(String password) {
        this.password = password;
        arrayPassword = password.toCharArray();
        for (Character character : arrayPassword) { arrayListPassword.add(character); }
        this.size = arrayListPassword.size();
    }
    public void testSpeed() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose 1 for version 1 and 2 for version 2.");
        int i = input.nextInt();
        if (i == 1) {
            long start = System.currentTimeMillis();
            this.randCharListPasswordGenerator();
            long time = (System.currentTimeMillis() - start) / 1000;
            System.out.println(time + " seconds");
        } else if (i == 2) {
            long start = System.currentTimeMillis();
            this.randCharPasswordGenerator();
            long time = (System.currentTimeMillis() - start) / 1000;
            System.out.println(time + " seconds");
        }
    }
    public boolean isCorrect(ArrayList<ArrayList<Character>> guesses) {
        for (ArrayList<Character> guess : guesses) { if (guess.equals(arrayListPassword)) { return true; } } return false; }
    public void seqCharPasswordGenerator() {
        long start = System.currentTimeMillis();
        boolean correctValue = false;
        long attempts = 1;
        ArrayList<Character> indexArrayList = new ArrayList<>();
        for (int i = 0; i < index.length; i++) { indexArrayList.add(index[i]);}
        boolean isCorrect = false;
        ArrayList<ArrayList<Character>> guesses = new ArrayList<>();
        for (int itrOne = 0; itrOne < indexArrayList.size(); itrOne++) {
            if (isCorrect) { break; }
            ArrayList<Character> guessOneDigit = new ArrayList<>();
            Character characterOne = index[itrOne];
            guessOneDigit.add(characterOne);
            if (!isCorrect) {
                if (guessOneDigit.equals(this.arrayListPassword)) {
                    long time = (System.currentTimeMillis() - start) / 1000;
                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessOneDigit + " | - Correct - " + time + " seconds");
                    isCorrect = true;
                    executor.shutdownNow();
                    break;
                } else {
                    long time = (System.currentTimeMillis() - start) / 1000;
                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessOneDigit + " | - Wrong - " + time + " seconds");
                    attempts++;
                }
            }
            for (int itrTwo = 0; itrTwo < indexArrayList.size(); itrTwo++) {
                if (isCorrect) { break; }
                ArrayList<Character> guessTwoDigit = new ArrayList<>();
                Character characterTwo = index[itrTwo];
                guessTwoDigit.add(characterOne);
                guessTwoDigit.add(characterTwo);
                if (!isCorrect){
                    if (guessTwoDigit.equals(this.arrayListPassword)) {
                        long time = (System.currentTimeMillis() - start) / 1000;
                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessTwoDigit + " | - Correct - " + time + " seconds");
                        isCorrect = true;
                        executor.shutdownNow();
                        break;
                    } else {
                        long time = (System.currentTimeMillis() - start) / 1000;
                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessTwoDigit + " | - Wrong - " + time + " seconds");
                        attempts++;
                    }
                }
                for (int itrThree = 0; itrThree < indexArrayList.size(); itrThree++) {
                    if (isCorrect) { break; }
                    ArrayList<Character> guessThreeDigit = new ArrayList<>();
                    Character characterThree = index[itrThree];
                    guessThreeDigit.add(characterOne);
                    guessThreeDigit.add(characterTwo);
                    guessThreeDigit.add(characterThree);
                    if (!isCorrect) {
                        if (guessThreeDigit.equals(this.arrayListPassword)) {
                            long time = (System.currentTimeMillis() - start) / 1000;
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessThreeDigit + " | - Correct - " + time + " seconds");
                            isCorrect = true;
                            executor.shutdownNow();
                            break;
                        } else {
                            long time = (System.currentTimeMillis() - start) / 1000;
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessThreeDigit + " | - Wrong - " + time + " seconds");
                            attempts++;
                        }
                    }
                    for (int itrFour = 0; itrFour < indexArrayList.size(); itrFour++) {
                        if (isCorrect) { break; }
                        ArrayList<Character> guessFourDigit = new ArrayList<>();
                        Character characterFour = index[itrFour];
                        guessFourDigit.add(characterOne);
                        guessFourDigit.add(characterTwo);
                        guessFourDigit.add(characterThree);
                        guessFourDigit.add(characterFour);
                        if (!isCorrect){
                            if (guessFourDigit.equals(this.arrayListPassword)) {
                                long time = (System.currentTimeMillis() - start) / 1000;
                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessFourDigit + " | - Correct - " + time + " seconds");
                                isCorrect = true;
                                executor.shutdownNow();
                                break;
                            } else {
                                long time = (System.currentTimeMillis() - start) / 1000;
                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessFourDigit + " | - Wrong - " + time + " seconds");
                                attempts++;
                            }
                        }
                        for (int itrFive = 0; itrFive < indexArrayList.size(); itrFive++) {
                            if (isCorrect) { break; }
                            ArrayList<Character> guessFiveDigit = new ArrayList<>();
                            Character characterFive = index[itrFive];
                            guessFiveDigit.add(characterOne);
                            guessFiveDigit.add(characterTwo);
                            guessFiveDigit.add(characterThree);
                            guessFiveDigit.add(characterFour);
                            guessFiveDigit.add(characterFive);
                            if (!isCorrect){
                                if (guessFiveDigit.equals(this.arrayListPassword)) {
                                    long time = (System.currentTimeMillis() - start) / 1000;
                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessFiveDigit + " | - Correct - " + time + " seconds");
                                    isCorrect = true;
                                    executor.shutdownNow();
                                    break;
                                } else {
                                    long time = (System.currentTimeMillis() - start) / 1000;
                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessFiveDigit + " | - Wrong - " + time + " seconds");
                                    attempts++;
                                }
                            }
                            for (int itrSix = 0; itrSix < indexArrayList.size(); itrSix++) {
                                if (isCorrect) { break; }
                                ArrayList<Character> guessSixDigit = new ArrayList<>();
                                Character characterSix = index[itrSix];
                                guessSixDigit.add(characterOne);
                                guessSixDigit.add(characterTwo);
                                guessSixDigit.add(characterThree);
                                guessSixDigit.add(characterFour);
                                guessSixDigit.add(characterFive);
                                guessSixDigit.add(characterSix);
                                if (!isCorrect){
                                    if (guessSixDigit.equals(this.arrayListPassword)) {
                                        long time = (System.currentTimeMillis() - start) / 1000;
                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessSixDigit + " | - Correct - " + time + " seconds");
                                        isCorrect = true;
                                        executor.shutdownNow();
                                        break;
                                    } else {
                                        long time = (System.currentTimeMillis() - start) / 1000;
                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessSixDigit + " | - Wrong - " + time + " seconds");
                                        attempts++;
                                    }
                                }
                                for (int itrSeven = 0; itrSeven < indexArrayList.size(); itrSeven++) {
                                    if (isCorrect) { break; }
                                    ArrayList<Character> guessSevenDigit = new ArrayList<>();
                                    Character characterSeven = index[itrSeven];
                                    guessSevenDigit.add(characterOne);
                                    guessSevenDigit.add(characterTwo);
                                    guessSevenDigit.add(characterThree);
                                    guessSevenDigit.add(characterFour);
                                    guessSevenDigit.add(characterFive);
                                    guessSevenDigit.add(characterSix);
                                    guessSevenDigit.add(characterSeven);
                                    if (!isCorrect){
                                        if (guessSevenDigit.equals(this.arrayListPassword)) {
                                            long time = (System.currentTimeMillis() - start) / 1000;
                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessSevenDigit + " | - Correct - " + time + " seconds");
                                            isCorrect = true;
                                            executor.shutdownNow();
                                            break;
                                        } else {
                                            long time = (System.currentTimeMillis() - start) / 1000;
                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessSevenDigit + " | - Wrong - " + time + " seconds");
                                            attempts++;
                                        }
                                    }
                                    for (int itrEight = 0; itrEight < indexArrayList.size(); itrEight++) {
                                        if (isCorrect) { break; }
                                        ArrayList<Character> guessEightDigit = new ArrayList<>();
                                        Character characterEight = index[itrEight];
                                        guessEightDigit.add(characterOne);
                                        guessEightDigit.add(characterTwo);
                                        guessEightDigit.add(characterThree);
                                        guessEightDigit.add(characterFour);
                                        guessEightDigit.add(characterFive);
                                        guessEightDigit.add(characterSix);
                                        guessEightDigit.add(characterSeven);
                                        guessEightDigit.add(characterEight);
                                        if (!isCorrect){
                                            if (guessEightDigit.equals(this.arrayListPassword)) {
                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessEightDigit + " | - Correct - " + time + " seconds");
                                                isCorrect = true;
                                                executor.shutdownNow();
                                                break;
                                            } else {
                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | " + guessEightDigit + " | - Wrong - " + time + " seconds");
                                                attempts++;
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void randCharPasswordGenerator() {
        long start = System.currentTimeMillis();
        boolean correctValue = false;
        long attempts = 1;
        long possibleAttempts = 1;
        if (size == 1) { possibleAttempts = index.length;} else if (size > 1) { for (int i = 0; i < size; i++) { possibleAttempts *= index.length; }}
        while(!correctValue) {
            ArrayList<Character> guess = new ArrayList<>();
            for(int j = 0; j < size; j++) {
                Character character= index[(int) (Math.random() * index.length)];
                guess.add(character);
            }
            if (guess.equals(this.arrayListPassword)) {
                long time = (System.currentTimeMillis() - start) / 1000;
                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | Possibilities: " + possibleAttempts + ": " + guess + " - Correct - " + time + " seconds");
                correctValue = true;
                executor.shutdownNow();
            } else {
                long time = (System.currentTimeMillis() - start) / 1000;
                    System.out.println(" Thread: " + Thread.currentThread().getName() +  " | Attempt: " + attempts + " | Possibilities: " + possibleAttempts + ": " + guess + " - Wrong - " + time + " seconds");
                    attempts++;
                }
        }
    }
    public void randCharListPasswordGenerator() {
        long start = System.currentTimeMillis();
        boolean correctValue = false;
        int attempts = 1;
        int wrongGuessAmount = 0;
        long possibleAttempts = 1;
        if (size == 1) { possibleAttempts = index.length; } else if (size > 1) { for (int i = 0; i < size; i++) { possibleAttempts *= index.length; }}
        ArrayList<ArrayList<Character>> wrongGuesses = new ArrayList<ArrayList<Character>>();
            while(!correctValue) {
                ArrayList<Character> guess = new ArrayList<>();
                for(int j = 0; j < size; j++) {
                    Character character= index[(int) (Math.random() * index.length)];
                    guess.add(character);
                }
                ArrayList<Character> wrongGuess = new ArrayList<>();
                boolean containsGuess = false;
                    for (int i = 0; i < wrongGuessAmount; i++) {
                        if (guess.equals(wrongGuesses.get(i))) {
                            containsGuess = true;
                            break;
                        }
                    }
                    if (!containsGuess) {
                        if (guess.equals(this.arrayListPassword)) {
                            long time = (System.currentTimeMillis() - start) / 1000;
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + attempts + " | Possibilities: " + possibleAttempts + ": " + guess + " - Correct - " + time + " seconds");
                            correctValue = true;
                            executor.shutdownNow();
                    } else {
                            long time = (System.currentTimeMillis() - start) / 1000;
                            wrongGuesses.add(guess);
                            System.out.println(" Thread: " + Thread.currentThread().getName() +  " | Attempt: " + attempts + " | Possibilities: " + possibleAttempts + ": " + guess + " - Wrong - " + time + " seconds");
                            attempts++;
                            wrongGuessAmount++;
                        }
                }
            }
    }
    // Password Pen Tester
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a test password: ");
        String password = input.nextLine();
        nThreads = 1; // Override to one thread for now. It will have third option which will have all methods race to be first and the executor will terminate if one is found.
        for (int i = 0; i < nThreads; i++) {
            Runnable task = new PasswordCracker(password);
            executor.execute(task);
        } executor.shutdown(); }
    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        boolean chosen = false;
        while(!chosen) {
            System.out.println("Please enter 1 for the random generator (quicker but uncertain) or 2 for the sequential generator (slower but certain): ");
            int choice = input.nextInt();
            if (choice == 1) {
                chosen = true;
                this.randCharPasswordGenerator();
            } else if (choice == 2) {
                chosen = true;
                this.seqCharPasswordGenerator();
            } else {
                chosen = false;
                System.out.println(choice + ": is not an option.");
            }
        }
    }
}