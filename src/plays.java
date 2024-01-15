/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class plays extends javax.swing.JFrame {

    /**
     * Creates new form plays
     */
    public   String [][]players = new String[2][2];
    public  String player;
    public  char [][] board =new char[3][3];
    public void initilize()
    {
            char[] initial={'a','b','c','d','e','f','g','h','i'};
            int k=0;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    
                    board[i][j]=initial[k];
                    k++;
                }
            }
            player=players[0][0];
           // p1.setVisible(true);
            //p2.setVisible(true);
            p1.setText(players[0][0]);
            p2.setText(players[1][0]);
            p1.setSelected(true);
            p2.setSelected(false);
            players[0][1]="O";
            players[1][1]="X";
            
            
    }
    public void getboard()
    {      
        String line ;
        out.setText(" ");
        for (int i = 0; i < 3; i++) {
            line="";
            for (int j = 0; j < 3; j++) {
                line += board[i][j] + "  |";
            }
           out.append(line+"\n----------\n");
        }

        
        
        
    }
     public  void playerswi()
    {
        if (player.equalsIgnoreCase(players[0][0]))
        {
            
            p2.setSelected(true);
            p1.setSelected(false);
            player=players[1][0];
            p2.setEnabled(true);
            p1.setEnabled(false);
          
        }
          else
        {
            player=players[0][0];
            
            p1.setSelected(true);
            p2.setSelected(false);
            p2.setEnabled(false);
            p1.setEnabled(true);

        }
    }
   public boolean full()
   {
       char[] initial={'a','b','c','d','e','f','g','h','i'};
       for(int i=0;i<3;i++)
       {
           for(int j=0;j<3;j++)
           {
               for(int k=0;k<9;k++)
               {
                   if(board[i][j]==initial[k])
                   {
                       return false;
                   }
                   
               }
           }
       }
       return true;
   }
   public boolean winner()
   {
       for(int i=0;i<3;i++)
       {
           if((board[i][0]==board[i][1]) && (board[i][0]==board[i][2]))
               return true;
           else
              if((board[0][i]==board[1][i]) && (board[0][i]==board[2][i]))
                  return true;
           else
                  if((board[0][0]==board[1][1]) && (board[2][2]==board[0][0]))
                      return true;
           else
                if((board[0][2]==board[1][1]) && (board[0][2]==board[2][0]))
                    return true;
                      
       }
       return false;
   }
   public  boolean errorcontrol(String input)
   {
       char[] initial={'a','b','c','d','e','f','g','h','i'};
       for(int k=0;k<9;k++)
           if(input.equalsIgnoreCase(String.valueOf(initial[k]))==true)
               return false;
       
       
       return true;
   }
   public String getvalid()
   {
       String line="";
       for(int i=0;i<3;i++)
            { 
                for(int j=0;j<3;j++)
                {
                    if(!(players[0][1].equalsIgnoreCase(String.valueOf(board[i][j]))) &&!(players[1][1].equalsIgnoreCase(String.valueOf(board[i][j]))))
                       line+=board[i][j]+" ";   
                }  
            }
       return line;
       
       
   }
    public  void play()
    { 
        String m;
        boolean s=false,g=false;
        m=JOptionPane.showInputDialog("Current Player: "+player+"\nValid Options are:"+getvalid()+"\nEnter box to play:");
        for(int i=0;i<3;i++)
            { 
                for(int j=0;j<3;j++)
                {
                   if(m.equalsIgnoreCase(String.valueOf(board[i][j]))==true)
                   {
                       if(m.equals(" "))
                           s=true;
                           
                       g=true;
                        for(int k=0;k<2;k++)
                         {
          
                            if(player.equals(players[k][0])==true)
                            {
                            board[i][j]=players[k][1].charAt(0);
                            
                            }

                         }
                   }
                  
                }   
            }
        
        if(full()==false && winner()==false && errorcontrol(m)==false && g==true && s==false)
        {
                 playerswi();
                 getboard();
                
        }
             
        
        else
            if(winner()==true)
            {
                getboard();
                JOptionPane.showMessageDialog(rootPane,"Congradulations "+player+"\nYou have won the game");
                addto.setEnabled(false);
                
            }
        else
                if(g==false)
                {
                    
                    JOptionPane.showMessageDialog(rootPane,"'"+m+"' is an Invalid Option\nValid Options are:"+getvalid());
                    play();
                    getboard();
                  
                }
        else
                    if(s==true)
                    {
                       JOptionPane.showMessageDialog(rootPane,"'"+m+"' is an Invalid Option\nValid Options are:"+getvalid());
                       play();
                       getboard(); 
                    }
    }

    
    public plays() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        p1 = new javax.swing.JRadioButton();
        p2 = new javax.swing.JRadioButton();
        play = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        out = new javax.swing.JTextArea();
        addto = new javax.swing.JToggleButton();
        Newgame = new javax.swing.JButton();
        Restart = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        p1.setText("jRadioButton1");

        p2.setText("jRadioButton2");

        play.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        play.setText("Current PLayer:");

        out.setColumns(20);
        out.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        out.setRows(5);
        jScrollPane1.setViewportView(out);

        addto.setText("Play");
        addto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoActionPerformed(evt);
            }
        });

        Newgame.setText("New Game");
        Newgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewgameActionPerformed(evt);
            }
        });

        Restart.setText("Restart");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Restart)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(Newgame, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(p1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addto)
                    .addComponent(Newgame)
                    .addComponent(Restart))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
       //setLocationRelativeTo(null);
       
      
    
        
        //getboard();
        //play();
        
    }//GEN-LAST:event_formWindowActivated
    public void validaten()
    {
        if(players[0][0].equals(""))
        {
           
            players[0][0] = JOptionPane.showInputDialog("Player 1 User Name Can not be Null\nEnter Player 1 User Name:");
            validaten();
        }
        else
            if(players[0][0].equalsIgnoreCase(players[1][0])&& (players[0][0].equals("")==false) )
            {
                
                 players[1][0] = JOptionPane.showInputDialog("User Names can not be the same\nEnter Player 2 User Name:");
                 validaten();
            }
            else if(players[1][0].equals(""))
            {
                players[1][0]=JOptionPane.showInputDialog("Player 2 User Name Can not be Null\nEnter Player 2 User Name:");
                validaten();
            }
                
            
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        initilize();
        getboard();
        setLocationRelativeTo(null);
         for (int i = 0; i < 2; i++) {
            players[i][0] = JOptionPane.showInputDialog("Enter Player " + (i + 1) + " User Name");
        }
         validaten();
            p2.setEnabled(false);
            p1.setEnabled(true);
         initilize();
       
        
      
    }//GEN-LAST:event_formWindowOpened

    private void addtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoActionPerformed
        // TODO add your handling code here:
        
        play();
    }//GEN-LAST:event_addtoActionPerformed

    private void RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartActionPerformed
        // TODO add your handling code here:
        initilize();
        getboard();
        addto.setEnabled(true);
        
        
    }//GEN-LAST:event_RestartActionPerformed

    private void NewgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewgameActionPerformed
        // TODO add your handling code here:
         initilize();
        getboard();
        setLocationRelativeTo(null);
         for (int i = 0; i < 2; i++) {
            players[i][0] = JOptionPane.showInputDialog("Enter Player " + (i + 1) + " User Name");
        }
         addto.setEnabled(true);
            p2.setEnabled(false);
            p1.setEnabled(false);
         initilize();
    }//GEN-LAST:event_NewgameActionPerformed

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
            java.util.logging.Logger.getLogger(plays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(plays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(plays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(plays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new plays().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Newgame;
    private javax.swing.JButton Restart;
    private javax.swing.JToggleButton addto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea out;
    private javax.swing.JRadioButton p1;
    private javax.swing.JRadioButton p2;
    private javax.swing.JLabel play;
    // End of variables declaration//GEN-END:variables
}
