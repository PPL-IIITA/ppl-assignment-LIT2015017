
import static java.lang.Math.abs;


/**
 *<h1>Class to store the info of all couples i.e., girl's name, boy's name, happiness and compatibility</h1>
 *<p>Finds happiness of the couples
 * @author Puja Kumari
 */
public class couple {
    String bname;
    String gname;
    int happy;
    int compatible;
    int cost;
    
    
    /**
     * Function to find the happiness of the couple
     * @param gs No. of girls
     * @param bs No.of boys
     * @param g List of girls
     * @param b List of boys
     * @param commit Array to map girls with boys
     * @param i Maintains index
     * @return Returns 1 if a couple is formed else return 0
     */
    public int find_happy(int gs,int bs, girls g, boys b[], int commit[],int i) {
        
            if(commit[i]!=-1){
                happy=g.happiness + b[commit[i]].happiness;
                compatible=b[commit[i]].budget-g.maintainance_cost + abs(b[commit[i]].intellect-g.intellect) + abs(b[commit[i]].attractive-g.attractive);
                gname=g.name;
                bname=g.partner;
                cost=g.cost;
                return 1;
            }
            else
                return 0;
        
        
    }
    
}
