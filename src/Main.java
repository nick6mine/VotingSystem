import java.util.HashMap;
import java.util.Scanner;

public class Main
{

    private static int republicanTotal;
    private static int democratTotal;
    private static String candidateR;
    private static String candidateD;

    public static void main(String[] args)
    {
        HashMap<String, Integer> states = new HashMap<>();

        states.put("Alabama", 9);
        states.put("Alaska", 3);
        states.put("Arizona", 11);
        states.put("Arkansas", 6);
        states.put("California", 54);
        states.put("Colorado", 10);
        states.put("Connecticut", 7);
        states.put("Delaware", 3);
        states.put("District of Columbia", 3);
        states.put("Florida", 30);
        states.put("Georgia", 16);
        states.put("Hawaii", 4);
        states.put("Idaho", 4);
        states.put("Illinois", 19);
        states.put("Indiana", 11);
        states.put("Iowa", 6);
        states.put("Kansas", 6);
        states.put("Kentucky", 8);
        states.put("Louisiana", 8);
        states.put("Maine", 4);
        states.put("Maryland", 10);
        states.put("Massachusetts", 11);
        states.put("Michigan", 15);
        states.put("Mississippi", 6);
        states.put("Missouri", 10);
        states.put("Montana", 4);
        states.put("Minnesota", 10);
        states.put("Nebraska", 5);
        states.put("Nevada", 6);
        states.put("New Hampshire", 4);
        states.put("New Jersey", 14);
        states.put("New Mexico", 5);
        states.put("New York", 28);
        states.put("North Carolina", 16);
        states.put("North Dakota", 3);
        states.put("Ohio", 17);
        states.put("Oklahoma", 7);
        states.put("Oregon", 8);
        states.put("Pennsylvania", 19);
        states.put("Rhode Island", 4);
        states.put("South Carolina", 9);
        states.put("South Dakota", 3);
        states.put("Tennessee", 11);
        states.put("Texas", 40);
        states.put("Utah", 6);
        states.put("Vermont", 3);
        states.put("Virginia", 13);
        states.put("Washington", 12);
        states.put("West Virginia", 4);
        states.put("Wisconsin", 10);
        states.put("Wyoming", 3);

        getCandidate();
        vote(states, candidateR, candidateD);

    }

    public static void vote(HashMap<String, Integer> states, String candidateR, String candidateD)
    {
        Scanner scanner = new Scanner(System.in);

        for (String state : states.keySet())
        {
            System.out.println("Who won " + state + "? (Enter 'R' for " + candidateR + " or 'D' for " + candidateD + ")");
            String vote = scanner.nextLine();

            int electoralVotes = states.get(state);

            if (vote.equalsIgnoreCase("R"))
            {
                republicanTotal += electoralVotes;
            }
            else if (vote.equalsIgnoreCase("D"))
            {
                democratTotal += electoralVotes;
            }
            else
            {
                System.out.println("Invalid input, skipping " + state);
            }
        }

        // Output the total electoral votes
        System.out.println(candidateR + " total electoral votes: " + republicanTotal);
        System.out.println(candidateD + " total electoral votes: " + democratTotal);

        determineWinner(candidateR, candidateD);
    }


    public static void getCandidate()
    {
        Scanner rChoice = new Scanner(System.in);
        Scanner dChoice = new Scanner(System.in);

        System.out.println("Enter the name of the Republican candidate: ");
        candidateR = rChoice.nextLine();

        System.out.println("Enter the name of the Democratic candidate: ");
        candidateD = dChoice.nextLine();
    }


    public static void determineWinner(String candidateR, String candidateD)
    {
        if (republicanTotal >= 270)
        {
            System.out.println(candidateR + " wins with " + republicanTotal + " electoral votes!");
        }
        else if(democratTotal >= 270)
        {
            System.out.println(candidateD + " wins with " + democratTotal + " electoral votes!");
        }
        else if(democratTotal == republicanTotal)
        {
            System.out.println("It's a tie!");
        }
        else
        {
            System.out.println("No winner yet, continue counting.");
        }
    }
}