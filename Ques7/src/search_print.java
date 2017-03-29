
import java.util.*;
/**
 * <h1>Class to find and print the girlfriends of boys from the given list</h1>
 * <p>
 * Uses all three implementations
 * @author Puja Kumari
 */
public class search_print {
    
    /**
     * <h2>Function to find and print the classes</h2>
     * <p>
     * Generates random number between 1-3 : Uses simple array if 1, uses sorted array if 2, uses hash table if 3
     * @param c Couple array
     * @param cs Couple array sorted on basis of boys name
     * @param chash A hash table to store data of couples
     * @param lo Total number of couples
     * @param s List of boys given
     * @param n No. of boys given in the list
     * @param in Object of class which contains a method to calculate hash function
     */
    public void find_print(couple c[],couple cs[],couple chash[],int lo,String s[],int n,input in) {
        int i,j,ch,flag=0,x;
        System.out.println("List of boys given :");
        System.out.println("--------------------");
        for(i=0;i<n;i++) {
            System.out.print(s[i]+"  ");
        }
        System.out.println("\n");
        Random rand = new Random();
        ch = rand.nextInt(3)+1;
        //Search from simple array
        if(ch==1) {
            System.out.println("\nSearching from simple array");
            System.out.println("---------------------------");
            for(i=0;i<n;i++) {
                flag=0;
                for(j=0;j<lo;j++) {
                    if(c[j].bname == s[i]) {
                        System.out.println(c[j].bname+" -- "+c[j].gname);
                        flag=1;
                    }
                }
                if(flag==0){
                    System.out.println(s[i]+" -- "+"No-One");
                }
            }
        }
        //Search from sorted array
        if(ch==2) {
            System.out.println("\nSearching from sorted array");
            System.out.println("---------------------------");
            for(i=0;i<n;i++) {
                for(j=0;j<lo;j++) {
                    if(cs[j].bname == s[i]) {
                        System.out.println(cs[j].bname+" -- "+cs[j].gname);
                        flag=1;
                    }
                }
                if(flag==0){
                    System.out.println(s[i]+" -- "+"No-One");
                }
            }
        }
        //Search from hash table
        if(ch==3) {
            System.out.println("\nSearching from hash table");
            System.out.println("-------------------------");
            for(i=0;i<n;i++) {
                x=in.hashfunc(s[i]);
                int y=x;
                if(chash[x].bname == s[i]) {
                    System.out.println(chash[x].bname+" -- "+chash[x].gname);
                    flag = 1;
                }
                else {
                    x++;
                    while(chash[x].bname != s[i] && x!=y) {
                        if(x<499) 
                            x++;
                        else
                            x=0;
                    }
                    if(chash[x].bname == s[i]) {
                        System.out.println(chash[x].bname+" -- "+chash[x].gname);
                        flag = 1;
                    }
                }
                if(flag == 0)
                    System.out.println(s[i]+" -- No-one");
            }
        }
        
    }
}
