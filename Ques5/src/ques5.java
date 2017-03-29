
import java.io.IOException;


/**
 *
 * 
 * <h1>Main file of Question 5</h1>
 * <p>Makes couples based on algo given
 * @author Puja Kumari
 */
public class ques5 {
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
        couple[] c = new couple[500];
        girls[] g = new girls [1000];
        boys[] b = new boys [1000];
        utility_gifts[] u = new utility_gifts [100];
        luxury_gifts[] l = new luxury_gifts [100];
        essential_gift[] e = new essential_gift [100];
        input in = new input(args,g,b,u,l,e,c);
        //to find happiness of the couple
        lo=in.makelist(c, g, b);
        //sort according to happiness
        in.sorth(c,lo);
        System.out.println(k+" "+" most happy :");
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
