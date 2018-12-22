
/**
 * Search through a data set containing details about earthquakes around the world
 * and filter the data based on desired criteria
 * implementing interfaces with method signatures.
 *
 * @author pabl0cesar
 */

import java.util.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * This method returns an ArrayList of QuakeEntry’s from quakeData 
     * that meet the requirements of Filter f’s satisfies method.
     */
    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 
    
    public void testMatchAllFilters(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
     
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilters maf = new MatchAllFilters();
        MagnitudeFilter mF = new MagnitudeFilter(1.0,4.0,"Magnitude");
        DepthFilter dF = new DepthFilter(-180000.0,-30000.0,"Depth");
        PhraseFilter pF = new PhraseFilter("any","o","Phrase");
        
        maf.addFilter(mF);
        maf.addFilter(dF);
        maf.addFilter(pF);
        
        ArrayList<QuakeEntry> filterList = filter(list, maf);
        dumpCSV(filterList);
        System.out.println("Found "+filterList.size()+" quakes that matches that criteria.");
        
    }
    
    public void testMatchAllFilters2(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
     
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilters maf = new MatchAllFilters();
        MagnitudeFilter mF = new MagnitudeFilter(0.0,5.0,"Magnitude");
        LocationFilter lF = new LocationFilter(new Location(55.7308, 9.1153), 3000000,"Location");
        PhraseFilter pF = new PhraseFilter("any","Ca","Phrase");
        
        maf.addFilter(mF);
        maf.addFilter(lF);
        maf.addFilter(pF);
        
        ArrayList<QuakeEntry> filterList = filter(list, maf);
        
        dumpCSV(filterList);
        System.out.println("Found "+filterList.size()+" quakes that matches that criteria.");
        System.out.println("Filters used are: "+maf.getName());
    }
    
    /**
     * This method creates an EarthQuakeParser to read in an earthquake data 
     * file, creating an ArrayList of QuakeEntrys. It then creates a 
     * MinMagFilter with a minimum magnitude, and then calls 
     * the filter method with the MinMagFilter to create an ArrayList 
     * of QuakeEntry’s having that minimum magnitude or greater.
     */

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        Filter f = new MagnitudeFilter(3.5,4.5,"Magnitude");
        ArrayList<QuakeEntry> magList  = filter(list, f); 
        f = new DepthFilter( -55000.0,-20000.0,"Depth");
        ArrayList<QuakeEntry> depthMagList = filter(magList, f);

        
        // Filter f = new LocationFilter(new Location(39.7392, -104.9903),1000000,"Location");
        // ArrayList<QuakeEntry> locList = filter(list,f);
        // f = new PhraseFilter("end","a","Phrase");
        // ArrayList<QuakeEntry> multiList = filter(locList,f);
        
        for (QuakeEntry qe: depthMagList) { 
            System.out.println(qe);
        } 
        
        System.out.println("Found "+depthMagList.size()+" quakes that matches that criteria.");
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
