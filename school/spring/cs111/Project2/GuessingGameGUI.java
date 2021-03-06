


/*
Name: Shayna Stewart
Date: 3/10/16
Project 2
 */

/**
 *
 * @author Shayna
 */
import java.util.Random;
public class GuessingGameGUI extends javax.swing.JFrame {
        Random rand = new Random();
        int value = rand.nextInt(32)+1;
        int intHighGuesses = 0;
        int intLowGuesses = 0;
        int intTotalGuesses = 0;
        
    /**
     * Creates new form NewJFrame
     */
    public GuessingGameGUI() {
        initComponents();
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        highGuesses = new javax.swing.JTextField();
        highGuessesLabel = new javax.swing.JLabel();
        lowGuessesLabel = new javax.swing.JLabel();
        lowGuesses = new javax.swing.JTextField();
        totalGuessesLabel = new javax.swing.JLabel();
        totalGuesses = new javax.swing.JTextField();
        guess = new javax.swing.JTextField();
        guessButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        letsPlayLabel = new javax.swing.JLabel();
        chatBox = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("High Guesses");
        setBackground(new java.awt.Color(255, 153, 153));
        setForeground(new java.awt.Color(255, 153, 153));

        highGuesses.setText("0");
        highGuesses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highGuessesActionPerformed(evt);
            }
        });

        highGuessesLabel.setText("High Guesses:");

        lowGuessesLabel.setText("Low Guesses:");

        lowGuesses.setText("0");
        lowGuesses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowGuessesActionPerformed(evt);
            }
        });

        totalGuessesLabel.setText("Total Guesses:");

        totalGuesses.setText("0");
        totalGuesses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalGuessesActionPerformed(evt);
            }
        });

        guess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessActionPerformed(evt);
            }
        });

        guessButton.setText("Guess!");
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        letsPlayLabel.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        letsPlayLabel.setText("Guessing Game");

        chatBox.setForeground(new java.awt.Color(255, 0, 51));
        chatBox.setText("Enter a number between 1 and 32!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(guess, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(guessButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(highGuessesLabel)
                                    .addComponent(lowGuessesLabel))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(highGuesses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lowGuesses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalGuessesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalGuesses, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chatBox, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(letsPlayLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(letsPlayLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessButton)
                    .addComponent(clearButton))
                .addGap(18, 18, 18)
                .addComponent(chatBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalGuesses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalGuessesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lowGuesses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowGuessesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(highGuessesLabel)
                    .addComponent(highGuesses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        value = rand.nextInt(32)+1;
        intHighGuesses = 0;
        intLowGuesses = 0;
        intTotalGuesses = 0;
        highGuesses.setText("0");
        totalGuesses.setText("0");
        lowGuesses.setText("0");
        guess.setText("");
        
        chatBox.setText("Enter a number between 1 and 32!");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void highGuessesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highGuessesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_highGuessesActionPerformed

    private void lowGuessesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowGuessesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lowGuessesActionPerformed

    private void totalGuessesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalGuessesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalGuessesActionPerformed

    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed

        String guessActionPerformed = guess.getText();
        int intGuess = Integer.parseInt(guessActionPerformed);
        intTotalGuesses++;

        if (intGuess == value) {

            chatBox.setText("You win! The number was " + value + "!"
            + " Press Clear to begin again.");
           

        }

        else if (intGuess == -1){

            chatBox.setText("Quitting so soon? The number was " + value 
                    + ". Press clear to try again.");
            
            intTotalGuesses--;
            guess.setText("");
        }

        else if (intGuess > value){

            chatBox.setText("Your guess is too high. Try again!");
            intHighGuesses++;
            guess.setText("");

        }
        else {

            chatBox.setText("Your guess is too low. Try again!");
            intLowGuesses++;
            guess.setText("");

        }
        String sTotalGuesses = "" + intTotalGuesses;
        String sHighGuesses = "" + intHighGuesses;
        String sLowGuesses = "" + intLowGuesses;
        totalGuesses.setText(String.valueOf(sTotalGuesses));
        lowGuesses.setText(String.valueOf(sLowGuesses));
        highGuesses.setText(String.valueOf(sHighGuesses));
    }//GEN-LAST:event_guessButtonActionPerformed

    private void guessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guessActionPerformed

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
            java.util.logging.Logger.getLogger(GuessingGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuessingGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuessingGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuessingGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuessingGameGUI().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chatBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField guess;
    private javax.swing.JButton guessButton;
    private javax.swing.JTextField highGuesses;
    private javax.swing.JLabel highGuessesLabel;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel letsPlayLabel;
    private javax.swing.JTextField lowGuesses;
    private javax.swing.JLabel lowGuessesLabel;
    private javax.swing.JTextField totalGuesses;
    private javax.swing.JLabel totalGuessesLabel;
    // End of variables declaration//GEN-END:variables
}
