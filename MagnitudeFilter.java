
/**
 * This class has two private double variables, each named magMin and magMax
 * representing the minimum and maximum magnitude of earthquakes 
 * to consider for filtering.
 * 
 * This class has a constructor with two parameters
 * to initialize the previous mentioned two variables,
 * and a satisfies method that returns true
 * if its QuakeEntry parameter 'qe' has a magnitude equal to or in between
 * magMin and magMax.
 * 
 * @author pabl0cesar
 */

public class MagnitudeFilter implements Filter {
    
    private double minMag, maxMag;
    private String name;
    
    public MagnitudeFilter(double minMag, double maxMag, String name) { 
        this.minMag = minMag;
        this.maxMag = maxMag;
        this.name = name;
    } 
    
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= minMag && qe.getMagnitude() <= maxMag; 
    } 
    
    public String getName(){
        return name;
    }

}