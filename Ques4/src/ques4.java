
import java.io.IOException;
import java.util.Random;

/**
 *
 * 
 * <h1>Main file of Question 4</h1>
 * <p>Performs breakup of least 'k' happy couples and assigns new boyfriends to the girls who broke-up
 * @author Puja Kumari
 */
public class ques4 {
    /**
     * Main method which gives most happy and most compatible couple
     * @param args List of arguments
     * @throws IOException Gives IO Exception when arguments are wrong
     */
    public static void main(String args[]) throws IOException {
    
        int k,j,lo=0,i; //lo=no. of couples
        Random rand = new Random();
        k = rand.nextInt(6)+1;
        int[] commit = new int[1000];
        int[] breakup = new int[k];
        couple[] c = new couple[500];
        girls[] g = new girls [1000];
        boys[] b = new boys [1000];
        utility_gifts[] u = new utility_gifts [100];
        luxury_gifts[] l = new luxury_gifts [100];
        essential_gift[] e = new essential_gift [100];
        input in = new input(g,b,u,l,e,commit,c);
        //to find happiness of the couple
        lo=in.makelist(c, g, b, commit);
        //sort according to happiness
        in.sorth(c,lo);
        //breaking up least 'k' happy couples
        for(i=lo-1,j=0;i>=lo-k;i--,j++) {
            c[i].break_couple(breakup,j);
            
        }
        lo=lo-k;
        //Assigning new boyfriend to the girls who broke-up
        for(i=0;i<k;i++) {
            int x=g[breakup[i]].matchMaker(b, in.bs, commit[breakup[i]]);
            commit[breakup[i]]=x;
        }
        //Updating couple object
        lo=in.makelist(c, g, b, commit);
        System.out.println("New boyfriend of the girls who broke-up : ");
        for(i=0;i<k;i++) {
            System.out.println(g[breakup[i]].name+" "+g[breakup[i]].partner);
        }
        System.out.println("============");
        System.out.println("List of all couples : " );
        for(i=0;i<lo;i++) {
            System.out.println(c[i].gname + " " +c[i].bname);
        }
        
    }
        
}
