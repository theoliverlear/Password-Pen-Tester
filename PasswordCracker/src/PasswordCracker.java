// Oliver Sigwarth
// Password Pen Tester: A Java program that test the strength of passwords using various methods.
// Created 2/6/2023
// Last modified 2/9/2023
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.NumberFormat;
public class PasswordCracker implements Runnable {
    static int nThreads = Runtime.getRuntime().availableProcessors() / 2;
    static ExecutorService executor = Executors.newFixedThreadPool(nThreads);
    static long nMemory = Runtime.getRuntime().freeMemory();
    static long nMaxMemory = Runtime.getRuntime().maxMemory();
    String password = "";
    char[] arrayPassword;
    char[] index = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0','1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', ',', '.', '\\', '/', '<', '>', '~', '!', '@', '#', '$', '%', '&', '&', '*', '(', ')', '-', '_', '=', '+', '[', ']', '{', '}', '?', '\'', '"', '|'};
    ArrayList<Character> arrayListPassword = new ArrayList<>();
    int passwordLengthCapacity = 8; // Override to 8 for now. To do: implement iterators to meet the typical 32 or 64 character password limit.
    public PasswordCracker(String password) {
        this.password = password;
        arrayPassword = password.toCharArray();
        for (Character character : arrayPassword) { arrayListPassword.add(character); }
    }
    //To do: make a sequence method that takes a length argument and uses logic flow of original but breaks its (possibly number based) label depending on the argument.
    public void seqCharPasswordGenerator() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);
        long start = System.currentTimeMillis();
        boolean correctValue = false;
        long attempts = 1;
        ArrayList<Character> indexArrayList = new ArrayList<>();
        outer: for (int i = 0; i < index.length; i++) { indexArrayList.add(index[i]);}
        boolean isCorrect = false;
        // To get percentage have one equation of time over attempts to get time per attempt. Then get total time est by multiplying it by the possibilities. Then the percentage is the attempts over possibilities.
        outer: for (int itrOne = 0; itrOne < indexArrayList.size(); itrOne++) {
            ArrayList<Character> guessOneDigit = new ArrayList<>();
            Character characterOne = index[itrOne];
            guessOneDigit.add(characterOne);
            if (!isCorrect) {
                if (guessOneDigit.equals(this.arrayListPassword)) {
                    long time = (System.currentTimeMillis() - start) / 1000;
                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessOneDigit + " | - Correct - " + time + " seconds");
                    isCorrect = true;
                    executor.shutdownNow();
                    break outer;
                } else {
                    long time = (System.currentTimeMillis() - start) / 1000;
                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessOneDigit + " | - Wrong - " + time + " seconds");
                    attempts++;
                }
            }
            for (int itrTwo = 0; itrTwo < indexArrayList.size(); itrTwo++) {
                ArrayList<Character> guessTwoDigit = new ArrayList<>();
                Character characterTwo = index[itrTwo];
                guessTwoDigit.add(characterOne);
                guessTwoDigit.add(characterTwo);
                if (!isCorrect){
                    if (guessTwoDigit.equals(this.arrayListPassword)) {
                        long time = (System.currentTimeMillis() - start) / 1000;
                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessTwoDigit + " | - Correct - " + time + " seconds");
                        isCorrect = true;
                        executor.shutdownNow();
                        break outer;
                    } else {
                        long time = (System.currentTimeMillis() - start) / 1000;
                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessTwoDigit + " | - Wrong - " + time + " seconds");
                        attempts++;
                    }
                }
                for (int itrThree = 0; itrThree < indexArrayList.size(); itrThree++) {
                    ArrayList<Character> guessThreeDigit = new ArrayList<>();
                    Character characterThree = index[itrThree];
                    guessThreeDigit.add(characterOne);
                    guessThreeDigit.add(characterTwo);
                    guessThreeDigit.add(characterThree);
                    if (!isCorrect) {
                        if (guessThreeDigit.equals(this.arrayListPassword)) {
                            long time = (System.currentTimeMillis() - start) / 1000;
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessThreeDigit + " | - Correct - " + time + " seconds");
                            isCorrect = true;
                            executor.shutdownNow();
                            break outer;
                        } else {
                            long time = (System.currentTimeMillis() - start) / 1000;
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessThreeDigit + " | - Wrong - " + time + " seconds");
                            attempts++;
                        }
                    }
                    for (int itrFour = 0; itrFour < indexArrayList.size(); itrFour++) {
                        ArrayList<Character> guessFourDigit = new ArrayList<>();
                        Character characterFour = index[itrFour];
                        guessFourDigit.add(characterOne);
                        guessFourDigit.add(characterTwo);
                        guessFourDigit.add(characterThree);
                        guessFourDigit.add(characterFour);
                        if (!isCorrect){
                            if (guessFourDigit.equals(this.arrayListPassword)) {
                                long time = (System.currentTimeMillis() - start) / 1000;
                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessFourDigit + " | - Correct - " + time + " seconds");
                                isCorrect = true;
                                executor.shutdownNow();
                                break outer;
                            } else {
                                long time = (System.currentTimeMillis() - start) / 1000;
                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessFourDigit + " | - Wrong - " + time + " seconds");
                                attempts++;
                            }
                        }
                        for (int itrFive = 0; itrFive < indexArrayList.size(); itrFive++) {
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
                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessFiveDigit + " | - Correct - " + time + " seconds");
                                    isCorrect = true;
                                    executor.shutdownNow();
                                    break outer;
                                } else {
                                    long time = (System.currentTimeMillis() - start) / 1000;
                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessFiveDigit + " | - Wrong - " + time + " seconds");
                                    attempts++;
                                }
                            }
                            for (int itrSix = 0; itrSix < indexArrayList.size(); itrSix++) {
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
                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessSixDigit + " | - Correct - " + time + " seconds");
                                        isCorrect = true;
                                        executor.shutdownNow();
                                        break outer;
                                    } else {
                                        long time = (System.currentTimeMillis() - start) / 1000;
                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessSixDigit + " | - Wrong - " + time + " seconds");
                                        attempts++;
                                    }
                                }
                                for (int itrSeven = 0; itrSeven < indexArrayList.size(); itrSeven++) {
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
                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessSevenDigit + " | - Correct - " + time + " seconds");
                                            isCorrect = true;
                                            executor.shutdownNow();
                                            break outer;
                                        } else {
                                            long time = (System.currentTimeMillis() - start) / 1000;
                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessSevenDigit + " | - Wrong - " + time + " seconds");
                                            attempts++;
                                        }
                                    }
                                    for (int itrEight = 0; itrEight < indexArrayList.size(); itrEight++) {
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
                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessEightDigit + " | - Correct - " + time + " seconds");
                                                isCorrect = true;
                                                executor.shutdownNow();
                                                break outer;
                                            } else {
                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guessEightDigit + " | - Wrong - " + time + " seconds");
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
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);
        long start = System.currentTimeMillis();
        boolean correctValue = false;
        long attempts = 1;
        long possibleAttempts = 1;
        if (arrayListPassword.size() == 1) { possibleAttempts = index.length; } else if (arrayListPassword.size() > 1) { for (int i = 0; i < arrayListPassword.size(); i++) { possibleAttempts *= index.length; }}
        while(!correctValue) {
            ArrayList<Character> guess = new ArrayList<>();
            for(int j = 0; j < arrayListPassword.size(); j++) { guess.add(index[(int) (Math.random() * index.length)]); }
            if (guess.equals(this.arrayListPassword)) {
                long time = (System.currentTimeMillis() - start) / 1000;
                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | Possibilities: " + numberFormat.format(possibleAttempts) + " | " + guess + " - Correct - " + time + " seconds");
                correctValue = true;
                executor.shutdownNow();
            } else {
                long time = (System.currentTimeMillis() - start) / 1000;
                    System.out.println(" Thread: " + Thread.currentThread().getName() +  " | Attempt: " + numberFormat.format(attempts) + " | Possibilities: " + numberFormat.format(possibleAttempts) + " | " + guess + " - Wrong - " + time + " seconds");
                    attempts++;
                }
        }
    }
    public void randCharLenPasswordGenerator() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);
        long start = System.currentTimeMillis();
        boolean correctValue = false;
        long attempts = 1;
        long possibleAttempts = 1;
        while(!correctValue) {
            ArrayList<Character> guess = new ArrayList<>();
            int randSize = (int) (Math.random() * passwordLengthCapacity);
            if (randSize == 0) { randSize++; }
            if (randSize == 1) { possibleAttempts = index.length; } else if (randSize > 1) { for (int i = 0; i < randSize; i++) { possibleAttempts *= index.length; }}
            for(int j = 0; j < randSize; j++) { guess.add(index[(int) (Math.random() * index.length)]); }
            if (guess.equals(this.arrayListPassword)) {
                long time = (System.currentTimeMillis() - start) / 1000;
                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guess + " - Correct - " + time + " seconds");
                correctValue = true;
                executor.shutdownNow();
            } else {
                long time = (System.currentTimeMillis() - start) / 1000;
                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | " + guess + " - Wrong - " + time + " seconds");
                attempts++;
            }
        }
    }
    public void randCharListPasswordGenerator() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);
        long start = System.currentTimeMillis();
        boolean correctValue = false;
        long attempts = 1;
        long wrongGuessAmount = 0;
        long possibleAttempts = 1;
        if (arrayListPassword.size() == 1) { possibleAttempts = index.length; } else if (arrayListPassword.size() > 1) { for (int i = 0; i < arrayListPassword.size(); i++) { possibleAttempts *= index.length; }}
        ArrayList<ArrayList<Character>> wrongGuesses = new ArrayList<>();
            while(!correctValue) {
                ArrayList<Character> guess = new ArrayList<>();
                for(int j = 0; j < arrayListPassword.size(); j++) { guess.add(index[(int) (Math.random() * index.length)]); }
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
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | Possibilities: " + numberFormat.format(possibleAttempts) + " | " + guess + " - Correct - " + time + " seconds");
                            correctValue = true;
                            executor.shutdownNow();
                    } else {
                            long time = (System.currentTimeMillis() - start) / 1000;
                            wrongGuesses.add(guess);
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Attempt: " + numberFormat.format(attempts) + " | Possibilities: " + numberFormat.format(possibleAttempts) + " | " + guess + " - Wrong - " + time + " seconds");
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
        nThreads = 1; // Override to one thread for now. To do: It will have third option which will have all methods race to be first and the executor will terminate if one is found.
        for (int i = 0; i < nThreads; i++) {
            Runnable task = new PasswordCracker(password);
            executor.execute(task);
        } executor.shutdown(); }
    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        boolean chosen = false;
        while(!chosen) {
            System.out.println("Please enter 1 for the random generator (quicker but uncertain) without a set size. Please enter 2 to run the random generator with a set size. \nPlease enter or 3 for the sequential generator (slower but certain) without a set size. Please enter 4 to run the sequential generator with a set size.");
            int choice = input.nextInt();
            if (choice == 1) {
                chosen = true;
                this.randCharLenPasswordGenerator();
            } else if (choice == 2) {
                chosen = true;
                this.randCharPasswordGenerator();
            } else if (choice == 3) {
                chosen = true;
                this.seqCharPasswordGenerator();
            } else if (choice == 4) {
                chosen = true;
                System.out.println("Functionality is not yet implemented.");
            } else {
                chosen = false;
                System.out.println(choice + ": is not an option.");
            }
        }
    }
}