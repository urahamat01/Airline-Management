

import java.awt.SplashScreen;
import static java.awt.SplashScreen.getSplashScreen;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * frsmanager
 * @author shanu
 */
public class FRSManager {
    
    DataManager dataMgr;
    DisplayManager displayMgr;
    SearchManager searchMgr;
    BookingManager bookingMgr;
    ArrayList<Flight> silkair;
    ArrayList<Flight> spicejet;
    ArrayList<ComboFlight> cf;
    public static void main(String[] args) throws ParseException, IOException {
         try{
                 Thread.sleep(1700);
            }
        catch(Exception e){
        
        }           
       
        
         FRSManager myMgr = new FRSManager();
        myMgr.dataMgr = new DataManager(myMgr);
        myMgr.silkair = myMgr.dataMgr.readSilkAir("2016.silkair.csv");
        myMgr.spicejet = myMgr.dataMgr.readSpiceJet("2016.spicejet.csv");
        myMgr.displayMgr = new DisplayManager(myMgr);
        
        myMgr.bookingMgr = new BookingManager(myMgr);
        myMgr.searchMgr = new SearchManager(myMgr);
        myMgr.displayMgr.showScreen1();
        
    }  
}
