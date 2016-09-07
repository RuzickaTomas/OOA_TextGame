/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;


import java.util.Collections;
import eu.pedu.adv16s_fw.game_txt.ISpace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;




/*******************************************************************************
 * Instances of the {@code EmptySpace} class represent the spaces in the game.
 *
 * We can take the space visiting as a partial goal,
 * which the player tries to reach.
 * The spaces can be rooms, planets, life stages etc.
 * The spaces can contain various items.that may help user to reach the goal.
 * Each space knows its current neighboring spaces and it knows
 * which items it currently contains.
 * The neighbors as well as the contained items can change during the game.
 * <p>
 * In this program the spaces are ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class SpySpace extends SpyAItemContainer implements ISpace
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
    private final String[] neighborNames;
    private final Collection<SpySpace> neighbors;
    private final Collection<SpySpace> neighCol;
   
    
   
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     *
     */

   /*
    * @param name              Název prostoru
    * @param neighborNames     Název sousedů prostoru 
    * @param itemNames         Název h-objektů v prostoru
    */
    SpySpace(String name, String[] neighborNames, String... itemNames)
    {
        super(name, itemNames);
        this.neighborNames = neighborNames;
        this.neighbors     = new ArrayList<>();
        neighCol           = Collections.unmodifiableCollection(this.neighbors);
        
       
        
    }
//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the collection of current neighbors of this space, i.e. the
     * collection of spaces, to which we can move from this space with the
     * command of the {@link eu.pedu.adv16s_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE} type.
     *
     * @return Collection of neighbors
     */
    @Override
    public Collection<SpySpace> getNeighbors()
    {
        return neighCol;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
 void initialize(){
        
    initializeNeighbors();
        initializeItems();
  };   
 
 
 private void initializeNeighbors() {
     SpyWorld sw = SpyWorld.getInstance();
     this.neighbors.clear();
     Arrays.stream(neighborNames).map(sw::getOSpace)
             .map(Optional<SpySpace>::get)
             .forEach(neighbors::add);
 };


//##############################################################################
//== NESTED DATA TYPES =========================================================
}
