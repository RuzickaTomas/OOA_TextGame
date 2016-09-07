/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

import eu.pedu.adv16s_fw.game_txt.INamed;
import java.util.Optional;




/*******************************************************************************
 * Instances of the {@code EmptyAction} class process the commands, which
 * ???.
 * <p>
 * Instances of the action classes are effectively singletons,
 * however we do not need to ensure it explicitely, because for their creation
 * and further management the specified action manager takes care
 * which ensures the only instance of each such class.
 * </p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class SpyMoveAction extends SpyAAction
{
//== CONSTANT CLASS FIELDS =====================================================
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
     * Creates the action instance for ...
     */
    SpyMoveAction()
    {
        super ("Jdi",
              "\n Přesune hráče do sousední místnosti, danná místnost musí být "
            + "\n sousedem místnosti v které se hráč nachází a ze které se "
            + "\n hráč chce přesunout, v opačném případě se příkaz neprovede");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

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
    public String execute(String... arguments)
    {
     if (arguments.length < 2) 
     {
     return "Napište kam chcete jít";
     }
     String desName = arguments[1];
     SpySpace currentSpace = SpyWorld.getInstance().getCurrentSpace();   
     Optional<SpySpace> oDest = INamed.getO(desName, 
                                            currentSpace.getNeighbors());

   
     if (!oDest.isPresent()) 
     {
         return "Tam se nyní nelze dostat";
     }
    
     SpySpace destSpace = oDest.get();
     SpyWorld.getInstance().setCurrentSpace(destSpace);
     
 
     return "Jdete do "+destSpace.getName() + "\n";
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
