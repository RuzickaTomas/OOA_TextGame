/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

import java.util.function.Function;

/**
 *
 * @author Tomáš
 */
public class Conversation {
    
    private static SpyItem enemy;
    
    private static Function<String, String> answerDep;
    
   
    
    static String start(SpyItem enemy) 
    {
    State.setConversation(true);
    Conversation .enemy = enemy;
    String enemyName = enemy.getName();
    answerDep = Conversation::userAnswer;
    return "Řekni heslo";
    }
    
   static String answer(String command) 
    {
        return answerDep.apply(command);
    }
   
   
   private static String userAnswer(String uAnswer) 
   {
   String odpoved = "";
   if (uAnswer == "Heslo") {
   odpoved = "Jdi dál";
   }
   return odpoved;
   }
   

}
