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
import com.opencsv.*;
import java.text.SimpleDateFormat;

public class BookingManager {
    private String name;
    private String doj;
    private int passno;
    private int numseatsavailable;
    private int numseatsremaining;
    private String bookingID;
    
    FRSManager mgr;
    DataManager dmgr;
    
    public BookingManager() {
        
    }
    
    public BookingManager(FRSManager mgr) {
        this.mgr = mgr;
    }
    
    /*public static void main(String args[]) {
        //System.out.println("Booking Screeen");
        
    }*/

    /*public String generateBookingID() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String c = null;
        String d="";
        for (int i=1; i<11; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
            for (int i=0; i<9; i++) {    
                c = list.get(i).toString();
                d=d+c;
                //System.out.print(c);
            }
            System.out.print(d);
            return "";
        }*/
    
    public boolean checkSeatsAvailability(int passno, String doj, Flight sj, Flight sl) throws ParseException, IOException {
        String filepath = "seatmatrix.csv";
        int row, column, monthdate, p=0;
        boolean x = false, y = false;
        String month;
        monthdate = Integer.parseInt(doj.substring(0, 2));
        month = doj.substring(3, 6);
        CSVReader csvReader = new CSVReader(new FileReader(new File(filepath)), ',' , '"');
        List<String[]> list = csvReader.readAll();
        // Convert to 2D array
        String[][] dataArr = new String[list.size()][];
        dataArr = list.toArray(dataArr);
        if(month.equals("NOV")) {
            p = 31;
        }
        p += monthdate;
        for(int i=1;i<42;i++) {
            if(sl.getFlightno_sl().equals(dataArr[i][0]) && passno<=Integer.parseInt(dataArr[i][p])) {
                x = true;
            }
            else if(sj.getFlightno_sj().equals(dataArr[i][0]) && passno<=Integer.parseInt(dataArr[i][p])) {
                y = true;
            }
            
        }
        //System.out.print(x+""+y);
        if(x == true && y==true) {
            return true;
        }
        else
            return false;
    }   
    
    public void updateSeats(int passno, String doj, ComboFlight mycf) throws FileNotFoundException, IOException, ParseException { 
        String filepath = "seatmatrix.csv";
        int row, column, monthdate, p=0;
        String month;
        monthdate = Integer.parseInt(doj.substring(0, 2));
        month = doj.substring(3, 6);
        CSVReader csvReader = new CSVReader(new FileReader(new File(filepath)), ',' , '"');
        List<String[]> list = csvReader.readAll();
        // Convert to 2D array
        String[][] dataArr = new String[list.size()][];
        dataArr = list.toArray(dataArr);
        /*for(int i=1;i<list.size();i++) {
            for(int j=1;j<45;j++) {
                //seat values in 2d-matrix
                row = i;
                column = j;
                //System.out.print(dataArr[i][j]);
                //System.out.println(this.numseatsavailable);
            }
            //System.out.println();
        }*/
        
        if(month.equals("NOV")) {
            p = 31;
        }
        p += monthdate;
        for(int i=1;i<42;i++) {
            if(dataArr[i][0].equals(mycf.getFlightno_sj())) {
                int k = Integer.parseInt(dataArr[i][p])-passno;
                dataArr[i][p] = ""+k;
            }
            else if(dataArr[i][0].equals(mycf.getFlightno_sl())) {
                int k = Integer.parseInt(dataArr[i][p])-passno;
                dataArr[i][p] = ""+k;    
            }
        }
        
        try {
            FileWriter bw = new FileWriter("output.csv");
            for(int i=0;i<42;i++) {
                for(int j=0;j<45;j++) {
                    bw.write(dataArr[i][j]+",");
                }
                bw.write("\n");
            }
            bw.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
            
            
        //}    
        //System.out.print(d1);
        
        /*String[] nextLine;
        String data = null;
        while ((nextLine = csvReader.readNext()) != null) {
            if (nextLine != null) {
                //Verifying the read data here
                data = Arrays.toString(nextLine);
                //System.out.println(Arrays.toString(nextLine));
                
            }
        }*/
        
        //this.numseatsremaining = this.numseatsavailable - 1;
    
    }
        
    public ArrayList<String> bookFlight(int passno, String doj, String name, ComboFlight mycf) {
        this.doj = doj;
        this.passno = passno;
        System.out.println("\nBooking Screen");
        BookingManager bkmgr = new BookingManager(mgr);        
        //String c = bkmgr.generateBookingID(); //10-digit random unique PNR
        //mycf is the comboflight user selects to book
        System.out.println("Via|SJFlightNo/SLFlightNo|SJDepTime/SLDepTime|SJArrTime/SLArrTime|Transit Time|Total Flight Time");
        System.out.println(mycf.getVia()+"|"+mycf.getFlightno_sj()+"/"+mycf.getFlightno_sl()+"|"+mycf.getSjdepTime()+"/"+mycf.getSldepTime()+"|"+mycf.getSjarrTime()+"/"+mycf.getSlarrTime()+"|"+mycf.getTransit_time()+"|"+mycf.getTotal_time().substring(0, 2)+" hrs "+mycf.getTotal_time().substring(7, 9)+" mins");
        
            System.out.println("Name: "+name);
            System.out.println("Date of travel: "+doj);
            System.out.println("No. of passengers: "+passno);
            System.out.print("Booking ID : ");
            //System.out.println(bkmgr.generateBookingID());
            int k=(int)(Math.random()*10000+1);
            this.bookingID = ""+doj.substring(0, 2)+name.substring(0, 3)+passno+k;
            System.out.println(this.bookingID);
            //updateSeats(doj, mycf);
            //this.flightbookingId = ;
            //System.out.println(this.flightbookingId);
            
            System.out.println("BOOKING SUCCESSFUL!"); 
            
        return null;
    }
    

}
