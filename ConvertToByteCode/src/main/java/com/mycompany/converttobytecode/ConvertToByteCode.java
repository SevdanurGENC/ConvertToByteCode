package com.mycompany.converttobytecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nano
 */
public class ConvertToByteCode extends javax.swing.JFrame {

    /**
     * Creates new form ConvertToByteCode
     */
    public ConvertToByteCode() {
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Convert To ByteCode");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 200));
        setMaximizedBounds(new java.awt.Rectangle(500, 500, 505, 500));
        setMaximumSize(new java.awt.Dimension(600, 500));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1950, 1300));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 310, 920, 900);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(960, 310, 910, 900);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("Convert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1670, 130, 180, 80);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton2.setText("Open");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(490, 130, 180, 80);

        jTextField1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(710, 150, 930, 50);

        jButton3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton3.setText("SAVE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(490, 30, 180, 80);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jRadioButton1.setText("Creat a Java File and ByteCode");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(40, 40, 610, 40);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jRadioButton2.setText("Create Only ByteCode");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(40, 140, 520, 60);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("ByteCode : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(960, 250, 200, 50);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Java Code : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 242, 200, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public File filePathName;
    public JFileChooser chooser;
    public BufferedReader in = null;
    public String javaFileName = null;
    public String pathNameOfTemp = "C:\\Users\\Nano\\Documents\\NetBeansProjects\\ConvertToByteCode\\temp\\";
    public String getDirectory = "C:\\Users\\Nano\\Documents\\NetBeansProjects\\ConvertToByteCode\\temp\\";
    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        chooser = new JFileChooser(getDirectory);
        
        int returnVal = chooser.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                filePathName = chooser.getSelectedFile();
                javaFileName = filePathName.getName();
                javaFileName = javaFileName.substring(0, javaFileName.indexOf("."));
                
                jTextField1.setText(filePathName.toString());
                in = new BufferedReader(new FileReader(filePathName));
                String line = in.readLine();
                jTextArea1.setText("");
                while (line != null) {
                    jTextArea1.append(line + "\n");
                    line = in.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ConvertToByteCode.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConvertToByteCode.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(ConvertToByteCode.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        saveClassAndByteCode();

    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void saveClassAndByteCode() {
        
        try {
            GenClass.generateClass(pathNameOfTemp, javaFileName);
            ByteCodeEditor.Main(pathNameOfTemp, javaFileName);
            
            in = new BufferedReader(new FileReader(new File(pathNameOfTemp + javaFileName + "_ByteCode.txt")));
            String line = in.readLine();
            jTextArea2.setText("");
            while (line != null) {
                jTextArea2.append(line + "\n");
                line = in.readLine();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ConvertToByteCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        FileWriter pw = null;
        try {
            javaFileName = JOptionPane.showInputDialog("Java File icin bir isim veriniz : ");
            pw = new FileWriter(getDirectory + javaFileName + ".java");
            jTextArea1.write(pw);
            saveClassAndByteCode();
        } catch (IOException ex) {
            Logger.getLogger(ConvertToByteCode.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pw.close();
            } catch (IOException ex) {
                Logger.getLogger(ConvertToByteCode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        
        jTextArea1.setText("");
        jTextField1.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(true);

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       
        jTextArea1.setText("");
        jTextField1.setEnabled(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConvertToByteCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvertToByteCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvertToByteCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvertToByteCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvertToByteCode().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
