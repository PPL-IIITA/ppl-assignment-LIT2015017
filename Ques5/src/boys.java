
/**
 *
 * 
 * <h1>Class for boys</h1>
 * <p>
 * Contains attributes of boys
 * <p>
 * Contains a function to give gifts to girls
 * 
 */


public class boys {
    String name;
    int attractive;
    int budget;
    int intellect;
    int min_attraction;
    int criteria; // '1'-miser , '2'-generous , '3'-geeks
    int status;  // '1'-single ; '2' - committed
    int partner;
    int happiness;
    double c;
    /**
     * Constructor class
     * initializes all boys as single
     */
    public boys() {
        attractive=0;
        budget=0;
        intellect=0;
        min_attraction=0;
        status= 1;
        partner = -1;
        c=0;
    }
    
    /**
     * Functions to give gifts to girls
     * @param g List of all girls
     * @param l List of luxury gifts
     * @param e List of essential gifts
     * @param l1 No. of luxury gifts
     * @param e1 No. of essential gifts
     * @param n Total no. of girls
     */
    public void gifting(girls g[] ,luxury_gifts l[], essential_gift e[],int l1, int e1,int n) {
        int j,k;
        if(status==2){
            j = 0;
            k=0;
            int balance;
            if(criteria == 1 && partner != -1) {
                j=0; k=0;
                balance = g[partner].maintainance_cost;
                while(balance>0 && j<e1){
                    g[partner].cost+=e[j].price;
                    g[partner].value+=e[j].value;
                    balance = balance-e[j].price;
                    
                    j++;
                    if(j==e1 && g[partner].cost < g[partner].maintainance_cost) {
                        g[partner].cost+=l[k].price;
                        g[partner].value+=2*l[k].value;
                        balance = balance-l[k].price;
                        k++;
                    }   
                }
                happiness=balance;
            }
            else if (criteria == 2 && partner != -1) {
                j=l1-1;
                k=e1-1;
                balance = budget;
                while(balance>=0 && j>=0){
                    if(balance - l[j].price > 0 ) {
                        g[partner].cost+=l[j].price;
                        g[partner].value+=2*l[j].value;
                        balance = balance-l[j].price;
                        j--;
                    }
                    if(j==-1 && balance - e[k].price > 0) {
                        g[partner].cost+=e[k].price;
                        g[partner].value+=e[k].value;
                        balance = balance-e[k].price;
                        k--;
                    }   
                }
                happiness=find_happiness(g[partner]);
            }
            else if(criteria == 3 && partner != -1){
                j=0; k=0;
                balance = g[partner].maintainance_cost;
                while(balance>0 && j<e1){
                    g[partner].cost+=e[j].price;
                    g[partner].value+=e[j].value;
                    balance = balance-e[j].price;
                    j++;     
                }
                if(balance > 0 && balance-l[0].price >=0) {
                    g[partner].cost+=l[0].price;
                    g[partner].value+=2*l[0].value;
                }
                
                happiness=g[partner].intellect;
            }
        }
    }
    
    /**
     * Function to find happiness of the girl
     * @param g List of girls
     * @return Happiness of the girl
     */
    public int find_happiness( girls g) {
        if(g.type == 1)
            g.happiness= (int)Math.log(g.cost);
        else if(g.type== 2)
            g.happiness =( g.cost-g.maintainance_cost + g.value);
        else if (g.type == 3)
            g.happiness =(int) Math.exp(g.cost);
        
        return g.happiness;
    }
    /**
     * Function to find a suitable boy for each girl based on the constraints
     * @param g List of all girls
     * @param n Total number of girls
     * @param j Index of the boy for which pair is being made
     */
    public void matchMaker(girls g[],int n, int j) {
        int girl_index = -1;
        int max_a = 0,i;
        i=0;
        while(i<n) {
            if(budget>=g[i].maintainance_cost && g[i].status==1 && g[i].attractive>=max_a && min_attraction<=g[i].attractive) {
                max_a = g[i].attractive;
                girl_index = i;
            }
            i++;
        }
        if(girl_index != -1) {
            g[girl_index].status = 2;
            status = 2;
            partner = girl_index;
            g[girl_index].p_index=j;
            g[girl_index].partner=name;
        }
    }
}
