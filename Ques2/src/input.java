
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
    
    public input(String args[],girls g[],boys b[],utility_gifts u[],luxury_gifts l[], essential_gift e[],int commit[], couple c[]) throws IOException{
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
        
        gs=s.nextInt();
        bs=s2.nextInt();
        es=s3.nextInt();
        us=s4.nextInt();
        ls=s5.nextInt();
        
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
     * Function to sort couples as per happiness
     * @param c List of couples
     * @param n No. of couples
     */
    public void sorth(couple c[], int n){
        couple temp;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(c[i].happy<c[j].happy){
                    temp=c[i];
                    c[i]=c[j];
                    c[j]=temp;
                }
            }
        }
    }
    
    /**
     * Function to sort couples as per compatibility
     * @param c List of couples
     * @param n No. of couples
     */
    public void sortc(couple c[], int n){
        couple temp;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(c[i].compatible<c[j].compatible){
                    temp=c[i];
                    c[i]=c[j];
                    c[j]=temp;
                }
            }
        }
    }
    
    /**
     * Function to make a list of of the couples
     * @param c List of couples
     * @param g List of girls
     * @param b List of boys
     * @param commit Array to map each girl to a boy
     * @return No.of couples formed
     */
    public int makelist(couple c[],girls g[],boys b[],int commit[]){
        int j,lo=0;
        for(j=0;j<gs;j++) {
            int flag=c[lo].find_happy(gs, bs, g[j], b, commit, j);
            if(flag==1)
                lo++;
            
        }
        return lo;
    }
        
}   
    
    


