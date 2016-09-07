/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

import java.util.Collection;
import java.util.Collections;

import eu.pedu.adv16s_fw.game_txt.INamed;
import eu.pedu.adv16s_fw.game_txt.IWorld;

import java.util.ArrayList;
import java.util.Optional;



/*******************************************************************************
 * An instance of the {@code EmptyWorld} class represents the game world.
 * It should be defined as a singleton.
 * It is responsible for arrangement of individual spaces and keeps information,
 * in which space the player is just situated.
 * The mutual arrangement may change during the game,
 * the spaces can gain and/or lose their neighbors.
 * <p>
 * In this game the world is ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class SpyWorld implements IWorld
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The only instance (singleton) of this world. */
    private static final SpyWorld SINGLETON = new SpyWorld();
 
//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================

//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
    private final Collection<SpySpace> world;
    private final Collection<SpySpace> spaces;
    private final SpySpace startSpace;

//== VARIABLE INSTANCE FIELDS ==================================================

    private SpySpace currentSpace;

//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * The factory method returning the only existing instance of the game.
     *
     * @return The only instance of the given game
     */
    static SpyWorld getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * The private constructor creating the only instance of the space world.
     * Within this manager definition it creates all game spaces.
     */
    private SpyWorld()
    {
       world = new ArrayList<>();  
       spaces = Collections.unmodifiableCollection(world);
       startSpace = new SpySpace("Vstupní_hala", 
                     new String[]{"Strážnice", "Chodba"}, 
                       SpyItem.ONE_HAND+"Víno",SpyItem.WEAR+"Převlek"); 
       
       world.add(startSpace);
       
       world.add(new SpySpace("Chodba",  
                  new String[]{"Strážnice","Vstupní_hala", "Cílová_oblast"
                               }, 
               SpyItem.NOT_MOVABLE+"Lampa"));
       
       world.add(new SpySpace("Strážnice", 
                  new String[]{ "Vstupní_hala", "Chodba" , "Cílová_oblast",
                               "Velký_sál", "Zbrojnice", "Komunikační_místnost"}
               , SpyItem.GUARD+"Stráž"));
       //----------------------------------------------------------------------
       //Nevím jestli se obsah batohu sčítá, nebo je to označní položky v poli
       //----------------------------------------------------------------------
       world.add(new SpySpace("Komunikační_místnost",
                 new String[]{"Velký_sál","Zbrojnice", "Strážnice"},
                    SpyItem.ONE_HAND+"Klíč",SpyItem.WEAR+"Kódy"));
       
       world.add(new SpySpace( "Zbrojnice",
                 new String[]{"Velký_sál","Strážnice","Komunikační_místnost" 
                               }, 
                        SpyItem.WEAR+"Pistole",SpyItem.NOT_MOVABLE+"Kulomet"
                       ,SpyItem.NOT_MOVABLE+"Panzerfaust", 
                        SpyItem.NOT_MOVABLE+"Dveře"));
       
       world.add(new SpySpace("Velký_sál",
                 new String[]{"Komunikační_místnost",
                              "Cílová_oblast", "Zbrojnice"}, 
                   SpyItem.NOT_MOVABLE+"Vypínač", SpyItem.NOT_MOVABLE+"Alarm"));
       
       world.add(new SpySpace("Cílová_oblast",
                  new String[]{"Chodba", "Strážnice", "Velký_sál"}, 
              SpyItem.KILLABLE+"Nepřítel", SpyItem.NOT_MOVABLE+"Trezor", 
              SpyItem.WEAR+"Dokumenty"));
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    
  
    /***************************************************************************
     * Returns the collection of all spaces of the game.
     *
     * @return Collection of all spaces performing in the game
     */
    @Override
    public Collection<SpySpace> getAllSpaces()
    {
        return spaces;
    }


    /***************************************************************************
     * Returns the current space,
     * i.e. to the space in which the player is just situated.
     *
     * @return The space in which the player is just situated
     */
   @Override
   public SpySpace getCurrentSpace()
    {
        return currentSpace;
    }
   
  public Optional<SpySpace> getOSpace(String name){
         Optional<SpySpace> result = INamed.getO(name, spaces);
         return result;
    } 


  

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    void setCurrentSpace(SpySpace space) 
    {
         currentSpace = space;
    } 
  
  
   void initialize(){
       spaces.forEach(SpySpace::initialize);
       currentSpace = startSpace;
   }
   
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}



//*****************************************************************************
//****************************************************************************
// Přemapovat místa - sály a tak v happy, mistake a required scenario steps.
//¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤
//-----------------------------------------------------------------------------