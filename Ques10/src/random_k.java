
import java.util.Random;

/**
 * <h1>Class containing generic method to find best 'k' valued items</h1>
 * @author Puja Kumari
 */

public class random_k {
    /**
     * Generic method to find best 'k' valued items
     * @param <T> Class type
     * @param a Object of class type 'T'
     * @param ar Array to contain values on whose basis sorting is done
     * @param n Number of elements in the object
     * @param k User input
     * @return A random structure from best 'k'
     */
    public <T> int ret_best(T[] a,int ar[],int n,int k) {
        int i,j,t,x;
        T tmp;
        for(i=0;i<n-1;i++) {
            for(j=i+1;j<n;j++) {
                if(ar[i]<ar[j]) {
                    t=ar[i];
                    ar[i]=ar[j];
                    ar[j]=t;
                    tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                }
            }
        }
        Random rand = new Random();
        x=rand.nextInt(k);
        return x;
    }
}
