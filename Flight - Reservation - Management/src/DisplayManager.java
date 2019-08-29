/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import datechooser.model.multiple.Period;
import java.awt.Font;
import java.io.*;
import java.text.ParseException;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.Document;
/**
 * 
 * @author Rajat Mishra
 */
public class DisplayManager {
    public screen_1 screen1;
    public screen_2 screen2;
    public screen_3 screen3;
    public screen_4 screen4;
    FRSManager mgr;
    //ArrayList <ComboFlight> details=new ArrayList <ComboFlight>();
    public DisplayManager(FRSManager mgr) {
        this.mgr = mgr;
        this.screen1=new screen_1(this);
        this.screen2=new screen_2(this);
        this.screen3=new screen_3(this);
        this.screen4=new screen_4(this);
    }
    public DisplayManager(){
       
    }
    public void showScreen1() {
       screen1.setVisible(true);
    }
    
    public void showScreen2(int passno,String depCity,String doj) throws ParseException, IOException {
      screen2.FromT0.setText(screen1.From.getSelectedItem()+"  TO  "+screen1.To.getSelectedItem());
      String  date = screen1.Date.getSelection().toString();
       date=date.substring(1, date.length()-1);
        screen2.date2.setText("DOJ : "+date);
        screen2.passenger2.setText("PASSENGERS :\n "+screen1.Passenger.getValue());
        ArrayList<ComboFlight> details= new ArrayList();
        details=this.mgr.searchMgr.searchFlight(passno,depCity,doj,this.mgr.spicejet,this.mgr.silkair);
        for(ComboFlight f : details)
        {
             String l= f.getVia()+","+f.getFlightno_sj()+"/"+f.getFlightno_sl()+","+f.getSjdepTime()+"/"+f.getSldepTime()+","+f.getSjarrTime()+"/"+f.getSlarrTime()+","+f.getTransit_time()+","+f.getTotal_time().substring(0, 2)+" hrs "+f.getTotal_time().substring(2, 4)+" mins";
             DefaultTableModel tableModel;
            tableModel = (DefaultTableModel) screen2.Table.getModel();
            tableModel.addRow(l.split(","));
        }
        screen2.setVisible(true);
        }
    public void showScreen3(){
        
        screen2.setVisible(false);
        screen3.setVisible(true);
        int index = screen2.Table.getSelectedRow();
        DefaultTableModel tableModel;
            tableModel = (DefaultTableModel) screen2.Table.getModel();
            String Via=tableModel.getValueAt(index, 0).toString();
            String Flight= tableModel.getValueAt(index, 1).toString();
            String Departure=tableModel.getValueAt(index,2).toString();
            String Arrival=tableModel.getValueAt(index, 3).toString();
            String Transit=tableModel.getValueAt(index, 4).toString();
           String TotalDuration=tableModel.getValueAt(index, 5).toString();
            screen3.Via.setText(Via);
             screen3.FromViaTo.setText(screen1.From.getSelectedItem()+"--->"+Via+"--->"+screen1.To.getSelectedItem());
            screen3.Flight.setText(Flight);
            screen3.Departure.setText(Departure);
            screen3.Arrival.setText(Arrival);
            screen3.Transit.setText(Transit);
            screen3.TotalDuration.setText(TotalDuration);
    }
    public void showScreen4(){
         screen3.setVisible(false);
        screen4.setVisible(true);
        int p=(int) (1000000 * (Math.random()))+1;
        String pnr=Integer.toString(p);
        screen4.Pnr.setText("PNR : "+pnr);
         screen4.Via.setText(screen3.Via.getText());
            screen4.Flight.setText(screen3.Flight.getText());
            screen4.Departure.setText(screen3.Departure.getText());
            screen4.Arrival.setText(screen3.Arrival.getText());
            screen4.Transit.setText(screen3.Transit.getText());
            screen4.TotalDuration.setText(screen3.TotalDuration.getText());
    }
    
    public void exitFRS() {
        screen4.setVisible(false);
        System.exit(0);
    }
    public void CallFrs(int passno,String depCity,String doj){
        //mgr.dspCallfrs(mgr, passno, depCity, doj);
    }
            
}
