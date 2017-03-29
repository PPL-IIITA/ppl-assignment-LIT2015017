
import java.io.FileInputStream;
import java.util.*;


/**
 *
 * 
 * <h1>Class to input all the data from the text files</h1>
 * <p>Calls function to provide gifts
 * <p>Writes output to the text file
 * <p>Has function to sort data as per happiness and compatibility
 * 
 */

import java.io.*;
import java.util.Scanner;
public class input {
    
    
    int gs,bs,es,us,ls;
    /**
     * Constructor function which initializes the girl,boy and the gift list
     * @param args Command line argument to accept file names and value of k
     * @param g List of girls
     * @param b List of boys
     * @param u List of utility gifts
     * @param l List of luxury gifts
     * @param e List of essential gifts
     * @param commit Array to store the mapping of committed boys and girls
     * @param c List of couples made
     * @throws IOException Gives IO Exception on wrong arguments
     */
    
    public input(String args[],girls g[],boys b[],utility_gifts u[],luxury_gifts l[], essential_gift e[],int commit[], couple c[],couple cs[],couple chash[]) throws IOException{
        FileInputStream girl = new FileInputStream(args[1]);
        FileInputStream boy = new FileInputStream(args[0]);
        FileInputStream utility_gift = new FileInputStream(args[4]);
        FileInputStream luxury_gift = new FileInputStream(args[3]);
        FileInputStream essential_gift = new FileInputStream(args[2]);
        Scanner s =new Scanner(girl);
        Scanner s2 =new Scanner(boy);
        Scanner s3 = new Scanner(essential_gift);
        Scanner s4 = new Scanner(utility_gift);
        Scanner s5 = new Scanner(luxury_gift);
        File file = new File("coupledata.txt");
        FileWriter qwe= new FileWriter(file,true);
        
        gs=Integer.parseInt(s.next());
        bs=Integer.parseInt(s2.next());
        es=Integer.parseInt(s3.next());
        us=Integer.parseInt(s4.next());
        ls=Integer.parseInt(s5.next());
        
        for(int i=0;i<gs;i++) {
                g[i]=new girls();
                g[i].name=s.next();
                g[i].attractive=s.nextInt();
                g[i].maintainance_cost=s.nextInt();
                g[i].intellect=s.nextInt();
                g[i].criteria=s.nextInt();
                g[i].type=s.nextInt();
        }
        
        for(int i=0;i<bs;i++) {
                b[i]=new boys();
                b[i].name=s2.next();
                b[i].attractive=s2.nextInt();
                b[i].intellect=s2.nextInt();
                b[i].budget=s2.nextInt();
                b[i].min_attraction=s2.nextInt();
                b[i].criteria=s2.nextInt();
        }
        
        
        for(int i=0;i<es;i++) {
            e[i] = new essential_gift();
            e[i].value=s3.nextInt();
            e[i].price=s3.nextInt();    
        }
        
        for(int i=0;i<us;i++) {
            u[i] = new utility_gifts();
            u[i].utility_value=s4.nextInt();
            u[i].utility_class=s4.nextInt();
            u[i].value=s4.nextInt();
            u[i].price=s4.nextInt();
        }
        
       
        for(int i=0;i<ls;i++) {
            l[i] = new luxury_gifts();
            l[i].rating=s5.nextInt();
            l[i].difficulty=s5.nextInt();
            l[i].value=s5.nextInt();
            l[i].price=s5.nextInt();    
        }
       
        for(int i=0;i<gs;i++) {
            int x=g[i].matchMaker(b, bs);
            commit[i]=x;
            
        }
        
        
       for(int i=0;i< bs;i++) {
            b[i].gifting(g, l, e, ls, es, gs);
       }
       
       for(int i=0;i<500;i++) {
            c[i] = new couple();
            cs[i] = new couple();
            chash[i] = new couple();
        }
       //to write log in te file
        Date date = new Date();
        for(int j=0;j<gs;j++) {
            
            if(g[j].status == 2){
                qwe.write(date.toString()+ " " + "Committed :)" + "  " + g[j].name + "  " + g[j].partner +"  " + g[j].cost + '\n');
                qwe.write(System.getProperty("line.separator"));
                
            }
            else{
                qwe.write(date.toString()+ " " + "Not Committed :(" + "  " + g[j].name + "  " + g[j].partner +"  " + g[j].cost + '\n');
                qwe.write(System.getProperty("line.separator"));
            }
                
            
        }
        qwe.flush();
        qwe.close();
        
            
        
    
    }
    /**
     * Function to sort couples as per boys names
     * @param cs List of couples to be sorted
     * @param n No. of couples
     */
    public void sortn(couple cs[], int n){
        couple temp;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                int cmp = cs[j].bname.compareTo(cs[i].bname);
                if(cmp<0){
                    temp=cs[i];
                    cs[i]=cs[j];
                    cs[j]=temp;
                }
            }
        }
    }
    
    /**
     * Function to make a array of of the couples
     * @param c List of couples
     * @param g List of girls
     * @param b List of boys
     * @param commit Array to map each girl to a boy
     * @return No.of couples formed
     */
    public int makelist1(couple c[],girls g[],boys b[],int commit[]){
        int j,lo=0;
        for(j=0;j<gs;j++) {
            int flag=c[lo].find_happy(gs, bs, g[j], b, commit, j);
            if(flag==1)
                lo++;
            
        }
        return lo;
    }
    
    /**
     * Function to make a array of of the couples and sort them as per boys name
     * @param c List of couples
     * @param cs Object to hold sorted list of couples
     * @param lo Total number of couples
     */
    public void makelist2(couple c[],couple cs[],int lo) {
        int i,j;
        for(i=0;i<lo;i++) {
            cs[i]=c[i];
        }
        sortn(cs,lo);
    }
    
    /**
     * Function to make a hash table to store the list of couples
     * @param c List of couples
     * @param chash Hash table to store list of couples
     * @param lo Total number of couples
     */
    public void makelist3(couple c[],couple chash[],int lo) {
        int i,j,m;
        for(i=0;i<lo;i++) {
            m=hashfunc(c[i].bname);
            if(chash[m].bname==null) {
                chash[m]=c[i];
            }
            else {
                while(chash[m].bname!=null) {
                    if(m<499)
                        m++;
                    else
                        m=0;
                }
                chash[m]=c[i];
            }
            
        }
        
    }
    
    
    /**
     * Function to find the hash function of the boy's name
     * @param x Name of the boy present in the list
     * @return Hash value which serves as index for hash table
     */
    public int hashfunc(String x) {
        char ch[];
        int i,sum=0;
        ch = x.toCharArray();
        int xlen = x.length();
        for(i=0;i<xlen;i++) {
            sum+=ch[i];
        }
        return sum%100;
    }
    
    /**
     * Function to generate random list of boys whose girlfriends are to be found
     * @param b List of all the boys
     * @param s Array to store list of generated boys
     * @return Total number of boys
     */
    public int genrandom(boys b[],String s[]) {
        int r,i,n;
        Random rand = new Random();
        n = rand.nextInt(30)+1;
        for(i=0;i<n;i++) {
            r = rand.nextInt(30);
            s[i] = b[r].name;
        }
        return n;
    }
        
}   
    
    


