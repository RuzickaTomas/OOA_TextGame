/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.oopa16s._2_0800.ruzit5ap_ruzicka.game;

import java.util.Optional;

/**
 *
 * @author Tomáš
 */
public class SpyOpenAction extends SpyAAction{

    public SpyOpenAction() {
        super("Použij", "\n Nestandartní akce pro otevření dveří od zbrojnice"
                      + "\n Použijete Klíč k otevření dveří");
    }

    @Override
    public String execute(String... arguments) {
         if (arguments.length < 2) 
     {
     return "Co chcete otevřít";
     }
     String itemName = arguments[2];
     SpyWorld world = SpyWorld.getInstance();
     SpySpace currentSpace = world.getCurrentSpace();
     Optional<SpyItem> oItem = currentSpace.getOItem(itemName);
     Optional<SpySpace> oDestSpace = world.getOSpace(currentSpace.toString());
     if (!oItem.isPresent()) 
     {
         return itemName+" se tady nenachází";
     }
     if (!oDestSpace.isPresent()) 
     {
         return "Nelze otevřít "+itemName;
     }
     world.setCurrentSpace(currentSpace);
     Hands bag =    Hands .getInstance();
     Optional<SpyItem> sItem = bag.getOItem(arguments[1]);

     
     bag.removeItem(sItem.get());
     currentSpace.addItem(sItem.get());
     return "Otevřít Dveře pomocí Klíč";
    }
    
    
    
    
}
