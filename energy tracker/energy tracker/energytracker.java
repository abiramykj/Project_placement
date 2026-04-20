import java.util.*;
import java.io.*;
import java.text.*;

public class energytracker{
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter sleep hours:");
        int sleep=sc.nextInt();

        System.out.println("Enter water intake (liters):");
        double water=sc.nextDouble();

        System.out.println("Did you exercise? (yes/no):");
        String ex=sc.next();

        sc.nextLine();
        System.out.println("Enter mood:");
        String mood=sc.nextLine();

        int score=0;

        // sleep score
        if(sleep<5) score+=20;
        else if(sleep<=7) score+=50;
        else score+=80;

        // water score
        if(water>=2) score+=10;
        else score+=5;

        // exercise score
        if(ex.equalsIgnoreCase("yes")) score+=10;

        // mood score
        if(mood.toLowerCase().contains("happy")) score+=10;
        else if(mood.toLowerCase().contains("sad")) score-=10;

        // limit score
        if(score<0) score=0;
        if(score>100) score=100;

        // productivity level
        String level;
        if(score<40) level="Low";
        else if(score<70) level="Medium";
        else level="High";

        // output
        System.out.println("\nEnergy Score: "+score);
        System.out.println("Productivity: "+level);

        if(level.equals("Low"))
            System.out.println("Suggestion: Rest or do light work");
        else if(level.equals("Medium"))
            System.out.println("Suggestion: Do regular tasks");
        else
            System.out.println("Suggestion: Do important work!");

        // save to file
        FileWriter fw=new FileWriter("energy_log.txt",true);

        String time=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());

        fw.write(time+" | Sleep:"+sleep+" | Water:"+water+" | Mood:"+mood+" | Score:"+score+"\n");
        fw.close();

        System.out.println("Data saved to file!");
    }
}