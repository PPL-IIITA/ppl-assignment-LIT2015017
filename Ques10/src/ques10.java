
import java.io.IOException;


/**
 *
 * 
 * <h1>Main file of Question 10</h1>
 * <p>Makes couples of best 'k' girls and boys by taking them randomly
 * @author Puja Kumari
 */
public class ques10 {
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
    
        int k=Integer.parseInt(args[5]),j,lo=0,x,y,w,z;
        int[] commit = new int[1000];
        int[] ar = new int[1000];
        couple[] c = new couple[500];
        girls[] g = new girls [1000];
        boys[] b = new boys [1000];
        utility_gifts[] u = new utility_gifts [100];
        luxury_gifts[] l = new luxury_gifts [100];
        essential_gift[] e = new essential_gift [100];
        random_k bk = new random_k();
        input in = new input(args,g,b,u,l,e,commit,c,k);
        System.out.println("List of girls generated randomly :");
        for(int i=0;i<k;) {
            x=in.makearr1(b,k,ar,bk);
            y=in.makearr2(g, k, ar,bk);
            z=in.makearr3(e, k, ar,bk);
            w=in.makearr4(l, k, ar,bk);
            if(g[y].status==1) {
                i++;
                System.out.println(g[i].name);
            }
            
            in.makep(g, b, commit, k,y);
        }
        in.pair(g, b, commit, k, l, e,c);
        lo=in.makelist(c, g, b, commit,k);
        System.out.println("===============================================");
        System.out.println("All couples with total cost of gifts exchanged : ");
        for(int i=0;i<lo;i++) {
            System.out.println(c[i].gname + " " +c[i].bname + " " + c[i].cost);
        }
        
        
    }
}
