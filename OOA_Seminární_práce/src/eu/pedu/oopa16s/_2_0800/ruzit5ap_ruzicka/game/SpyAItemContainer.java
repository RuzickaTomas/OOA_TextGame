/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

import eu.pedu.adv16s_fw.empty_classes.ANamed;
import eu.pedu.adv16s_fw.game_txt.IItemContainer;
import eu.pedu.adv16s_fw.game_txt.INamed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 *
 * @author Tomáš
 */
abstract class SpyAItemContainer extends ANamed implements IItemContainer {
    
//== CONSTANT CLASS FIELDS =======================       
//== VARIABLE CLASS FIELDS =======================
//################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ======
//== CLASS GETTERS AND SETTERS ===================
//== OTHER NON-PRIVATE CLASS METHODS =============
//== PRIVATE AND AUXILIARY CLASS METHODS =========
//################################################
//== CONSTANT INSTANCE FIELDS ====================

    private final String[] itemNames;
    private final Collection<SpyItem> items;
    private final Collection<SpyItem> itemCol;
      
//== VARIABLE INSTANCE FIELDS ====================
//################################################
//== CONSTRUCTORS AND FACTORY METHODS ============

    /**
     * *******************************************
     *
     */
    public SpyAItemContainer(String name, String... itemNames) {
        super(name);
        this.itemNames = itemNames;
        items = new ArrayList<>();
        itemCol = Collections.unmodifiableCollection(items);
    }
  
//== ABSTRACT METHODS ============================
//== INSTANCE GETTERS AND SETTERS ================
//== OTHER NON-PRIVATE INSTANCE METHODS ==========

    /**
     * *******************************************
     * Returns a collection of items located in the given space.
     *
     * @return Collection of items located in the given space
     */
    public Optional<SpyItem> getOItem(String s) {
        return INamed.getO(s, items);
    }

    @Override
    public Collection<SpyItem> getItems() {
        return itemCol;
    }

    protected void addItem(SpyItem item) {
        items.add(item);

    }

    protected void initializeItems() {
        items.clear();
        Arrays.stream(itemNames)
                .map(SpyItem::new)
                .forEach(items::add);
    }

    ;
    


    void removeItem(SpyItem item) {
        items.remove(item);
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ======
//################################################
//== NESTED DATA TYPES ===========================    
}
