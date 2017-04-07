
import java.io.IOException;


/**
 *
 * 
 * <h1>Main file of Question 8</h1>
 * <p>Make couples and give gifts using new allocation system
 * @author Puja Kumari
 */
public class ques8 {
    /**
     * Main method which gives most happy and most compatible couple
     * @param args List of arguments
     * @throws IOException Gives IO Exception when arguments are wrong
     */
    public static void main(String args[]) throws IOException {
    
        int k,j,lo=0;
        int[] commit = new int[1000];
        couple[] c = new couple[500];
        girls[] g = new girls [1000];
        boys[] b = new boys [1000];
        utility_gifts[] u = new utility_gifts [100];
        luxury_gifts[] l = new luxury_gifts [100];
        essential_gift[] e = new essential_gift [100];
        giftselect gf1 = new giftselector1();
        giftselect gf2 = new giftselector2();
        giftselect gf = gf1;
        input in = new input(g,b,u,l,e,commit,c,(giftselector1)gf,(giftselector2)gf2,gf);
        //to find happiness of the couple
        lo=in.makelist(c, g, b, commit);
        System.out.println("==========================");
        System.out.println("All couples with total cost of gifts exchanged : ");
        for(int i=0;i<lo;i++) {
            System.out.println(c[i].gname + " " +c[i].bname + " " + c[i].cost);
        }
        
        
    }
}
