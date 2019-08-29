/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rajat Mishra
 */
public class screen_2 extends javax.swing.JFrame {
private DisplayManager mgr;
    /**
     * Creates new form Flight_Information
     */
    public screen_2() {
        initComponents();
        setIcon();
        showDate();
        showTime();
    }

    public screen_2(DisplayManager mgr) {
        this.mgr = mgr;
        initComponents();
        setIcon();
        showDate();
        showTime();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FromT0 = new javax.swing.JLabel();
        date2 = new javax.swing.JLabel();
        passenger2 = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        CurrentDate = new javax.swing.JLabel();
        ProceedButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flight Information");
        setBackground(new java.awt.Color(225, 10, 23));
        setBounds(new java.awt.Rectangle(400, 150, 700, 581));
        setMinimumSize(new java.awt.Dimension(1190, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        FromT0.setBackground(new java.awt.Color(226, 46, 59));
        FromT0.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        FromT0.setForeground(new java.awt.Color(255, 255, 255));
        FromT0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(FromT0);
        FromT0.setBounds(180, 0, 260, 100);

        date2.setBackground(new java.awt.Color(255, 255, 153));
        date2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        date2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(date2);
        date2.setBounds(480, 0, 190, 100);

        passenger2.setBackground(new java.awt.Color(226, 46, 59));
        passenger2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passenger2.setForeground(new java.awt.Color(255, 255, 255));
        passenger2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(passenger2);
        passenger2.setBounds(750, 0, 190, 100);

        Time.setBackground(new java.awt.Color(255, 255, 153));
        Time.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Time);
        Time.setBounds(1010, 60, 160, 50);

        CurrentDate.setBackground(new java.awt.Color(255, 255, 153));
        CurrentDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CurrentDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(CurrentDate);
        CurrentDate.setBounds(1010, 0, 160, 50);

        ProceedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Proceedbuttondefault.png"))); // NOI18N
        ProceedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProceedButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProceedButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProceedButtonMouseExited(evt);
            }
        });
        getContentPane().add(ProceedButton);
        ProceedButton.setBounds(1010, 540, 160, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 100, 100);

        Table.setBackground(new java.awt.Color(255, 204, 255));
        Table.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        Table.setForeground(new java.awt.Color(255, 102, 102));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VIA", "FLIGHTS", "DEPARTURE", "ARRIVAL", "TRANSIT TIME", "TOTAL DURATION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setGridColor(new java.awt.Color(0, 102, 255));
        Table.setRowHeight(40);
        Table.setRowMargin(5);
        Table.setSelectionBackground(new java.awt.Color(255, 153, 153));
        Table.setSelectionForeground(new java.awt.Color(255, 0, 51));
        Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(Table);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(22, 112, 1150, 400);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen2.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1190, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void ProceedButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProceedButtonMouseEntered
         ImageIcon search1 = new ImageIcon(getClass().getResource("/Images/Proceedbuttonover.png"));
        ProceedButton.setIcon(search1);
    }//GEN-LAST:event_ProceedButtonMouseEntered

    private void ProceedButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProceedButtonMouseExited
      ImageIcon search1 = new ImageIcon(getClass().getResource("/Images/Proceedbuttondefault.png"));
        ProceedButton.setIcon(search1);
    }//GEN-LAST:event_ProceedButtonMouseExited

    private void ProceedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProceedButtonMouseClicked
        if(Table.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "No Flights Available!\nTry Again Later :-(", "Information", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        else if(Table.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "No Selection Made\n;-)", "Information", JOptionPane.INFORMATION_MESSAGE);
        } 
        else {
            mgr.mgr.displayMgr.showScreen3();
    }//GEN-LAST:event_ProceedButtonMouseClicked
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CurrentDate;
    public javax.swing.JLabel FromT0;
    private javax.swing.JLabel ProceedButton;
    public javax.swing.JTable Table;
    private javax.swing.JLabel Time;
    public javax.swing.JLabel date2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel passenger2;
    // End of variables declaration//GEN-END:variables

private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Icon.png")));
    }
void showDate(){
    Date d=new Date();
    SimpleDateFormat s=new SimpleDateFormat("dd/MM/yy");
    CurrentDate.setText(s.format(d));
}
void showTime(){
    new Timer(0,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
              Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
            Time.setText(s.format(d));
        }

    }).start();
}

}
