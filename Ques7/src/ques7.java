
import java.io.IOException;


/**
 *
 * 
 * <h1>Main file of Question 7</h1>
 * <p>Uses three implementations of couple array and finds girlfriend of the boys given in a list
 * @author Puja Kumari
 */
public class ques7 {
    /**
     * Main method which gives the girlfriend of boys given in the list
     * <p>Generates a random number 'n' and randomly picks 'n' boys whose girlfriend have to be found
     * @param args List of arguments
     * <p>1st input : boy.txt
     * <p>2nd input : girl.txt
     * <p>3rd input : essential.txt
     * <p>4th input : luxury.txt
     * <p>5th input : utility.txt
     * @throws IOException Gives IO Exception when arguments are wrong
     */
    public static void main(String args[]) throws IOException {
    
        int j,lo=0,n;
        int[] commit = new int[1000];
        couple[] c = new couple[500];
        couple[] cs = new couple[500];
        couple[] chash = new couple[500];
        girls[] g = new girls [1000];
        boys[] b = new boys [1000];
        utility_gifts[] u = new utility_gifts [100];
        luxury_gifts[] l = new luxury_gifts [100];
        essential_gift[] e = new essential_gift [100];
        String[] s = new String[100];
        search_print sp = new search_print();
        input in = new input(args,g,b,u,l,e,commit,c,cs,chash);
        
        lo=in.makelist1(c, g, b, commit);
        in.makelist2(c,cs,lo);
        in.makelist3(c, chash, lo);
        n=in.genrandom(b, s);
        
        sp.find_print(c,cs,chash,lo,s,n,in);
    }
}
