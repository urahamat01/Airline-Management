/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubhashish
 */
//import java.sql.*;
import java.util.*;
import java.io.*;
import static java.lang.Math.abs;
import java.text.*;
import java.time.format.DateTimeFormatter;
public class ComboFlight implements Comparable<ComboFlight> {
    
    private String via;
    private String doj;
    private String day; 
    private String transit_time;
    private String total_time;
    private String flightno_sj;
    private String flightno_sl;
    private String sjdepTime;
    private String sjarrTime;
    private String sldepTime;
    private String slarrTime;
    private Double transit_hrs;
    private String hrs;
    private String mins;
    private String time;
    private String nextDay;
    
    public ComboFlight() {
        
    }
    
    public ComboFlight(String via, String flightno_sj, String flightno_sl, String sjdepTime, String sldepTime, String sjarrTime, String slarrTime, String transit_time, String total_time) {
        this.via  = via;
        this.flightno_sj = flightno_sj;
        this.flightno_sl = flightno_sl;
        this.sjdepTime = sjdepTime;
        this.sjarrTime = sjarrTime;
        this.sldepTime = sldepTime;
        this.slarrTime = slarrTime;
        this.transit_time = transit_time;
        this.total_time = total_time;
    }

    public String calcDayshort(String doj) throws ParseException {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
        d = sdf.parse(doj);
        sdf.applyPattern("EE");
        //System.out.println(sdf.format(d));
        return (sdf.format(d));
    }
    
    public String calcDaylong(String doj) throws ParseException {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
        d = sdf.parse(doj);
        sdf.applyPattern("EEEE");
        //System.out.println(sdf.format(d).toUpperCase());
        return (sdf.format(d).toUpperCase());
    }
    
    public Date dojDate(String doj) throws ParseException {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
        d = sdf.parse(doj);
        return d;
    }
    
    /**
     * @return the transit_time
     */
    public void calcTransit_time(String doj, Flight sj, Flight sl) throws ParseException {
        String sjarrTime =  sj.getArrival();
        String sldepTime = sl.getDepTime();
     
        Date d1 = null;
        Date d2 = null;
        
        String dateFormat1 = doj.concat(" "+sjarrTime);
        String dateFormat2 = doj.concat(" "+sldepTime);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yy hh:mm a");
        d1 = sdf1.parse(dateFormat1);
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM yy hhmm");   
        d2= sdf2.parse(dateFormat2);
        long diff = d2.getTime() - d1.getTime();
        double diffInHours = diff / ((double) 1000 * 60 * 60);
        if(sl.getFlightno_sl().equals("MI 471")) {
            diffInHours+=24;
        }
        setTransit_hrs((Double) diffInHours);
        //System.out.println("Hours " + (int)diffInHours);
        int diffInHrs = (int)diffInHours;
        double diffInMins = ((diffInHours - (int)diffInHours)*60);
        int dMins = (int) Math.round(diffInMins);
        //System.out.println("Minutes " + (int)((diffInHours - (int)diffInHours)*60) );
        transit_time = (Integer.toString(diffInHrs).concat(" hrs "+Integer.toString(dMins)+" mins"));
        //System.out.println("Transit Time = "+getTransit_time());
        
    }

    /**
     * @return the total_time
     */
    public void calcTotal_time(String doj, Flight sj, Flight sl) throws ParseException {
        
        String sjdepTime = sj.getDeparture();
        String sjarrTime =  sj.getArrival();
        
        String time = sl.getArrTime();
        StringTokenizer st = new StringTokenizer(time, "+");
        
        String slarrTime = st.nextToken();
        if(st.hasMoreTokens()) 
            setNextDay(st.nextToken());
        else   
            setNextDay("0");
        
        Date d1 = null;
        Date d2 = null;
        
        String dateFormat1 = doj.concat(" "+sjdepTime);
        String dateFormat2 = doj.concat(" "+slarrTime);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yy hh:mm a");
        d1 = sdf1.parse(dateFormat1);
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM yy hhmm");   
        if(getNextDay().equals("1")) {
            Calendar cal = Calendar.getInstance();
            cal.setTime( sdf2.parse( dateFormat2 ) );
            cal.add( Calendar.DATE, 1 );
            d2 = cal.getTime();
            //System.out.println(cal.getTime());
            //System.out.println(d1+" to "+d2);
        }
        else
            d2= sdf2.parse(dateFormat2);
        long diff = (d2.getTime() - d1.getTime()) - (150*60*1000);
        double diffInHours = (diff / ((double) 1000 * 60 * 60));
        if(sl.getFlightno_sl().equals("MI 471")) {
            diffInHours+=24;
        }
        //System.out.println("Hours " + (int)diffInHours);
        int diffInHrs = (int)diffInHours;
        hrs = String.format("%02d", diffInHrs);
        double diffInMins = ((diffInHours - (int)diffInHours)*60);
        int dMins = (int) Math.round(diffInMins);
        mins = String.format("%02d", dMins);
        total_time = hrs.concat(mins);
       
    }
    
    public List<String> daysSJ(Flight sj) {
        StringTokenizer st = new StringTokenizer(sj.getFrequency(), ",");
        List<String> sjdayslist = new ArrayList();
        while(st.hasMoreTokens()) {
            sjdayslist.add(st.nextToken().trim());
        }
        //System.out.println(sjdayslist);
        return sjdayslist;
    }
    
    public List<String> daysSL(Flight sl) {
        StringTokenizer st = new StringTokenizer(sl.getDays(), ",");
        List<String> sldayslist = new ArrayList();
        while(st.hasMoreTokens()) {
            sldayslist.add(st.nextToken());
        }
        //System.out.println(sldayslist);
        return sldayslist;
    }
    
    public Date dateSJmin(Flight sj) throws ParseException {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
        d = sdf.parse(sj.getEffective_from());
        
        return d;
    }
    
    public Date dateSJmax(Flight sj) throws ParseException {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
        d = sdf.parse(sj.getEffective_till());
        //System.out.println("**********"+d);
        return d;
    }
    
    public boolean dateSL(Flight sl, Date d) throws ParseException {
        StringTokenizer st = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
        String monthdate = null;
        String month = null;
        String concatdate = null;
        Date dmin = null;
        Date dmax = null;
        boolean a=false;
        if(sl.getRemarks_sl().contains(".") && sl.getRemarks_sl().indexOf(",")==-1) {
            String effect = null;
            String date = null;
            st = new StringTokenizer(sl.getRemarks_sl(), ".");
            while(st.hasMoreTokens()) {
                effect = st.nextToken();
                date = st.nextToken().trim();
            }
            if(effect.equals("Eff")) {
                String datemax = "13 NOV 16";
                month = date.substring(0, 3);
                monthdate = String.format("%02d", Integer.parseInt(date.substring(3)));
                concatdate = monthdate+" "+month+" 16";
                dmin = sdf.parse(concatdate);
                dmax = sdf.parse(datemax);    
                //System.out.println(dmin + " - " + dmax);
                if(d.compareTo(dmin)>=0 && d.compareTo(dmax)<=0) {
                    //System.out.println("true");
                    a= true;
                }
            }
            else if(effect.equals("Disc")) {
                String datemin = "01 OCT 16";
                month = date.substring(0, 3);
                monthdate = String.format("%02d", Integer.parseInt(date.substring(3)));
                concatdate = monthdate+" "+month+" 16";
                dmin = sdf.parse(datemin);
                dmax = sdf.parse(concatdate);    
                //System.out.println(dmin + " - " + dmax);
                if(d.compareTo(dmin)>=0 && d.compareTo(dmax)<=0) {
                    //System.out.println("true");
                    a=true;
                }
            }
        }
        
        else if(sl.getRemarks_sl().contains("-")) {
            String monthdate1 = null;
            String month1 = null;
            String concatdate1 = null;
            st = new StringTokenizer(sl.getRemarks_sl(), "-");
            String date1 = null;
            String date2 = null;
            while(st.hasMoreTokens()) {
                date1 = st.nextToken().trim();
                date2 = st.nextToken().trim();
            }
            month = date1.substring(0, 3);
            monthdate = String.format("%02d", Integer.parseInt(date1.substring(3)));
            concatdate = monthdate+" "+month+" 16";
            month1 = date2.substring(0, 3);
            monthdate1 = date2.substring(3);
            concatdate1 = monthdate1+" "+month1+" 16";
            dmin = sdf.parse(concatdate);
            dmax = sdf.parse(concatdate1);
            //System.out.println(dmin + " - " + dmax);
            if(d.compareTo(dmin)>=0 && d.compareTo(dmax)<=0) {
                //System.out.println("true");
                a=true;
            }
        }
        
        else if(sl.getRemarks_sl().contains(",")) {
            String effect1 = null;
            String date = null;
            String p1 = sl.getRemarks_sl().substring(0, 11);
            String p2 = sl.getRemarks_sl().substring(13);
            st = new StringTokenizer(p1, ".");
            while(st.hasMoreTokens()) {
                effect1 = st.nextToken();
                date = st.nextToken().trim();
            }
            if(effect1.equals("Disc")) {
                String datemin = "01 OCT 16";
                month = date.substring(0, 3); 
                monthdate = String.format("%02d", Integer.parseInt(date.substring(3))); 
                concatdate = monthdate+" "+month+" 16"; 
                dmin = sdf.parse(datemin);  
                dmax = sdf.parse(concatdate);  
                //System.out.println(dmin + " - " + dmax);
                if(d.compareTo(dmin)>=0 && d.compareTo(dmax)<=0) {
                    //System.out.println("true");
                    a=true;
                    //return true;
                }
            }
            
            StringTokenizer st1 = new StringTokenizer(p2, ",");
            String part1 = null;
            String date2 = null;
            String date3 = null;
            while(st1.hasMoreTokens()) {
                part1 = st1.nextToken(); 
                date2 = st1.nextToken().trim();
                date3 = st1.nextToken().trim();
            }
            
            //System.out.println(part1+"-"+date2+"-"+date3);
            String effect2 = part1.substring(0, 3);
            date = part1.substring(5);
            //System.out.println(effect2+" - "+date);
            String month1 = date.substring(0, 3);
            String monthdate1 = String.format("%02d", Integer.parseInt(date.substring(3)));
            String concatdate1 = monthdate1+" "+month1+" 16";
            String month2 = date2.substring(0, 3);
            String monthdate2 = String.format("%02d", Integer.parseInt(date2.substring(3)));
            String concatdate2 = monthdate2+" "+month2+" 16";
            String month3 = date3.substring(0, 3);
            String monthdate3 = String.format("%02d", Integer.parseInt(date3.substring(3)));
            String concatdate3 = monthdate3+" "+month3+" 16";
            
            if(effect2.equals("Exc")) {
                Date d1 = sdf.parse(concatdate1);
                Date d2 = sdf.parse(concatdate2);
                Date d3 = sdf.parse(concatdate3);
                //System.out.println(d1+"_"+d2+"_"+d3);
                if(d.compareTo(d1)==0 && d.compareTo(d2)==0 && d.compareTo(d3)==0) {
                    //System.out.println("true");
                    a=false;
                }
            }
        }
        else if(sl.getRemarks_sl().equals("")) {
            //System.out.println("true");
            a=true;
        }
        //System.out.println("false");
        else
            a=false;
        return a;
    }
    
    
    public void originCodes(Flight sj) {
            if(sj.getOrigin().equals("DELHI"))
                sj.setOriginCode("DEL");
            else if(sj.getOrigin().equals("MUMBAI"))
                sj.setOriginCode("BOM");
            else if(sj.getOrigin().equals("PUNE"))
                sj.setOriginCode("PNQ");
    }
    
    public void destinationCodes(Flight sj) {
        if(sj.getDestination().equals("BENGALURU"))
            sj.setDestinationCode("BLR");
            else if(sj.getDestination().equals("CHENNAI"))
                sj.setDestinationCode("MAA");
            else if(sj.getDestination().equals("HYDERABAD"))
                sj.setDestinationCode("HYD");
            else if(sj.getDestination().equals("KOLKATA"))
                sj.setDestinationCode("CCU");
    }
    
    public void sectorCodes(Flight sl) {
        if(sl.getSector().equals("Bengaluru (BLR)"))
            sl.setSectorCode("BLR");
        else if(sl.getSector().equals("Chennai (MAA)"))
            sl.setSectorCode("MAA");
        else if(sl.getSector().equals("Hyderabad (HYD)"))
            sl.setSectorCode("HYD");
        else if(sl.getSector().equals("Kolkata (CCU)"))
            sl.setSectorCode("CCU");
    }

    /**
     * @return the transit_time
     */
    public String getTransit_time() {
        return transit_time;
    }

    /**
     * @return the total_time
     */
    public String getTotal_time() {
        
        //System.out.println(total_time);
        return total_time;
    }

    /**
     * @return the total_hrs
     */

    @Override
    public int compareTo(ComboFlight t) {
        return this.getTotal_time().compareTo(t.getTotal_time());
        //return 0;
    }

    /**
     * @return the transit_hrs
     */
    public Double getTransit_hrs() {
        return transit_hrs;
    }

    /**
     * @param transit_hrs the transit_hrs to set
     */
    public void setTransit_hrs(Double transit_hrs) {
        this.transit_hrs = transit_hrs;
    }

    /**
     * @return the via
     */
    public String getVia() {
        return via;
    }

    /**
     * @param via the via to set
     */
    public void setVia(String via) {
        this.via = via;
    }

    /**
     * @return the flightno_sj
     */
    public String getFlightno_sj() {
        return flightno_sj;
    }

    /**
     * @param flightno_sj the flightno_sj to set
     */
    public void setFlightno_sj(String flightno_sj) {
        this.flightno_sj = flightno_sj;
    }

    /**
     * @return the flightno_sl
     */
    public String getFlightno_sl() {
        return flightno_sl;
    }

    /**
     * @param flightno_sl the flightno_sl to set
     */
    public void setFlightno_sl(String flightno_sl) {
        this.flightno_sl = flightno_sl;
    }

    /**
     * @return the sjdepTime
     */
    public String getSjdepTime() {
        return sjdepTime;
    }

    /**
     * @param sjdepTime the sjdepTime to set
     */
    public void setSjdepTime(String sjdepTime) {
        this.sjdepTime = sjdepTime;
    }

    /**
     * @return the sjarrTime
     */
    public String getSjarrTime() {
        return sjarrTime;
    }

    /**
     * @param sjarrTime the sjarrTime to set
     */
    public void setSjarrTime(String sjarrTime) {
        this.sjarrTime = sjarrTime;
    }

    /**
     * @return the sldepTime
     */
    public String getSldepTime() {
        return sldepTime;
    }

    /**
     * @param sldepTime the sldepTime to set
     */
    public void setSldepTime(String sldepTime) {
        this.sldepTime = sldepTime;
    }

    /**
     * @return the slarrTime
     */
    public String getSlarrTime() {
        return slarrTime;
    }

    /**
     * @param slarrTime the slarrTime to set
     */
    public void setSlarrTime(String slarrTime) {
        this.slarrTime = slarrTime;
    }

    /**
     * @param transit_time the transit_time to set
     */
    public void setTransit_time(String transit_time) {
        this.transit_time = transit_time;
    }

    /**
     * @param total_time the total_time to set
     */
    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the nextDay
     */
    public String getNextDay() {
        return this.nextDay;
    }

    /**
     * @param nextDay the nextDay to set
     */
    public void setNextDay(String nextDay) {
        this.nextDay = nextDay;
    }
    
    
 
}
    