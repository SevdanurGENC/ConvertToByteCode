package com.mycompany.converttobytecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Convert To ByteCode");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 500));
        setMaximizedBounds(new java.awt.Rectangle(500, 500, 505, 500));
        setMaximumSize(new java.awt.Dimension(600, 500));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(2150, 1200));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 920, 900);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(1160, 170, 910, 900);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("Convert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(960, 550, 190, 180);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton2.setText("Open");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1390, 70, 180, 70);

        jTextField1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(290, 80, 1070, 50);

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


    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
