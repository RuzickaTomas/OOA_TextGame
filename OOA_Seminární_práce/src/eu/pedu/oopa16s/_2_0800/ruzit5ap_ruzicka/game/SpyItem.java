/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

import eu.pedu.adv16s_fw.empty_classes.ANamed;
import eu.pedu.adv16s_fw.game_txt.IItem;




/*******************************************************************************
 * Instances of the {@code EmptyItem} class represent the items in spaces.
 * These items can be things as well as persons or other entities
 * (flowers, light, charm etc.)
 * <p>
 * Some of these items can qualify certain game or space properties
 * (the light is on), others may be determined for taken and so gain a property
 * (e.g. ability to go through a strange space), or capability
 * (e.g. key for unlocking the door, sward for killing the monster,
 * money for bribing the guard etc.),
 * <p>
 * You can define items which serve simultaneously as spaces and can
 * therefore contain other items (e.g. safe, window etc.).
 * You have to enter in these items/spaces with a special command
 * (e.g. <i>open safe</i>, <i>look_from window</i>, etc.) and leave them with
 * another special command (e.g. <i>close safe</i>, <i>shut window</i> etc.).
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class SpyItem extends ANamed implements IItem
{
//== CONSTANT CLASS FIELDS =====================================================
//== VARIABLE CLASS FIELDS =====================================================

    private static final int HEAVY = Hands.CAPACITY + 1;
    // WEAR značí že oblečení bude mít objekt celou dobu na sobě
    static final char WEAR = '1';
    // ONE_HAND objekt je možno zvednout jednou rukou
    static final char ONE_HAND = '2';
    // BOTH_HANDS je třeba použít obě ruce
    static final char BOTH_HANDS = '3';
    // Objekt není možné přemístit
    static final char NOT_MOVABLE = '#';
    // Objekt je možno zabít
    static final char KILLABLE = 'X';
    // GUARD označuje stráž
    static final char GUARD = '$';



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
    
    private final int weight;
    private final boolean isKillable;
    private final boolean drunkable;
   
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Creates the item with the given name and other given properties.
     * These additional properties are entered through a prefix,
     * that is the first character of the given name.
     * The name of the item itself is created by the remaining letters.
     *
     * @param name The name of the created item
     */
   SpyItem(String name)
    {
        
        super(name.substring(1));
        
        boolean killable = false;
        boolean drunkAble = false;
        int estimatedCapability = 1;
        char prefix = name.charAt(0);
        
        switch (prefix)
        {
            case WEAR:
                
                break;
            case ONE_HAND:
                estimatedCapability = 2;
                break;
            case BOTH_HANDS: 
                estimatedCapability = 3; 
                break;
            case NOT_MOVABLE:
                estimatedCapability = HEAVY;
                break;
            case KILLABLE:
                killable = true;
                break;
            case GUARD:
                drunkAble = true;
                break;
         default:
             throw new RuntimeException(Texts.eITEM_PREFIX+prefix);
                
               
            
        }
        weight = estimatedCapability;
        isKillable = killable;
        drunkable = drunkAble;
  
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the item weight, and/or the corresponding characteristics.
     * The items that cannot be raised
     * have higher weight than the bag capacity is.
     *
     * @return Weight of the item
     */
    @Override
    public int getWeight()
    {
        return weight;
    }
    
     /*
    
    */
    public boolean isKillable()
    {
        return isKillable;
    }
    /*
    
    */
    public boolean isDrunkable()
    {
        return drunkable;
    }
    
 


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
