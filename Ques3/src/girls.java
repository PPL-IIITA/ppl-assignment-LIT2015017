/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puja Kumari
 */
public class girls {
    String name;
    int attractive;
    int maintainance_cost;
    int intellect;
    int criteria; // '1'-attractive , '2'-rich , '3'-intelligent
    int status; // '1'-single , '2' - committed
    int cost; // cost of gifts recieved
    int value; //value of gifts recieved
    String partner; // to store the index of the boy 
    int happiness;
    int type; // '1'-choosy , '2'-normal , '3'-desperate
    /**
     * Constructor to initialize all girls as single
     */
    public girls() {
        attractive=0;
        maintainance_cost=0;
        intellect=0;
        criteria = 0;
        status= 1;
        cost=0;
        value=0;
    }
    
    /**
     * Function to find a suitable boy for each girl based on the constraints
     * @param b List of all boys
     * @param n No. of boys
     * @return The number of the boy who is suitable
     */
    public int matchMaker(boys b[],int n) {
        int boy_index = -1;
        int max_attribute = 0 , i;
        // if girl prefers most attractive available boy
        if(criteria == 1) {
            i=0;
            while(i<n){
                if(b[i].budget>=maintainance_cost && b[i].attractive>=max_attribute && b[i].status==1 && b[i].min_attraction<=attractive)
                {
                    max_attribute = b[i].attractive;
                    boy_index = i;
                } 
                i++;
            }
        }
              
            // if girl prefers richest available boy    
        else if(criteria == 2) {
            i=0;
            while(i<n){
                if(b[i].budget>=maintainance_cost && b[i].budget>=max_attribute && b[i].status==1 && b[i].min_attraction<=attractive)
                {
                    max_attribute = b[i].budget;
                    boy_index = i;
                }   
                i++;
            }
        }
                
            // if a girl prefers most intelligent available boy    
        else if(criteria == 3) {
            i=0;
            while(i<n){
                if(b[i].budget>=maintainance_cost && b[i].intellect>=max_attribute && b[i].status==1 && b[i].min_attraction<=attractive)
                {
                    max_attribute = b[i].intellect;
                    boy_index = i;
                }  
                i++;
            }
        }
            
        if(boy_index != -1) {
            b[boy_index].status = 2;
            status = 2;
            partner=b[boy_index].name;
            
        }
            
        return boy_index;
    }
    
}
