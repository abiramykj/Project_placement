import java.util.*;
interface SeriesSolver{
    boolean check(int a[]);
    int next(int a[]);
}
class APSeries implements SeriesSolver{

    public boolean check(int a[]){
        int d=a[1]-a[0];
        for(int i=0;i<a.length-1;i++){
            if(a[i+1]-a[i]!=d)
                return false;
        }
        return true;
    }
    public int next(int a[]){
        int d=a[1]-a[0];
        return a[a.length-1]+d;
    }
}
class GPSeries implements SeriesSolver{

    public boolean check(int a[]){
        if(a[0]==0) return false;

        int r=a[1]/a[0];
        for(int i=0;i<a.length-1;i++){
            if(a[i]==0 || a[i+1]/a[i]!=r)
                return false;
        }
        return true;
    }

    public int next(int a[]){
        int r=a[1]/a[0];
        return a[a.length-1]*r;
    }
}
class SquareSeries implements SeriesSolver{

    public boolean check(int a[]){
        for(int i=0;i<a.length;i++){
            int x=(int)Math.sqrt(a[i]);
            if(x*x!=a[i])
                return false;
        }
        return true;
    }

    public int next(int a[]){
        int x=(int)Math.sqrt(a[a.length-1])+1;
        return x*x;
    }
}
public class num_sequences{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size:");
        int n=sc.nextInt();

        int a[]=new int[n];

        System.out.println("Enter elements:");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        SeriesSolver ap=new APSeries();
        SeriesSolver gp=new GPSeries();
        SeriesSolver sq=new SquareSeries();
        if(ap.check(a)){
            System.out.println("Pattern: AP");
            System.out.println("Next: "+ap.next(a));
        }
        else if(gp.check(a)){
            System.out.println("Pattern: GP");
            System.out.println("Next: "+gp.next(a));
        }
        else if(sq.check(a)){
            System.out.println("Pattern: Squares");
            System.out.println("Next: "+sq.next(a));
        }
        else{
            System.out.println("Pattern not identified");
        }
    }
}