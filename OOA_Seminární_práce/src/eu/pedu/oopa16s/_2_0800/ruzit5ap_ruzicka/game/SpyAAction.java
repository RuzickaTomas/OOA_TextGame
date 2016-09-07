/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

import eu.pedu.adv16s_fw.empty_classes.ANamed;
import eu.pedu.adv16s_fw.game_txt.IAction;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;





/**
 *
 * @author Tomáš
 */

abstract class SpyAAction extends ANamed implements IAction
{
//== CONSTANT CLASS FIELDS =====================================================
//== VARIABLE CLASS FIELDS =====================================================

     private static final Map<String, SpyAAction> NAME_2_ACTION;
     private static boolean isAlive;


//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
    /** Brief description of the given action. */
   

      static {
          isAlive = false;
          NAME_2_ACTION = new HashMap<>();
          new SpyHelpAction();
          new SpyMoveAction();
          new SpyTakeAction();
          new SpyPutAction();
          new SpyEndAction();   
          //Nestandartní  akce
          new SpyOpenAction();
          new SpySwitchAction();
          new SpyKillAction();
          new SpyUseAction();
    }
//== CLASS GETTERS AND SETTERS =================================================
   static boolean isAlive()
    {
      return isAlive;
    }
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
     static Collection<SpyAAction> getAllActions() 
     {
         Collection<SpyAAction> collection, result;
         collection = NAME_2_ACTION.values();
         result = Collections.unmodifiableCollection(collection);
         return result;
     
     }
 
      public static String executeCommand(String command){
     
         command = command.trim();
         String answer;
         if (isAlive) {
         answer = executeCommonComand(command);
//             answer = State.isConversation() ? Conversation.answer(command) :
//             executeCommonComand(command);
         }
         else 
         {
             answer = startGame(command);
         }
         return answer;
    }
   
     static void stopGame() 
    {
       isAlive = false;
    }
 
      
      private static void initialize() {
     
        Hands   .getInstance().initialize();
        SpyWorld.getInstance().initialize();
      //  State                 .initialize();
      
    }
      
      private static String executeCommonComand(String command)
      {
     if (command.isEmpty()) {return "Zadal jsi prázdný příkaz";}
     String[] words    = command.toLowerCase().split("\\s+"); 
     String actionName = words[0];
     SpyAAction action = NAME_2_ACTION.get(actionName);
     String answer;
   
     if (action == null) {
          answer = "Toto mi není známo";  
     } 
     else 
     {
          answer = action.execute(words);     

     }
     return answer;
     }

   private static String startGame(String command)
   {
    String answer;
    
        if (command.isEmpty()) {
               initialize();
               answer = "\n Vítejte ve hře SpyGame,"
                      + "\n Vaším úkolem je proplížit se kolem"
                      + "\n Stráží a zabít nepřítele. Hodně štěstí";
               isAlive = true;
               
           } else {
                answer = "\nThe first command is not the starting one.\n"
                          + "Game that does not run can be started "
                          + "only with a starting command.\n";
           }
     
        return answer;
    }     



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
    private final String description;
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

  
    /***************************************************************************
     * Creates the parent sub-object of the created action.
     *
     * @param name  Name of the created action = text, which the player has to
     *              enter as an initial word of the entered command
     * @param description Brief description of the created action
     */
    SpyAAction(String name, String description)
    {
        super(name);
        this.description = description;
        SpyAAction previous = NAME_2_ACTION.put(name.toLowerCase(), this);
        if (previous != null) {
         throw new IllegalArgumentException
        ("\n Akce s názvem "+name+" byla již vytvořena");
        }
    }


    
//== ABSTRACT METHODS ==========================================================

    /***************************************************************************
     * Processes the command composed from the given words
     * and returns the game answer to the user.
     * Number of word depends on particular action, however it must be
     * at least one, because the zeroth element contains the action name.
     * The remaining words are arguments of this action and they may differ:
     * the actions of <i>end</i> and <i>help</i> type do not have any,
     * the actions of <i>go</i> and <i>take</i> type have one,
     * the actions of <i>apply</i> type ) can have two (e.g. apply key lock)
     * or three (e.g. apply key to lock) etc.
     *
     * @param arguments Action arguments –
     *                  their number can be different for each action,
     *                  but for all execution of the same action is the same
     * @return The answer of the game after processing the command
     */
    @Override
    abstract
    public String execute(String... arguments)
     ;



//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the action description with explanation of its function
     * and the meaning of individual parameters.
     *
     * @return Action description
     */
    @Override
    public String getDescription()
    {
        return this.description;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//##############################################################################
//== NESTED DATA TYPES =========================================================
}
