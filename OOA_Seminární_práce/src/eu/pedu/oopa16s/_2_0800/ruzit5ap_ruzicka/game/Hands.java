/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

import eu.pedu.adv16s_fw.game_txt.IBag;




/*******************************************************************************
 * Instance of the {@code EmptyBag} class represents the repository,
 * to which the players store the items picked up in individual spaces,
 * so that they could be moved to other spaces and/or used.
 * The disposal site has a final capacity defining the maximal permitted
 * sum of weights of items occuring in the repository.
 * <p>
 * In this game the bag is ...
 * with capacity ....
 * The item weight represents
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class Hands extends SpyAItemContainer implements IBag
{
//== CONSTANT CLASS FIELDS =====================================================

    static final int CAPACITY = 4;
    /** The only instance of the bag in the game. */
    private static final Hands SINGLETON = new Hands();

 

//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
  //  private final Collection<SpyItem> items;
  //  private final Collection<SpyItem> exportedItems;
      private int remains;
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Factory method returning the only existing instance of the game.
     *
     * @return The instance of the given game
     */
    static Hands getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     */
    Hands()
    {
       super("Batoh");
    }

  
    

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the bag capacity, i.e. the maximal permitted sum
     * of weights of items, that can be put into the bag at the same time.
     *
     * @return Capacity of the bag
     */
    @Override
    public int getCapacity()
    {
      return CAPACITY;
    }
    
    public int zbyvajiciMisto() 
    {
        return remains;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    
    void initialize() {
        initializeItems();
        remains = CAPACITY;
    }
    
    @Override
    void removeItem(SpyItem item) 
    {
        super.removeItem(item);
        remains += item.getWeight();
    }
    
    
    boolean  tryAddItem(SpyItem item) 
    {   
        if(item.getWeight() > remains) 
        {
        return false;
        }
        addItem(item);
        remains -= item.getWeight();
        return true;
    }
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
