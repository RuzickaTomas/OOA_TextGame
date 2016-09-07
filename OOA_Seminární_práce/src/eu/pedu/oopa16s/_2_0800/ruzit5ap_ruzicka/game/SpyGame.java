/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;


import eu.pedu.adv16s_fw.empty_classes.ANamed;
import eu.pedu.adv16s_fw.game_txt.BasicActions;
import eu.pedu.adv16s_fw.game_txt.IGame;

import java.util.Collection;

/**
 *
 * @author Tomáš
 */
public class SpyGame extends ANamed implements IGame, IAuthorHry
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The reference to the only instance (singleton) of this game. */
    private static final SpyGame SINGLETON = new SpyGame();
    private static final BasicActions BASIC_ACTIONS = 
                     new BasicActions("Jdi", "Vem", "Dej", "pomoc", "end");
//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * The factory method returning the only instance of the given game.
     *
     * @return The instance of the given game
     */
    public static SpyGame getInstance()
    {
        return SINGLETON;
    }

   


    /***************************************************************************
     * The private constructor defining the only instance of the game class.
     * Because it is private, it has to be defined despite its body is empty.
     */
    private SpyGame()
    {
        super("SpyGame");
         
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns information if the game is currently running.
     * The once started game cannot be started again.
     * If you want to start the game again you have to finish it firstly.
     *
     * @return If the game is running, it returns {@code true},
     *         otherwise it returns {@code false}
     */
    @Override
    public boolean isAlive()
    {
      return SpyAAction.isAlive();
    }


    /***************************************************************************
     * Returns the bag to which the player will save the taken items.
     *
     * @return The bag to which the player saves the taken items
     */
    @Override
    public Hands getBag()
    {
        return Hands.getInstance();
    }


    /***************************************************************************
     * Returns the collection of all actions usable in the game.
     *
     * @return The collection of all actions usable in the game
     */
    @Override
    public Collection<SpyAAction> getAllActions()
    {
     return SpyAAction.getAllActions();
    }


    /***************************************************************************
     * Returns the crate with names of mandatory actions, i.e. actions for
     * <ul>
     *   <li>moving into another space,</li>
     *   <li>taking item from the space and putting it into the bag,</li>
     *   <li>taking item from the bag and putting it down
     *       in the current space,</li>
     *   <li>asking for help,</li>
     *   <li>immediate game termination.</li>
     * </ul>
     *
     * @return The crate with names of mandatory actions
     */
    @Override
    public BasicActions getBasicActions()
    {
        return BASIC_ACTIONS;
    }


    /***************************************************************************
     * Returns the world in which the game takes place.
     *
     * @return The world in which the game takes place
     */
    @Override
    public SpyWorld getWorld()
    {
        return SpyWorld.getInstance();
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Processes the given command and returns the answer to the user.
     *
     * @param command The entered command
     * @return The answer of the game after processing the command
     */
    @Override
    public String executeCommand(String command)
    {
        return SpyAAction.executeCommand(command);
    }


    /***************************************************************************
     * Ends the whole game and returns the allocated resources.
     */
    @Override
    public void stop()
    {
        SpyAAction.stopGame();
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================

 
}
