/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubhashish
 */
import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SearchManager {
    
    FRSManager mgr;
    BookingManager bkMgr;
    private int passno;
    private String depCity;
    private String doj;
    private String transit_time;
    private String total_time;
    
    public SearchManager(FRSManager mgr) {
        this.mgr = mgr;
    }
    public SearchManager(){
        
    }
    
    public ArrayList<ComboFlight> searchFlight(int passno, String depCity, String doj, ArrayList<Flight> sj, ArrayList<Flight> sl) throws ParseException{
        ComboFlight cf = new ComboFlight();
       
        ArrayList<ComboFlight> ComboList = new ArrayList<ComboFlight>();
        this.passno = passno;
        this.doj = doj;
        this.depCity = depCity;
        for(Flight f : sj) {
            cf.destinationCodes(f);
            //System.out.println(f.getOrigin());
            if(depCity.equals(f.getOrigin().trim().toUpperCase())) {
                if(cf.dojDate(doj).compareTo(cf.dateSJmin(f)) >=0 && cf.dojDate(doj).compareTo(cf.dateSJmax(f)) <= 0) {
                    for(Flight g : sl) {
                        cf.sectorCodes(g);
                        Date dot = cf.dojDate(doj);
                        if(g.getDepTime().equals("0050")) {
                            Calendar cal =Calendar.getInstance();
                            cal.setTime(dot);
                            cal.add(Calendar.DATE, 1);
                            dot = cal.getTime();
                        }
                        //System.out.println("//"+depCity);
                        if(f.getDestinationCode(f).equals(g.getSectorCode(g)) && cf.dateSL(g, dot)) {  
                            //System.out.println("////a");
                                if(((cf.daysSJ(f).contains("DAILY")) || (cf.daysSJ(f).contains(cf.calcDaylong(doj)))) && (cf.daysSL(g).contains(cf.calcDayshort(doj)))) {
                                   //System.out.println("//////b");
                                    cf.calcTransit_time(doj, f, g);
                                    cf.calcTotal_time(doj, f, g);
                                    //System.out.println(cf.getNextDay());
                                        if(cf.getTransit_hrs().compareTo((double) 2)>=0 && cf.getTransit_hrs().compareTo((double) 6)<=0) {
                                           // System.out.println("////////c");
                                            ComboFlight combof = new ComboFlight(f.getDestination(), f.getFlightno_sj(), g.getFlightno_sl(), f.getDeparture(), g.getDepTime(), f.getArrival(), g.getArrTime(), cf.getTransit_time(), cf.getTotal_time());
                                            ComboList.add(combof);
                                        }
                                }
                        }
                    } 
                } }
            
        }    
        Collections.sort(ComboList);
        return ComboList;
    }

    /**
     * @return the passno
     */
    public int getPassno() {
        return passno;
    }

    /**
     * @param passno the passno to set
     */
    public void setPassno(int passno) {
        this.passno = passno;
    }

    /**
     * @return the depCity
     */
    public String getDepCity() {
        return depCity;
    }

    /**
     * @param depCity the depCity to set
     */
    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }
}
