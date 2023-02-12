// Oliver Sigwarth
// Password Pen Tester: A Java program that test the strength of passwords using various methods.
// Created 2/6/2023
// Last modified 2/11/2023
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
    int passwordLengthCapacity = 20; // Override to 20 for now. To do: implement iterators to meet the typical 32 or 64 character password limit.
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
                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessOneDigit + " | - Correct - " + time + " seconds");
                    isCorrect = true;
                    executor.shutdownNow();
                    break outer;
                } else {
                    long time = (System.currentTimeMillis() - start) / 1000;
                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessOneDigit + " | - Wrong - " + time + " seconds");
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
                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessTwoDigit + " | - Correct - " + time + " seconds");
                        isCorrect = true;
                        executor.shutdownNow();
                        break outer;
                    } else {
                        long time = (System.currentTimeMillis() - start) / 1000;
                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessTwoDigit + " | - Wrong - " + time + " seconds");
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
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessThreeDigit + " | - Correct - " + time + " seconds");
                            isCorrect = true;
                            executor.shutdownNow();
                            break outer;
                        } else {
                            long time = (System.currentTimeMillis() - start) / 1000;
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessThreeDigit + " | - Wrong - " + time + " seconds");
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
                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessFourDigit + " | - Correct - " + time + " seconds");
                                isCorrect = true;
                                executor.shutdownNow();
                                break outer;
                            } else {
                                long time = (System.currentTimeMillis() - start) / 1000;
                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessFourDigit + " | - Wrong - " + time + " seconds");
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
                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessFiveDigit + " | - Correct - " + time + " seconds");
                                    isCorrect = true;
                                    executor.shutdownNow();
                                    break outer;
                                } else {
                                    long time = (System.currentTimeMillis() - start) / 1000;
                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessFiveDigit + " | - Wrong - " + time + " seconds");
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
                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessSixDigit + " | - Correct - " + time + " seconds");
                                        isCorrect = true;
                                        executor.shutdownNow();
                                        break outer;
                                    } else {
                                        long time = (System.currentTimeMillis() - start) / 1000;
                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessSixDigit + " | - Wrong - " + time + " seconds");
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
                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessSevenDigit + " | - Correct - " + time + " seconds");
                                            isCorrect = true;
                                            executor.shutdownNow();
                                            break outer;
                                        } else {
                                            long time = (System.currentTimeMillis() - start) / 1000;
                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessSevenDigit + " | - Wrong - " + time + " seconds");
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
                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessEightDigit + " | - Correct - " + time + " seconds");
                                                isCorrect = true;
                                                executor.shutdownNow();
                                                break outer;
                                            } else {
                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessEightDigit + " | - Wrong - " + time + " seconds");
                                                attempts++;
                                            }
                                        }
                                        for (int itrNine = 0; itrNine < indexArrayList.size(); itrNine++) {
                                            ArrayList<Character> guessNineDigit = new ArrayList<>();
                                            Character characterNine = index[itrNine];
                                            guessNineDigit.add(characterOne);
                                            guessNineDigit.add(characterTwo);
                                            guessNineDigit.add(characterThree);
                                            guessNineDigit.add(characterFour);
                                            guessNineDigit.add(characterFive);
                                            guessNineDigit.add(characterSix);
                                            guessNineDigit.add(characterSeven);
                                            guessNineDigit.add(characterEight);
                                            guessNineDigit.add(characterNine);
                                            if (!isCorrect){
                                                if (guessNineDigit.equals(this.arrayListPassword)) {
                                                    long time = (System.currentTimeMillis() - start) / 1000;
                                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessNineDigit + " | - Correct - " + time + " seconds");
                                                    isCorrect = true;
                                                    executor.shutdownNow();
                                                    break outer;
                                                } else {
                                                    long time = (System.currentTimeMillis() - start) / 1000;
                                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessNineDigit + " | - Wrong - " + time + " seconds");
                                                    attempts++;
                                                }
                                            }
                                            for (int itrTen = 0; itrTen < indexArrayList.size(); itrTen++) {
                                                ArrayList<Character> guessTenDigit = new ArrayList<>();
                                                Character characterTen = index[itrTen];
                                                guessTenDigit.add(characterOne);
                                                guessTenDigit.add(characterTwo);
                                                guessTenDigit.add(characterThree);
                                                guessTenDigit.add(characterFour);
                                                guessTenDigit.add(characterFive);
                                                guessTenDigit.add(characterSix);
                                                guessTenDigit.add(characterSeven);
                                                guessTenDigit.add(characterEight);
                                                guessTenDigit.add(characterNine);
                                                guessTenDigit.add(characterTen);
                                                if (!isCorrect){
                                                    if (guessTenDigit.equals(this.arrayListPassword)) {
                                                        long time = (System.currentTimeMillis() - start) / 1000;
                                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessTenDigit + " | - Correct - " + time + " seconds");
                                                        isCorrect = true;
                                                        executor.shutdownNow();
                                                        break outer;
                                                    } else {
                                                        long time = (System.currentTimeMillis() - start) / 1000;
                                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessTenDigit + " | - Wrong - " + time + " seconds");
                                                        attempts++;
                                                    }
                                                }
                                                for (int itrEleven = 0; itrEleven < indexArrayList.size(); itrEleven++) {
                                                    ArrayList<Character> guessElevenDigit = new ArrayList<>();
                                                    Character characterEleven = index[itrEleven];
                                                    guessElevenDigit.add(characterOne);
                                                    guessElevenDigit.add(characterTwo);
                                                    guessElevenDigit.add(characterThree);
                                                    guessElevenDigit.add(characterFour);
                                                    guessElevenDigit.add(characterFive);
                                                    guessElevenDigit.add(characterSix);
                                                    guessElevenDigit.add(characterSeven);
                                                    guessElevenDigit.add(characterEight);
                                                    guessElevenDigit.add(characterNine);
                                                    guessElevenDigit.add(characterTen);
                                                    guessElevenDigit.add(characterEleven);
                                                    if (!isCorrect){
                                                        if (guessElevenDigit.equals(this.arrayListPassword)) {
                                                            long time = (System.currentTimeMillis() - start) / 1000;
                                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessElevenDigit + " | - Correct - " + time + " seconds");
                                                            isCorrect = true;
                                                            executor.shutdownNow();
                                                            break outer;
                                                        } else {
                                                            long time = (System.currentTimeMillis() - start) / 1000;
                                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessElevenDigit + " | - Wrong - " + time + " seconds");
                                                            attempts++;
                                                        }
                                                    }
                                                    for (int itrTwelve = 0; itrTwelve < indexArrayList.size(); itrTwelve++) {
                                                        ArrayList<Character> guessTwelveDigit = new ArrayList<>();
                                                        Character characterTwelve = index[itrTwelve];
                                                        guessTwelveDigit.add(characterOne);
                                                        guessTwelveDigit.add(characterTwo);
                                                        guessTwelveDigit.add(characterThree);
                                                        guessTwelveDigit.add(characterFour);
                                                        guessTwelveDigit.add(characterFive);
                                                        guessTwelveDigit.add(characterSix);
                                                        guessTwelveDigit.add(characterSeven);
                                                        guessTwelveDigit.add(characterEight);
                                                        guessTwelveDigit.add(characterNine);
                                                        guessTwelveDigit.add(characterTen);
                                                        guessTwelveDigit.add(characterEleven);
                                                        guessTwelveDigit.add(characterTwelve);
                                                        if (!isCorrect){
                                                            if (guessTwelveDigit.equals(this.arrayListPassword)) {
                                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessTwelveDigit + " | - Correct - " + time + " seconds");
                                                                isCorrect = true;
                                                                executor.shutdownNow();
                                                                break outer;
                                                            } else {
                                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessTwelveDigit + " | - Wrong - " + time + " seconds");
                                                                attempts++;
                                                            }
                                                        }
                                                        for (int itrThirteen = 0; itrThirteen < indexArrayList.size(); itrThirteen++) {
                                                            ArrayList<Character> guessThirteenDigit = new ArrayList<>();
                                                            Character characterThirteen = index[itrThirteen];
                                                            guessThirteenDigit.add(characterOne);
                                                            guessThirteenDigit.add(characterTwo);
                                                            guessThirteenDigit.add(characterThree);
                                                            guessThirteenDigit.add(characterFour);
                                                            guessThirteenDigit.add(characterFive);
                                                            guessThirteenDigit.add(characterSix);
                                                            guessThirteenDigit.add(characterSeven);
                                                            guessThirteenDigit.add(characterEight);
                                                            guessThirteenDigit.add(characterNine);
                                                            guessThirteenDigit.add(characterTen);
                                                            guessThirteenDigit.add(characterEleven);
                                                            guessThirteenDigit.add(characterTwelve);
                                                            guessThirteenDigit.add(characterThirteen);
                                                            if (!isCorrect){
                                                                if (guessThirteenDigit.equals(this.arrayListPassword)) {
                                                                    long time = (System.currentTimeMillis() - start) / 1000;
                                                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessThirteenDigit + " | - Correct - " + time + " seconds");
                                                                    isCorrect = true;
                                                                    executor.shutdownNow();
                                                                    break outer;
                                                                } else {
                                                                    long time = (System.currentTimeMillis() - start) / 1000;
                                                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessThirteenDigit + " | - Wrong - " + time + " seconds");
                                                                    attempts++;
                                                                }
                                                            }
                                                            for (int itrFourteen = 0; itrFourteen < indexArrayList.size(); itrFourteen++) {
                                                                ArrayList<Character> guessFourteenDigit = new ArrayList<>();
                                                                Character characterFourteen = index[itrFourteen];
                                                                guessFourteenDigit.add(characterOne);
                                                                guessFourteenDigit.add(characterTwo);
                                                                guessFourteenDigit.add(characterThree);
                                                                guessFourteenDigit.add(characterFour);
                                                                guessFourteenDigit.add(characterFive);
                                                                guessFourteenDigit.add(characterSix);
                                                                guessFourteenDigit.add(characterSeven);
                                                                guessFourteenDigit.add(characterEight);
                                                                guessFourteenDigit.add(characterNine);
                                                                guessFourteenDigit.add(characterTen);
                                                                guessFourteenDigit.add(characterEleven);
                                                                guessFourteenDigit.add(characterTwelve);
                                                                guessFourteenDigit.add(characterThirteen);
                                                                guessFourteenDigit.add(characterFourteen);
                                                                if (!isCorrect){
                                                                    if (guessFourteenDigit.equals(this.arrayListPassword)) {
                                                                        long time = (System.currentTimeMillis() - start) / 1000;
                                                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessFourteenDigit + " | - Correct - " + time + " seconds");
                                                                        isCorrect = true;
                                                                        executor.shutdownNow();
                                                                        break outer;
                                                                    } else {
                                                                        long time = (System.currentTimeMillis() - start) / 1000;
                                                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessFourteenDigit + " | - Wrong - " + time + " seconds");
                                                                        attempts++;
                                                                    }
                                                                }
                                                                for (int itrFifteen = 0; itrFifteen < indexArrayList.size(); itrFifteen++) {
                                                                    ArrayList<Character> guessFifteenDigit = new ArrayList<>();
                                                                    Character characterFifteen = index[itrFifteen];
                                                                    guessFifteenDigit.add(characterOne);
                                                                    guessFifteenDigit.add(characterTwo);
                                                                    guessFifteenDigit.add(characterThree);
                                                                    guessFifteenDigit.add(characterFour);
                                                                    guessFifteenDigit.add(characterFive);
                                                                    guessFifteenDigit.add(characterSix);
                                                                    guessFifteenDigit.add(characterSeven);
                                                                    guessFifteenDigit.add(characterEight);
                                                                    guessFifteenDigit.add(characterNine);
                                                                    guessFifteenDigit.add(characterTen);
                                                                    guessFifteenDigit.add(characterEleven);
                                                                    guessFifteenDigit.add(characterTwelve);
                                                                    guessFifteenDigit.add(characterThirteen);
                                                                    guessFifteenDigit.add(characterFourteen);
                                                                    guessFifteenDigit.add(characterFifteen);
                                                                    if (!isCorrect){
                                                                        if (guessFifteenDigit.equals(this.arrayListPassword)) {
                                                                            long time = (System.currentTimeMillis() - start) / 1000;
                                                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessFifteenDigit + " | - Correct - " + time + " seconds");
                                                                            isCorrect = true;
                                                                            executor.shutdownNow();
                                                                            break outer;
                                                                        } else {
                                                                            long time = (System.currentTimeMillis() - start) / 1000;
                                                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessFifteenDigit + " | - Wrong - " + time + " seconds");
                                                                            attempts++;
                                                                        }
                                                                    }
                                                                    for (int itrSixteen = 0; itrSixteen < indexArrayList.size(); itrSixteen++) {
                                                                        ArrayList<Character> guessSixteenDigit = new ArrayList<>();
                                                                        Character characterSixteen = index[itrSixteen];
                                                                        guessSixteenDigit.add(characterOne);
                                                                        guessSixteenDigit.add(characterTwo);
                                                                        guessSixteenDigit.add(characterThree);
                                                                        guessSixteenDigit.add(characterFour);
                                                                        guessSixteenDigit.add(characterFive);
                                                                        guessSixteenDigit.add(characterSix);
                                                                        guessSixteenDigit.add(characterSeven);
                                                                        guessSixteenDigit.add(characterEight);
                                                                        guessSixteenDigit.add(characterNine);
                                                                        guessSixteenDigit.add(characterTen);
                                                                        guessSixteenDigit.add(characterEleven);
                                                                        guessSixteenDigit.add(characterTwelve);
                                                                        guessSixteenDigit.add(characterThirteen);
                                                                        guessSixteenDigit.add(characterFourteen);
                                                                        guessSixteenDigit.add(characterFifteen);
                                                                        guessSixteenDigit.add(characterSixteen);
                                                                        if (!isCorrect){
                                                                            if (guessSixteenDigit.equals(this.arrayListPassword)) {
                                                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessSixteenDigit + " | - Correct - " + time + " seconds");
                                                                                isCorrect = true;
                                                                                executor.shutdownNow();
                                                                                break outer;
                                                                            } else {
                                                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessSixteenDigit + " | - Wrong - " + time + " seconds");
                                                                                attempts++;
                                                                            }
                                                                        }
                                                                        for (int itrSeventeen = 0; itrSeventeen < indexArrayList.size(); itrSeventeen++) {
                                                                            ArrayList<Character> guessSeventeenDigit = new ArrayList<>();
                                                                            Character characterSeventeen = index[itrSeventeen];
                                                                            guessSeventeenDigit.add(characterOne);
                                                                            guessSeventeenDigit.add(characterTwo);
                                                                            guessSeventeenDigit.add(characterThree);
                                                                            guessSeventeenDigit.add(characterFour);
                                                                            guessSeventeenDigit.add(characterFive);
                                                                            guessSeventeenDigit.add(characterSix);
                                                                            guessSeventeenDigit.add(characterSeven);
                                                                            guessSeventeenDigit.add(characterEight);
                                                                            guessSeventeenDigit.add(characterNine);
                                                                            guessSeventeenDigit.add(characterTen);
                                                                            guessSeventeenDigit.add(characterEleven);
                                                                            guessSeventeenDigit.add(characterTwelve);
                                                                            guessSeventeenDigit.add(characterThirteen);
                                                                            guessSeventeenDigit.add(characterFourteen);
                                                                            guessSeventeenDigit.add(characterFifteen);
                                                                            guessSeventeenDigit.add(characterSixteen);
                                                                            guessSeventeenDigit.add(characterSeventeen);
                                                                            if (!isCorrect){
                                                                                if (guessSeventeenDigit.equals(this.arrayListPassword)) {
                                                                                    long time = (System.currentTimeMillis() - start) / 1000;
                                                                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessSeventeenDigit + " | - Correct - " + time + " seconds");
                                                                                    isCorrect = true;
                                                                                    executor.shutdownNow();
                                                                                    break outer;
                                                                                } else {
                                                                                    long time = (System.currentTimeMillis() - start) / 1000;
                                                                                    System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessSeventeenDigit + " | - Wrong - " + time + " seconds");
                                                                                    attempts++;
                                                                                }
                                                                            }
                                                                            for (int itrEighteen = 0; itrEighteen < indexArrayList.size(); itrEighteen++) {
                                                                                ArrayList<Character> guessEighteenDigit = new ArrayList<>();
                                                                                Character characterEighteen = index[itrEighteen];
                                                                                guessEighteenDigit.add(characterOne);
                                                                                guessEighteenDigit.add(characterTwo);
                                                                                guessEighteenDigit.add(characterThree);
                                                                                guessEighteenDigit.add(characterFour);
                                                                                guessEighteenDigit.add(characterFive);
                                                                                guessEighteenDigit.add(characterSix);
                                                                                guessEighteenDigit.add(characterSeven);
                                                                                guessEighteenDigit.add(characterEight);
                                                                                guessEighteenDigit.add(characterNine);
                                                                                guessEighteenDigit.add(characterTen);
                                                                                guessEighteenDigit.add(characterEleven);
                                                                                guessEighteenDigit.add(characterTwelve);
                                                                                guessEighteenDigit.add(characterThirteen);
                                                                                guessEighteenDigit.add(characterFourteen);
                                                                                guessEighteenDigit.add(characterFifteen);
                                                                                guessEighteenDigit.add(characterSixteen);
                                                                                guessEighteenDigit.add(characterSeventeen);
                                                                                guessEighteenDigit.add(characterEighteen);
                                                                                if (!isCorrect){
                                                                                    if (guessEighteenDigit.equals(this.arrayListPassword)) {
                                                                                        long time = (System.currentTimeMillis() - start) / 1000;
                                                                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessEighteenDigit + " | - Correct - " + time + " seconds");
                                                                                        isCorrect = true;
                                                                                        executor.shutdownNow();
                                                                                        break outer;
                                                                                    } else {
                                                                                        long time = (System.currentTimeMillis() - start) / 1000;
                                                                                        System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessEighteenDigit + " | - Wrong - " + time + " seconds");
                                                                                        attempts++;
                                                                                    }
                                                                                }
                                                                                for (int itrNineteen = 0; itrNineteen < indexArrayList.size(); itrNineteen++) {
                                                                                    ArrayList<Character> guessNineteenDigit = new ArrayList<>();
                                                                                    Character characterNineteen = index[itrNineteen];
                                                                                    guessNineteenDigit.add(characterOne);
                                                                                    guessNineteenDigit.add(characterTwo);
                                                                                    guessNineteenDigit.add(characterThree);
                                                                                    guessNineteenDigit.add(characterFour);
                                                                                    guessNineteenDigit.add(characterFive);
                                                                                    guessNineteenDigit.add(characterSix);
                                                                                    guessNineteenDigit.add(characterSeven);
                                                                                    guessNineteenDigit.add(characterEight);
                                                                                    guessNineteenDigit.add(characterNine);
                                                                                    guessNineteenDigit.add(characterTen);
                                                                                    guessNineteenDigit.add(characterEleven);
                                                                                    guessNineteenDigit.add(characterTwelve);
                                                                                    guessNineteenDigit.add(characterThirteen);
                                                                                    guessNineteenDigit.add(characterFourteen);
                                                                                    guessNineteenDigit.add(characterFifteen);
                                                                                    guessNineteenDigit.add(characterSixteen);
                                                                                    guessNineteenDigit.add(characterSeventeen);
                                                                                    guessNineteenDigit.add(characterEighteen);
                                                                                    guessNineteenDigit.add(characterNineteen);
                                                                                    if (!isCorrect){
                                                                                        if (guessNineteenDigit.equals(this.arrayListPassword)) {
                                                                                            long time = (System.currentTimeMillis() - start) / 1000;
                                                                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessNineteenDigit + " | - Correct - " + time + " seconds");
                                                                                            isCorrect = true;
                                                                                            executor.shutdownNow();
                                                                                            break outer;
                                                                                        } else {
                                                                                            long time = (System.currentTimeMillis() - start) / 1000;
                                                                                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessNineteenDigit + " | - Wrong - " + time + " seconds");
                                                                                            attempts++;
                                                                                        }
                                                                                    }
                                                                                    for (int itrTwenty = 0; itrTwenty < indexArrayList.size(); itrTwenty++) {
                                                                                        ArrayList<Character> guessTwentyDigit = new ArrayList<>();
                                                                                        Character characterTwenty = index[itrTwenty];
                                                                                        guessTwentyDigit.add(characterOne);
                                                                                        guessTwentyDigit.add(characterTwo);
                                                                                        guessTwentyDigit.add(characterThree);
                                                                                        guessTwentyDigit.add(characterFour);
                                                                                        guessTwentyDigit.add(characterFive);
                                                                                        guessTwentyDigit.add(characterSix);
                                                                                        guessTwentyDigit.add(characterSeven);
                                                                                        guessTwentyDigit.add(characterEight);
                                                                                        guessTwentyDigit.add(characterNine);
                                                                                        guessTwentyDigit.add(characterTen);
                                                                                        guessTwentyDigit.add(characterEleven);
                                                                                        guessTwentyDigit.add(characterTwelve);
                                                                                        guessTwentyDigit.add(characterThirteen);
                                                                                        guessTwentyDigit.add(characterFourteen);
                                                                                        guessTwentyDigit.add(characterFifteen);
                                                                                        guessTwentyDigit.add(characterSixteen);
                                                                                        guessTwentyDigit.add(characterSeventeen);
                                                                                        guessTwentyDigit.add(characterEighteen);
                                                                                        guessTwentyDigit.add(characterNineteen);
                                                                                        guessTwentyDigit.add(characterTwenty);
                                                                                        if (!isCorrect){
                                                                                            if (guessTwentyDigit.equals(this.arrayListPassword)) {
                                                                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessTwentyDigit + " | - Correct - " + time + " seconds");
                                                                                                isCorrect = true;
                                                                                                executor.shutdownNow();
                                                                                                break outer;
                                                                                            } else {
                                                                                                long time = (System.currentTimeMillis() - start) / 1000;
                                                                                                System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | " + guessTwentyDigit + " | - Wrong - " + time + " seconds");
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
    }
    //Possibilities should only show if a size is set.
    //Possibilities larger than type long should be a BigNumber object.
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
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | Possibilities: " + numberFormat.format(possibleAttempts) + " | " + guess + " - Correct - " + time + " seconds");
                            correctValue = true;
                            executor.shutdownNow();
                    } else {
                            long time = (System.currentTimeMillis() - start) / 1000;
                            wrongGuesses.add(guess);
                            System.out.println(" Thread: " + Thread.currentThread().getName() + " | Unique Attempt: " + numberFormat.format(attempts) + " | Possibilities: " + numberFormat.format(possibleAttempts) + " | " + guess + " - Wrong - " + time + " seconds");
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