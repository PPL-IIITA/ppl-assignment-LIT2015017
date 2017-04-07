
import java.io.IOException;
import java.util.Random;


/**
 *
 * 
 * <h1>Main file of Question 9</h1>
 * <p>Makes couples of best 'k' girls and boys
 * @author Puja Kumari
 */
public class ques9 {
    /**
     * Main method which gives most happy and most compatible couple
     * @param args List of arguments
     * @throws IOException Gives IO Exception when arguments are wrong
     */
    public static void main(String args[]) throws IOException {
    
        int k,j,lo=0;
        Random rand = new Random();
        k = rand.nextInt(6)+1;
        int[] commit = new int[1000];
        int[] ar = new int[1000];
        couple[] c = new couple[500];
        girls[] g = new girls [1000];
        boys[] b = new boys [1000];
        utility_gifts[] u = new utility_gifts [100];
        luxury_gifts[] l = new luxury_gifts [100];
        essential_gift[] e = new essential_gift [100];
        best_k bk = new best_k();
        input in = new input(g,b,u,l,e,commit,c,k);
        in.makearr1(b,k,ar);
        bk.<boys>ret_best(b,ar,in.bs);
        in.makearr2(g, k, ar);
        bk.<girls>ret_best(g,ar,in.gs);
        in.makearr3(e, k, ar);
        bk.<essential_gift>ret_best(e,ar,in.es);
        in.makearr4(l, k, ar);
        bk.<luxury_gifts>ret_best(l,ar,in.ls);
        in.pair(g, b, commit, k, l, e,c);
        lo=in.makelist(c, g, b, commit,k);
        System.out.println("All couples with total cost of gifts exchanged : ");
        for(int i=0;i<lo;i++) {
            System.out.println(c[i].gname + " " +c[i].bname + " " + c[i].cost);
        }
        
        
    }
}
