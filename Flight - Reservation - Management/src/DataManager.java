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
public class DataManager {
    
    FRSManager mgr;
    
    public DataManager() {
        
    }
    
    public DataManager(FRSManager mgr) {
        this.mgr = mgr;
    }
        
        public ArrayList<Flight> readSpiceJet(String filepath) {
            ArrayList<Flight> mySJFlightList = new ArrayList<Flight>();
            String delimiter = "|";
            BufferedReader br = null;
            try {
                StringTokenizer st = null;
                br = new BufferedReader(new FileReader(filepath));
                String line = null;
                for(int i=0;i<5;i++)
                    br.readLine();
                    
                while((line = br.readLine())!= null) {
                    st = new StringTokenizer(line, delimiter);
                    while(st.hasMoreTokens()) {
                        String origin = st.nextToken();
                        String destination = st.nextToken();
                        String frequency = st.nextToken();
                        String flightno_sj = st.nextToken();
                        String departure = st.nextToken();
                        String arrival = st.nextToken();
                        String via = st.nextToken();
                        String effective_from = st.nextToken();
                        String effective_till = st.nextToken();
                        String remarks_sj = "";
                        Flight spicejet = new Flight(origin, destination, frequency, flightno_sj, departure, arrival, via, effective_from, effective_till, remarks_sj);
                        mySJFlightList.add(spicejet);
                    }
                }
                
            }
            catch (FileNotFoundException e) {
                System.out.println("The file was not found!\nEXTING...." + e.getMessage());
            }
            catch (IOException e) {
                System.out.println("The file could not be read!\nEXTING...." + e.getMessage());
            }
            catch(NullPointerException e)
            {
                System.out.println("FILE NOT PROVIDED\nEXITING....");
            }
            finally {
                try {
                    if(br != null) 
                        br.close();
                    } catch (IOException ex) { 
                        ex.printStackTrace();
                        }
            }
            return mySJFlightList;
        }
        
        public ArrayList<Flight> readSilkAir(String filepath) {
            ArrayList<Flight> mySLFlightList = new ArrayList<Flight>();
            String delimiter = "|";
            BufferedReader br = null;
            try {
                StringTokenizer st = null;
                StringTokenizer st2 = null;
                br = new BufferedReader(new FileReader(filepath));
                String line = null;
                String remarks_sl = null;
                for(int i=0;i<3;i++)
                    br.readLine();
                    
                while((line = br.readLine())!= null) {
                    st = new StringTokenizer(line, delimiter);
                    while(st.hasMoreTokens()) {
                        String sector = st.nextToken();
                        String days = st.nextToken();
                        String flightno_sl = st.nextToken();
                        String time = st.nextToken();
                        st2 = new StringTokenizer(time, "/");
                        String depTime = st2.nextToken();
                        String arrTime = st2.nextToken();
                        if(st.hasMoreTokens()) {
                            remarks_sl = st.nextToken();
                        }
                        else
                            remarks_sl = "";
                        Flight silkair = new Flight(sector, days, flightno_sl, depTime, arrTime, remarks_sl);
                        mySLFlightList.add(silkair);
                    }
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("The file was not found!\nEXTING...." + e.getMessage());
            }
            catch (IOException e) {
                System.out.println("The file could not be read!\n EXTING...." + e.getMessage());
            }
            catch(NullPointerException e)
            {
                System.out.println("FILE NOT PROVIDED\n EXTING....");
            }
            finally {
                try {
                    if(br != null) 
                        br.close();
                    } catch (IOException ex) { 
                        ex.printStackTrace();
                        }
            }
            return mySLFlightList;
        }
        
        
}        
