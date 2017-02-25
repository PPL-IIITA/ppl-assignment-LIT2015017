
import java.io.IOException;

/**
 *
 * 
 * <h1>Main file of question 1</h1>
 * <p>Prints all the couples formed
 * @author Puja Kumari
 */
public class ques1 {
    /**
     * Main method which gives list of all couples formed
     * @param args List of arguments
     * <p>1st input : boy.txt
     * <p>2nd input : girl.txt
     * <p>3rd input : essential.txt
     * <p>4th input : luxury.txt
     * <p>5th input : utility.txt
     * <p>6th input : k
     * @throws IOException Gives IO Exception when arguments are wrong
     */
    public static void main(String args[]) throws IOException{
        int[] commit = new int[1000];
        couple[] c = new couple[500];
        girls[] g = new girls [1000];
        boys[] b = new boys [1000];
        utility_gifts[] u = new utility_gifts [100];
        luxury_gifts[] l = new luxury_gifts [100];
        essential_gift[] e = new essential_gift [100];
        input in = new input(args,g,b,u,l,e,commit,c);
        for(int i=0;i<in.gs;i++) {
            if(commit[i]!=-1) {
                System.out.println(g[i].name + " " + g[i].partner);
            }
        }
        
        
    }
}
