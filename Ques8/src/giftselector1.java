/**
 * Class to give gifts using 1st method
 * @author Puja Kumari
 */
public class giftselector1 extends giftselect{
    /**
     * Functions to give gifts to girls
     * @param b Details of boy
     * @param g List of all girls
     * @param l List of luxury gifts
     * @param e List of essential gifts
     * @param l1 No. of luxury gifts
     * @param e1 No. of essential gifts
     * @param n Total no. of girls
     */
    public void giftselector(boys b, girls g[] ,luxury_gifts l[], essential_gift e[],utility_gifts u[],int l1, int e1,int u1,int n) {
        int j,k;
        if(b.status==2){
            for(int i=0;i<n;i++) {
                if(g[i].partner == b.name) {
                    b.partner = i;
                }
            }
            int balance;
            if(b.criteria == 1) {
                j=0; k=0;
                balance = g[b.partner].maintainance_cost;
                while(balance>0 && j<e1){
                    g[b.partner].cost+=e[j].price;
                    g[b.partner].value+=e[j].value;
                    balance = balance-e[j].price;
                    
                    j++;
                    if(j==e1 && g[b.partner].cost < g[b.partner].maintainance_cost) {
                        g[b.partner].cost+=l[k].price;
                        g[b.partner].value+=2*l[k].value;
                        balance = balance-l[k].price;
                        k++;
                    }   
                }
                b.happiness=balance;
            }
            else if (b.criteria == 2) {
                j=l1-1;
                k=e1-1;
                balance = b.budget;
                while(balance>=0 && j>=0){
                    if(balance - l[j].price > 0 ) {
                        g[b.partner].cost+=l[j].price;
                        g[b.partner].value+=2*l[j].value;
                        balance = balance-l[j].price;
                        j--;
                    }
                    if(j==-1 && balance - e[k].price > 0) {
                        g[b.partner].cost+=e[k].price;
                        g[b.partner].value+=e[k].value;
                        balance = balance-e[k].price;
                        k--;
                    }   
                }
                b.happiness=find_happiness(g[b.partner]);
            }
            else if(b.criteria == 3){
                j=0; k=0;
                balance = g[b.partner].maintainance_cost;
                while(balance>0 && j<e1){
                    g[b.partner].cost+=e[j].price;
                    g[b.partner].value+=e[j].value;
                    balance = balance-e[j].price;
                    j++;     
                }
                if(balance > 0 && balance-l[0].price >=0) {
                    g[b.partner].cost+=l[0].price;
                    g[b.partner].value+=2*l[0].value;
                }
                
                b.happiness=g[b.partner].intellect;
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
