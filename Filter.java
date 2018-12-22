
/**
 * The interface Filter, which has one method signature named satisfies.
 * Note that satisfies is not defined.
 * Any class that implements Filter must provide the satisfies method.
 * 
 * @author pabl0cesar 
 */
public interface Filter
{
    public boolean satisfies(QuakeEntry qe); 
    
    public String getName();
    
    
}
