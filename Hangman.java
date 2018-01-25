//import acm.util.*
import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class Hangman {

    public static class HangmanLexicon {
        public int getWordCount() {
            return 10;
        }
         // Returns the word at the specified index.
        public String getWord(int index) {
            switch (index) {
                case 0:
                    return "BUOY";
                case 1:
                    return "COMPUTER";
                case 2:
                    return "CONNOISSEUR";
                case 3:
                    return "DEHYDRATE";
                case 4:
                    return "FUZZY";
                case 5:
                    return "HUBBUB";
                case 6:
                    return "KEYHOLE";
                case 7:
                    return "QUAGMIRE";
                case 8:
                    return "SLITHER";
                case 9:
                    return "ZIRCON";
                default:
                    return  "";
                    //throw new ErrorException("getWord: Illegal index");
            }
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        HangmanLexicon hangmanLexicon = new HangmanLexicon();
        int cnt = hangmanLexicon.getWordCount();
        Random random = new Random();
        int index = random.nextInt(cnt);
        String text = hangmanLexicon.getWord(index);
        System.out.println(text);  //comment this later
        int size = text.length();
        String temp = new String(new char[size]).replace('\0', '-');
        int guessesLeft = 8,correct = 0;
        System.out.println("The word now looks like this: " + temp);
        System.out.println("You have "+ guessesLeft+" guesses left");
        System.out.println("Your guess:   ");
        while(guessesLeft>0 || temp.equals(text)){
            char guess = s.next().charAt(0);
            guess = Character.toUpperCase(guess);
            System.out.println(guess);
            if (text.indexOf(guess)==-1){
                System.out.println("There are no "+guess+"'s in the word");
                guessesLeft -= 1;
                if(guessesLeft==0) {
                    System.out.println("You are completely hung");
                    return;
                }
                System.out.println("You have "+ guessesLeft+" guesses left");
            }
            else {
                if(temp.indexOf(guess)==-1) {
                    System.out.println("That guess is correct!");
                    for (int j = 0; j < size; j++) {
                        if (text.charAt(j) == guess) {
                            char[] charArray = temp.toCharArray();
                            charArray[j] = guess;
                            temp = new String(charArray);
                            correct++;
                        }
                    }
                    if (correct == size) {
                        System.out.println("You guessed the word:  " + temp);
                        return;
                    }
                    System.out.println("Your word now looks like this:  " + temp);
                }
            }
        }
    }
}