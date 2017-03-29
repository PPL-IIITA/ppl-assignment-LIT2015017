
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
    public void gifting(girls g[] ,luxury_gifts l[], essential_gift e[],int l1, int e1,int n,int x) {
        int j,k;
        if(status==2){
            j = 0;
            k=0;
            for(int i=0;i<n;i++) {
                if(g[i].partner == name) {
                    partner = i;
                }
            }
            int balance;
            if(criteria == 1) {
                j=0; k=0;
                balance = g[partner].maintainance_cost;
                while(balance>0 && j<x){
                    g[partner].cost+=e[j].value;
                    g[partner].value+=e[j].value;
                    balance = balance-e[j].price;
                    
                    j++;
                    if(j==x && g[partner].cost < g[partner].maintainance_cost) {
                        g[partner].cost+=l[k].value;
                        g[partner].value+=2*l[k].value;
                        balance = balance-l[k].price;
                        k++;
                    }   
                }
                happiness=balance;
            }
            else if (criteria == 2) {
                j=0;
                k=0;
                balance = budget;
                while(balance>=0 && j<x){
                    if(balance - l[j].price > 0 ) {
                        g[partner].cost+=l[j].value;
                        g[partner].value+=2*l[j].value;
                        balance = balance-l[j].price;
                        j++;
                    }
                    if(j==x && balance - e[k].price > 0) {
                        g[partner].cost+=e[k].value;
                        g[partner].value+=e[k].value;
                        balance = balance-e[k].price;
                        k++;
                    }   
                }
                happiness=find_happiness(g[partner]);
            }
            else if(criteria == 3){
                j=0; k=0;
                balance = g[partner].maintainance_cost;
                while(balance>0 && j<x){
                    g[partner].cost+=e[j].value;
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
}
