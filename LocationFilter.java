
/**
 * This class includes private instance variables for a location and a maximum
 * distance, a constructor to initialize those variables,
 * and a satisfies method that returns true if a QuakeEntry’s distance
 * from the given location is less than the specified maximum distance.
 * 
 * @author pabl0cesar
 */

public class LocationFilter implements Filter {
    
    private Location location;
    private double maxDistance; 
    private String name;
    
    public LocationFilter(Location location, double maxDistance, String name) { 
        this.name = name;
        this.location = location;
        this.maxDistance = maxDistance;
    } 
    
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getLocation().distanceTo(location) < maxDistance; 
    } 
    
    public String getName(){
        return name;
    }
}