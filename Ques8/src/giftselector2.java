/**
 * Class to give gifts using 2nd method
 * @author Puja Kumari
 */
public class giftselector2 extends giftselect {
    /**
     * Functions to give gifts to girls
     * @param b Details of boy
     * @param g List of all girls
     * @param l List of luxury gifts
     * @param e List of essential gifts
     * @param u List of utility gifts
     * @param l1 No. of luxury gifts
     * @param e1 No. of essential gifts
     * @param u1 No. of utility gifts
     * @param n Total no. of girls
     */
    public void giftselector(boys b, girls g[] ,luxury_gifts l[], essential_gift e[],utility_gifts u[],int l1, int e1,int u1,int n) {
        int j,k,m;
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
                g[b.partner].cost+=e[j].price;
                g[b.partner].value+=e[j].value;
                g[b.partner].cost+=l[j].price;
                g[b.partner].value+=2*l[j].value;
                g[b.partner].cost+=u[j].price;
                g[b.partner].value+=u[j].value;
                balance = balance-e[j].price-l[j].price-u[j].price;
                    
                j++;
                while(balance>0 && j<e1){
                    g[b.partner].cost+=e[j].price;
                    g[b.partner].value+=e[j].value;
                    j++;
                }
                b.happiness=balance;
            }
            else if (b.criteria == 2) {
                j=e1-1;k=l1-1;m=u1-1;
                balance = b.budget;
                g[b.partner].cost+=e[j].price;
                g[b.partner].value+=e[j].value;
                g[b.partner].cost+=l[k].price;
                g[b.partner].value+=2*l[k].value;
                g[b.partner].cost+=u[m].price;
                g[b.partner].value+=u[m].value;
                balance = balance-e[j].price-l[k].price-u[m].price;
                j--;
                while(balance>0 && j<e1){
                    g[b.partner].cost+=e[j].price;
                    g[b.partner].value+=e[j].value;
                    j++;
                }
                b.happiness=find_happiness(g[b.partner]);
            }
            else if(b.criteria == 3){
                j=0; k=0;
                balance = g[b.partner].maintainance_cost;
                g[b.partner].cost+=e[j].price;
                g[b.partner].value+=e[j].value;
                g[b.partner].cost+=l[j].price;
                g[b.partner].value+=2*l[j].value;
                g[b.partner].cost+=u[j].price;
                g[b.partner].value+=u[j].value;
                balance = balance-e[j].price-l[j].price-u[j].price;
                    
                j++;
                while(balance>0 && j<e1){
                    g[b.partner].cost+=e[j].price;
                    g[b.partner].value+=e[j].value;
                    j++;
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
