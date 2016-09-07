/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

/**
 *
 * @author Tomáš
 */
public class State {
    
    private static boolean isOpen;
    
    private static boolean isConversation;
    
    private static boolean isMajor;
    
    static boolean isDoor() 
    {
        return isOpen;
    }
    
    static void setDoor(boolean unlock) 
    {
        isOpen = unlock;
    }
    

    static boolean isConversation()
    {
        return isConversation;
    }
    
    

      static boolean isMajor()
    {
        return isMajor;
    }

    static void setMajor(boolean isMajor)
    {
        State.isMajor = isMajor;
    }


    static void setConversation(boolean isConversation)
    {
        State.isConversation = isConversation;
    }
    
    
    static void initialize() {
        isOpen= false;
        isConversation = false;
        isMajor = false;
    }

    private State() {
    }
    
    
}
