
public class generous_boys extends boys {
    /**
     * Constructor class
     * initializes all boys as single
     */
    public generous_boys() {
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
            if (criteria == 2) {
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



