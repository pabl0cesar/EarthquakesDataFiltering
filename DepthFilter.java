
/**
 * This class has two private double variables
 * representing the minimum and maximum depth of earthquakes 
 * to consider for filtering.
 * 
 * This class has a constructor with two parameters
 * to initialize the previous mentioned two variables,
 * and a satisfies method that returns true
 * if its QuakeEntry parameter 'qe' has a depth in between
 * minDepth and maxDepth or equal to one of them.
 * 
 * @author pabl0cesar
 */

public class DepthFilter implements Filter {
    
    private double minDepth, maxDepth;
    private String name;
    
    public DepthFilter(double minDepth, double maxDepth, String name) { 
        this.name = name;
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
    } 
    
    public boolean satisfies(QuakeEntry qe) {
        System.out.println(qe.getMagnitude());
        return qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth; 
    } 
    
    
    public String getName(){
        return name;
    }

}