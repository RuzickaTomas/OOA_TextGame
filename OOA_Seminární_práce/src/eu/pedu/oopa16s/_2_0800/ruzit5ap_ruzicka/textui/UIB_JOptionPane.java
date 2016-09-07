/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.textui;

import eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import eu.pedu.adv16s_fw.game_txt.IGame;
import eu.pedu.adv16s_fw.game_txt.IUI;
import eu.pedu.adv16s_fw.test_util.common.TestUtilitiy;
import eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game.HraScenarioManager;
import eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game.SpyGame;
import java.awt.Color;
import java.awt.Component;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tomáš
 */
public class UIB_JOptionPane implements IUI{

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
        Scanner scanner = new Scanner(System.in);
        String command = "";
        String answer;
   
        for (;;)
        {
        answer = game.executeCommand(command);
            System.out.println(answer);
            if (!game.isAlive()) {
                break;
            }
            command = scanner.nextLine();
        }
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
         new UIB_JOptionPane().startGame();
      
    }
}
