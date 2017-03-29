
import java.io.IOException;


/**
 *
 * 
 * <h1>Main file of Question 3</h1>
 * <p>Finds 'k' happiest and 'k' most compatible couple using inheritance
 * @author Puja Kumari
 */
public class ques3 {
    /**
     * Main method which gives most happy and most compatible couple
     * @param args List of arguments
     * <p>1st input : boy.txt
     * <p>2nd input : girl.txt
     * <p>3rd input : essential.txt
     * <p>4th input : luxury.txt
     * <p>5th input : utility.txt
     * <p>6th input : k
     * @throws IOException Gives IO Exception when arguments are wrong
     */
    public static void main(String args[]) throws IOException {
    
        int k=Integer.parseInt(args[5]),j,lo=0;
        int[] commit = new int[1000];
        couple[] c = new couple[500];
        girls[] g = new girls [1000];
        boys[] b = new boys [1000];
        gifts gf1[] = new luxury_gifts[1000];
        gifts[] u = new utility_gifts [100];
        gifts[] e = new essential_gift [100];
        input in = new input(args,g,b, (utility_gifts[]) u, (luxury_gifts[]) gf1, (essential_gift[]) e,commit,c);
        
        //to find happiness of the couple
        lo=in.makelist(c, g, b, commit);
        //sort according to happiness
        in.sorth(c,lo);
        System.out.println(k+" "+" most happy :");
        for(int i=0;i<k;i++) {
            System.out.println(c[i].gname + " " +c[i].bname);
        }
        
        System.out.println("==========================");
        System.out.println(k+" "+" most compatible :");
        //sort according to compatibility
        in.sortc(c,lo);
        
        for(int i=0;i<k;i++) {
            System.out.println(c[i].gname + " " +c[i].bname);
        }
        
        System.out.println("==========================");
        System.out.println("All couples with total cost of gifts exchanged : ");
        for(int i=0;i<lo;i++) {
            System.out.println(c[i].gname + " " +c[i].bname + " " + c[i].cost);
        }
        
        
    }
}
