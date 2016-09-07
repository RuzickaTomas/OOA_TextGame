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
public class SpySwitchAction extends SpyAAction{

    public SpySwitchAction() {
        super("Zhasni", "Zhasni něco způsobí vypnutí/zapnutí přístroje,"
                    + "\n který se v místnosti nachází.");
    }

    
    @Override
    public String execute(String... arguments) {
        String item = arguments[1];
        SpyWorld world = SpyWorld.getInstance();
        SpySpace currentSpace = world.getCurrentSpace();
        
      Optional<SpyItem> oItem = currentSpace.getOItem(item);
      Optional<SpySpace> oDestSpace = world.getOSpace(currentSpace.toString());

      
      if (!oItem.isPresent()) {
         return item+" se tady nenachází";
        }
      if (!oDestSpace.isPresent()) {
         return "Nejste na správném místě";
      }
      if ("vypínač".equals(item)) {
        return "Vypnul jste "+item;
      } else {
       SpyEndAction.stopGame();
       return "Zapnul jste "+item+" už o vás ví";
       
      }
    
    }
    
    
}
