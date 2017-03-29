/**
 * <h1>Class containing generic method to find best 'k' valued items</h1>
 * @author Puja Kumari
 */

public class best_k {
    /**
     * Generic method to find best 'k' valued items
     * @param <T> Class type
     * @param a Object of class type 'T'
     * @param ar Array to contain values on whose basis sorting is done
     * @param n Number of elements in the object
     */
    public <T> void ret_best(T[] a,int ar[],int n) {
        int i,j,t;
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
    }
}
