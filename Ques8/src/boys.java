
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
     * @param u List of utility gifts
     * @param l1 No. of luxury gifts
     * @param e1 No. of essential gifts
     * @param u1 No. of utility gifts
     * @param n Total no. of girls
     * @param ch Choice of method of gift selection
     * @param gf1 Gift selector 1
     * @param gf2 Gift selector 2
     * @param gf Parent gift selector
     */
    public void gifting1(girls g[] ,luxury_gifts l[], essential_gift e[],utility_gifts u[],int l1, int e1,int u1,int n,int ch,giftselector1 gf1, giftselector2 gf2,giftselect gf) {
        
        if(ch==1) {
            gf1.giftselector(this, g, l, e, u, l1, e1, u1, n);
        }
        else {
            gf2.giftselector(this, g, l, e, u, l1, e1, u1, n);
        }
    }
    
}   

