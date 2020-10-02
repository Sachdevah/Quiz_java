
/***********************************************************************************************************************************************************************************************************
Author:Hardik Sachdeva
Suggestion 1: “Impossible” Answer Quiz program
In this programme, we have 3 questions of multiple-choice answer where if we choose the correct option then it will move to the next question and also give a random score for that question between 1-10 but if the answer will be wrong then it will repeat the question. We can also skip the question if we type “SKIP” in answer after that it will confirm that are you sure you want to quit or not for that enter “y” for yes or “n” for no. In the end, it will also provide your final score which will be similar to the maximum score obtained in the random scores.
***********************************************************************************************************************************************************************************************************/

import java.util.*;
import java.io.*;

class quiz {
    public static void main(String a[]) throws IOException {
        BufferedReader FileI = new BufferedReader(new FileReader("InputFile.txt")); // reads the text in InputFile.txt
        String e = FileI.readLine();
        print(e + "\n\n"); // prints the instructions
        FileI.close();
        answer a1 = new answer();
        String[] saveans = new String[3]; // array to store answers
        saveans[0] = a1.giveans1();
        saveans[1] = a1.giveans2();
        saveans[2] = a1.giveans3();
        int score[] = new int[3]; // array to store marks after every question
        ques1(saveans[0]);
        score[0] = getRandomNumber();
        print("the score is:" + score[0]);
        ques2(saveans[1]);
        score[1] = getRandomNumber();
        print("the score is:" + score[1]);
        ques3(saveans[2]);
        score[2] = getRandomNumber();
        print("the score is:" + score[2]);
        sort(score); // sorting the array score[] in accending order
        PrintWriter FileOut = new PrintWriter(new FileWriter("Feedback.txt")); // create a file Feedback.txt to store
                                                                               // the feedback of user
        FileOut.println(input("Please leave a Feedback to improve the program or press ENTER")); // stores the feedback
        FileOut.close();
        System.exit(0);
    }

    public static String ques1(String first) // prints the question 1 and ask for the answer
    {

        boolean run = true;
        String ans1 = "";
        while (run) {
            Scanner scan1 = new Scanner(System.in);
            print("which day is observed as the world standards day?");
            print("A: 26 October , B: 14 October , C: 21 February "); // correct answer is (b)
            ans1 = scan1.nextLine();

            if (ans1.equals(first) || ans1.equals("B") || ans1.equals("b")) {

                print("Correct Answer!");
                run = false;
            } else if (ans1.equals("SKIP")) // type "SKIP" to get an option to skip the question
            {
                boolean runq1 = true;
                while (runq1) {
                    print("are you sure you want to skip this question(y/n)?");
                    Scanner quit = new Scanner(System.in);
                    String quitans = quit.nextLine();
                    if (quitans.equals("y") || quitans.equals("Y")) // type "y" to skip or anything to repeat the
                                                                    // question
                    {
                        run = false;
                        break;
                    } else {
                        break;
                    }
                }
            } else {
                print("wrong answer!please try again.");
                run = true;
            }
        }

        return ans1;

    }

    public static String ques2(String second) // prints the question 2 and ask for the answer
    {
        boolean run1 = true;
        String ans2 = "";
        while (run1) {
            Scanner scan2 = new Scanner(System.in);
            print("Which of these scientists does not have a chemical element on the periodic table named after him?");
            print("A: Albert Einstein, B:  Alfred Nobel, C: Thomas Edison "); // correct answer is (c)
            ans2 = scan2.nextLine();

            if (ans2.equals(second) || ans2.equals("C") || ans2.equals("c")) {

                print("Correct Answer!");
                run1 = false;
            } else if (ans2.equals("SKIP")) // type "SKIP" to get an option to skip the question
            {
                boolean runq2 = true;
                while (runq2) {
                    print("are you sure you want to skip this question(y/n)?");
                    Scanner quit = new Scanner(System.in);
                    String quitans = quit.nextLine();
                    if (quitans.equals("y") || quitans.equals("Y")) // type "y" to skip or anything to repeat the
                                                                    // question
                    {
                        run1 = false;
                        break;
                    } else {
                        break;
                    }
                }
            }

            else {
                print("wrong answer!please try again.");
                run1 = true;
            }
        }

        return ans2;
    }

    public static String ques3(String third) // prints the question 3 and ask for the answer
    {
        boolean run2 = true;
        String ans3 = "";
        while (run2) {
            Scanner scan3 = new Scanner(System.in);
            print("Which insect shorted out an early supercomputer and inspired the term computer bug?");
            print("A: Moth , B: Roach , C: Fly"); // correct answer is (a)
            ans3 = scan3.nextLine();
            if (ans3.equals(third) || ans3.equals("A") || ans3.equals("a")) {
                print("Correct Answer!");
                run2 = false;
            } else if (ans3.equals("SKIP")) // type "SKIP" to get an option to skip the question
            {
                boolean runq3 = true;
                while (runq3) {
                    print("are you sure you want to skip this question(y/n)?");
                    Scanner quit = new Scanner(System.in);
                    String quitans = quit.nextLine();
                    if (quitans.equals("y") || quitans.equals("Y")) // type "y" to skip or anything to repeat the
                                                                    // question
                    {
                        run2 = false;
                        break;
                    } else {
                        break;
                    }
                }
            }

            else {
                print("wrong answer!please try again.");
                run2 = true;
            }
        }
        return ans3;
    }

    public static void sort(int[] a) // sort the array score[] and provides the maximum score
    {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        print("your final score is:" + a[2]);
    }

    public static void print(String message) // simple print statement
    {
        System.out.println(message);
    }

    public static int getRandomNumber() // give random scores(1-10) after every question
    {
        Random random = new Random();
        int x = random.nextInt(10) + 1;
        return x;
    }

    public static String input(String q) // ask for an input
    {
        Scanner s = new Scanner(System.in);
        print(q);
        return (s.nextLine()); // return user input
    }
}

class answer // this class provides the correct answers of the given questions to our main
             // class
{
    private String correct1 = "14 October";
    private String correct2 = "Thomas Edison";
    private String correct3 = "Moth";

    public String giveans1() {
        return correct1;
    }

    public String giveans2() {
        return correct2;
    }

    public String giveans3() {
        return correct3;
    }
}