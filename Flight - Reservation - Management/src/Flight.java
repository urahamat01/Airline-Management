/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shanu
 */
import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Flight {
    
    private String origin;
    private String destination;
    private String frequency;
    private String flightno_sj;
    private String departure;
    private String arrival;
    private String via;
    private String effective_from;
    private String effective_till;
    private String remarks_sj;
    
    private String sector;
    private String days;
    private String flightno_sl;
    private String depTime;
    private String arrTime;
    private String remarks_sl;
    
    private String originCode;
    private String destinationCode;
    private String sectorCode;
    private String finalDestination = "SIN";

    //for spicejet flights
    public Flight(String origin, String destination, String frequency, String flightno_sj, String departure, String arrival, String via, String effective_from, String effective_till, String remarks_sj) {
        this.origin = origin;
        this.destination = destination;
        this.frequency = frequency;
        this.flightno_sj = flightno_sj;
        this.departure = departure;
        this.arrival = arrival;
        this.via = via;
        this.effective_from = effective_from;
        this.effective_till = effective_till;
        this.remarks_sj = remarks_sj;
    }
    
    //for silkair flights
    public Flight(String sector, String days, String flightno_sl, String depTime, String arrTime, String remarks_sl) {
        this.sector = sector;
        this.days = days;
        this.flightno_sl = flightno_sl;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.remarks_sl = remarks_sl;
    }
    
    /**
     * @return the origin
     */
    public String getOrigin() {
        //System.out.println(origin);
        return origin;
        
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the frequency
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
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
     * @return the departure
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /**
     * @return the arrival
     */
    public String getArrival() {
        return arrival;
    }

    /**
     * @param arrival the arrival to set
     */
    public void setArrival(String arrival) {
        this.arrival = arrival;
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
     * @return the effective_from
     */
    public String getEffective_from() {
        return effective_from;
    }

    /**
     * @param effective_from the effective_from to set
     */
    public void setEffective_from(String effective_from) {
        this.effective_from = effective_from;
    }

    /**
     * @return the effective_till
     */
    public String getEffective_till() {
        return effective_till;
    }

    /**
     * @param effective_till the effective_till to set
     */
    public void setEffective_till(String effective_till) {
        this.effective_till = effective_till;
    }

    /**
     * @return the remarks_sj
     */
    public String getRemarks_sj() {
        return remarks_sj;
    }

    /**
     * @param remarks_sj the remarks_sj to set
     */
    public void setRemarks_sj(String remarks_sj) {
        this.remarks_sj = remarks_sj;
    }

    /**
     * @return the sector
     */
    public String getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * @return the days
     */
    public String getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(String days) {
        this.days = days;
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
     * @return the depTime
     */
    public String getDepTime() {
        return depTime;
    }

    /**
     * @param depTime the depTime to set
     */
    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    /**
     * @return the arrTime
     */
    public String getArrTime() {
        return arrTime;
    }

    /**
     * @param arrTime the arrTime to set
     */
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    /**
     * @return the remarks_sl
     */
    public String getRemarks_sl() {
        return remarks_sl;
    }

    /**
     * @param remarks_sl the remarks_sl to set
     */
    public void setRemarks_sl(String remarks_sl) {
        this.remarks_sl = remarks_sl;
    }

    /**
     * @return the originCode
     */
    public String getOriginCode(Flight t) {
        return t.originCode;
    }

    /**
     * @param originCode the originCode to set
     */
    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    /**
     * @return the destinationCode
     */
    public String getDestinationCode(Flight t) {
        return t.destinationCode;
    }

    /**
     * @param destinationCode the destinationCode to set
     */
    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    /**
     * @return the sectorCode
     */
    public String getSectorCode(Flight t) {
        return t.sectorCode;
    }

    /**
     * @param sectorCode the sectorCode to set
     */
    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    /**
     * @return the finalDestination
     */
    public String getFinalDestination() {
        return finalDestination;
    }
    
}
