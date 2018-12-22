
/**
 * 
 * @author pabl0cesar
 */
import java.util.*;

public class MatchAllFilters implements Filter{
        
        private ArrayList<Filter> filters;
        
        public MatchAllFilters(){
            filters = new ArrayList<Filter>();
        }
        
        public void addFilter(Filter filter){
            filters.add(filter);
        }
        
        public String getName(){
            String names = "";
            for (Filter f:filters){
                names = names.concat(String.format("\n%s",f.getName()));
            }
            return names;
        }
        
        public boolean satisfies(QuakeEntry qe){
            for (Filter f:filters){
                if(!f.satisfies(qe)){return false;}
            }
            return true;
        }
}
