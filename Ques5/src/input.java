
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
     * @param c List of couples made
     * @throws IOException Gives IO Exception on wrong arguments
     */
    
    public input(String args[],girls g[],boys b[],utility_gifts u[],luxury_gifts l[], essential_gift e[], couple c[]) throws IOException{
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
        girls temp;
        boys t;
        
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
        //sorting girls list on maintainance_cost
        for(int i=0;i<gs-1;i++) {
            for(int j=i+1;j<gs;j++) {
                if(g[i].maintainance_cost>g[j].maintainance_cost) {
                    temp = g[i];
                    g[i] = g[j];
                    g[j] = temp;
                }
            }
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
        //sorting boys list on attractiveness
        for(int i=0;i<bs-1;i++) {
            for(int j=i+1;j<bs;j++) {
                if(b[i].attractive>b[j].attractive) {
                    t = b[i];
                    b[i] = b[j];
                    b[j] = t;
                }
            }
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
       
        make_pair(g,b,gs,bs);
        
        
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
                qwe.write(date.toString()+ " " + "Committed :)" + '\t' + g[j].name + "  " + g[j].partner +"  " + g[j].cost + '\n');
                qwe.write(System.getProperty("line.separator"));
                
            }
            else{
                qwe.write(date.toString()+ " " + "Not Committed :(" + "   " + g[j].name + "  " + g[j].partner +"  " + g[j].cost + '\n');
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
     * Function to make a list of of the couples
     * @param c List of couples
     * @param g List of girls
     * @param b List of boys
     * @return No.of couples formed
     */
    public int makelist(couple c[],girls g[],boys b[]){
        int j,lo=0;
        for(j=0;j<gs;j++) {
            int flag=c[lo].find_happy(gs, bs, g[j], b, j);
            if(flag==1)
                lo++;
            
        }
        return lo;
    }
    
    /**
     * Function to make pairs of all girls and boys according to the algo given
     * @param g List of all girls
     * @param b List of all boys
     * @param gs Total number of girls
     * @param bs Total number of boys
     */
    public void make_pair(girls g[],boys b[],int gs,int bs) {
        int i=0,j=0,k=0;
        for(k=0;k<gs;k++) {
            while(i<gs) {
                if(g[i].status==1) {
                    g[i].matchMaker(b, bs,i);
                    i++;
                    break;
                }
                i++;
            }
            while(j<bs) {
                if(b[j].status==1) {
                    b[j].matchMaker(g, gs,j);
                    j++;
                    break;
                }
                j++;
            }
        }
        while(j<bs) {
            if(b[j].status==1) {
                b[j].matchMaker(g, gs,j);
                j++;
            }
            else {
                j++;
            }
        }
        
        
    }
        
}   
 

    


