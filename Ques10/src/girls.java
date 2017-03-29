

/**
 *
 * 
 * <h1>Class for girls</h1>
 * <p>
 * contains info about attributes of each girl
 * <p>
 * Contains function to find a suitable boy for each girl
 * 
 * 
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
        int boy_index = -1,i=0;
        while(i<n){
                if(b[i].budget>=maintainance_cost && b[i].status==1)
                {
                    boy_index = i;
                    break;
                } 
                i++;
            }
            
        if(boy_index != -1) {
            b[boy_index].status = 2;
            status = 2;
            partner=b[boy_index].name;
            
        }
            
        return boy_index;
    }
    
    
}
