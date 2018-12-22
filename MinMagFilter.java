
/**
 * This class has a private double variable
 * representing the minimum magnitude of earthquakes
 * to consider for filtering.
 * 
 * This class also has a constructor with one parameter
 * to initialize minMag, and a satisfies method that returns true
 * if its QuakeEntry parameter qe has a magnitude greater than or equal
 * to minMag.
 * 
 * @author pabl0cesar
 */
public class MinMagFilter implements Filter
{
    private double minMag; 
    private String name;
    
    public MinMagFilter(double minMag, String name) { 
        this.minMag = minMag;
        this.name = name;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= minMag; 
    } 
    
    
    public String getName(){
        return name;
    }

}
