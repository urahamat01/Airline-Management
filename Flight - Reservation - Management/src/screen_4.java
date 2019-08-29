/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Rajat Mishra
 */
import AppPackage.AnimationClass;
import java.awt.*;
import javax.swing.ImageIcon;
public class screen_4 extends javax.swing.JFrame {
private DisplayManager mgr;
public screen_4(DisplayManager mgr) {
        this.mgr = mgr;
        initComponents();
        setIcon();
    }
    /**
     * Creates new form screen_4
     */
    public screen_4() {
        initComponents();
        setIcon();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnr = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Fields = new javax.swing.JLabel();
        Via = new javax.swing.JLabel();
        Flight = new javax.swing.JLabel();
        Arrival = new javax.swing.JLabel();
        Departure = new javax.swing.JLabel();
        Transit = new javax.swing.JLabel();
        TotalDuration = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ExitButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Confitmation");
        setBackground(new java.awt.Color(255, 255, 0));
        setBounds(new java.awt.Rectangle(500, 150, 330, 550));
        setLocation(new java.awt.Point(500, 200));
        setMinimumSize(new java.awt.Dimension(960, 610));
        setResizable(false);
        getContentPane().setLayout(null);

        Pnr.setFont(new java.awt.Font("Microsoft JhengHei", 1, 36)); // NOI18N
        Pnr.setForeground(new java.awt.Color(153, 153, 153));
        Pnr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Pnr);
        Pnr.setBounds(10, 170, 940, 60);

        jPanel1.setBackground(new java.awt.Color(202, 11, 23));
        jPanel1.setLayout(null);

        Fields.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Fields.setForeground(new java.awt.Color(153, 153, 153));
        Fields.setText("   VIA                          FLIGHT                        DEPARTURE                             ARRIVAL                      TRANSIT TIME        TOTAL DURATION");
        jPanel1.add(Fields);
        Fields.setBounds(0, 0, 960, 30);

        Via.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Via.setForeground(new java.awt.Color(255, 255, 255));
        Via.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(Via);
        Via.setBounds(0, 40, 110, 80);

        Flight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Flight.setForeground(new java.awt.Color(255, 255, 255));
        Flight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Flight);
        Flight.setBounds(90, 40, 170, 80);

        Arrival.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Arrival.setForeground(new java.awt.Color(255, 255, 255));
        Arrival.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Arrival);
        Arrival.setBounds(450, 40, 190, 80);

        Departure.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Departure.setForeground(new java.awt.Color(255, 255, 255));
        Departure.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Departure);
        Departure.setBounds(260, 40, 190, 80);

        Transit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Transit.setForeground(new java.awt.Color(255, 255, 255));
        Transit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Transit);
        Transit.setBounds(650, 40, 140, 80);

        TotalDuration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalDuration.setForeground(new java.awt.Color(255, 255, 255));
        TotalDuration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(TotalDuration);
        TotalDuration.setBounds(790, 40, 170, 80);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 260, 960, 130);

        jLabel2.setBackground(new java.awt.Color(202, 11, 23));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THANK YOU");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-80, 0, 960, 110);

        ExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exitdefault.png"))); // NOI18N
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitButtonMouseExited(evt);
            }
        });
        getContentPane().add(ExitButton);
        ExitButton.setBounds(280, 500, 220, 50);

        jLabel1.setBackground(new java.awt.Color(202, 11, 23));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen2.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseEntered
       ImageIcon search1 = new ImageIcon(getClass().getResource("/Images/exitover.png"));
        ExitButton.setIcon(search1);
    }//GEN-LAST:event_ExitButtonMouseEntered

    private void ExitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseExited
        ImageIcon search1 = new ImageIcon(getClass().getResource("/Images/exitdefault.png"));
        ExitButton.setIcon(search1);
    }//GEN-LAST:event_ExitButtonMouseExited

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        mgr.exitFRS();
    }//GEN-LAST:event_ExitButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Arrival;
    public javax.swing.JLabel Departure;
    private javax.swing.JLabel ExitButton;
    private javax.swing.JLabel Fields;
    public javax.swing.JLabel Flight;
    public javax.swing.JLabel Pnr;
    public javax.swing.JLabel TotalDuration;
    public javax.swing.JLabel Transit;
    public javax.swing.JLabel Via;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Icon.png")));
    }
}
