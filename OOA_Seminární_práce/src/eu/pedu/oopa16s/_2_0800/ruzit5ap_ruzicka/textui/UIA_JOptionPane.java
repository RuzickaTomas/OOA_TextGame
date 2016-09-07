/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.textui;

import eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import eu.pedu.adv16s_fw.game_txt.IGame;
import eu.pedu.adv16s_fw.game_txt.IUI;
import eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game.SpyGame;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tomáš
 */
public class UIA_JOptionPane implements IUI{

    private IGame game;
    
    @Override
    public IGame getGame() {
        return game;
    }
     @Override
    public void startGame() {
         startGame(SpyGame.getInstance());
    }

    @Override
    public void startGame(IGame game) {
      Component parent =  new JFrame();
      parent.setLocation(100, 100);
      parent.setVisible(true);
      
      String command = "", answer;
      answer = game.executeCommand(command);
    
        do {            
            command = JOptionPane.showInputDialog(parent, answer);
            answer = game.executeCommand(command);
            
        } while (game.isAlive());
    
      JOptionPane.showMessageDialog(parent, answer); 
      System.exit(0);
    
   
    }

    @Override
    public Class<? extends IGSMFactory> getFactoryClass() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthorName() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthorID() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }
 
       public static void main(String[] args) {
         new UIA_JOptionPane().startGame();
      
    }
}
