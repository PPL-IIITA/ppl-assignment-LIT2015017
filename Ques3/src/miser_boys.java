
public class miser_boys extends boys {
    /**
     * Constructor class
     * initializes all boys as single
     */
    public miser_boys() {
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
    @Override
    public void gifting(girls g[] ,luxury_gifts l[], essential_gift e[],int l1, int e1,int n) {
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
            
    }
}
    
    /**
     * Function to find happiness of the girl
     * @param g List of girls
     * @return Happiness of the girl
     */
    @Override
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


