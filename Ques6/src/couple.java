
import static java.lang.Math.abs;


/**
 *<h1>Class to store the info of all couples i.e., girl's name, boy's name, happiness and compatibility</h1>
 *<p>Finds happiness of the couples
 * @author Puja Kumari
 */
public class couple {
    String bname;
    String gname;
    int gindex;
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
        
            if(commit[i]!=-1 && g.partner!="null"){
                happy=g.happiness + b[commit[i]].happiness;
                compatible=b[commit[i]].budget-g.maintainance_cost + abs(b[commit[i]].intellect-g.intellect) + abs(b[commit[i]].attractive-g.attractive);
                gname=g.name;
                bname=g.partner;
                cost=g.cost;
                gindex=i;
                return 1;
            }
            else
                return 0;
        
        
    }
    /**
     * <h3>Function to perform breakup of couples</h3>
     * <h4>Updates the couple array</h4>
     * @param breakup List of girls who broke-up
     * @param i index counter for breakup array
     * @param g List of all girls
     * @param commit Array having list of girls and index of their boyfriends
     * @param b List of all boys
     */
    public void break_couple(int breakup[],int i,girls g[],int commit[],boys b[]) {
        gname="NULL";
        bname="NULL";
        cost=0;
        happy=0;
        breakup[i]=gindex;
        g[gindex].cost=0;
        g[gindex].happiness=0;
        g[gindex].status=1;
        b[commit[gindex]].status=1;
        gindex=-1;
        
    }
    
}
