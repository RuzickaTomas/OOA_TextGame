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
public class SpyKillAction extends SpyAAction{

    public SpyKillAction() {
        super("Zabij", "Zabij koho čím, "
                     + "\n zabít je možné pouze Nepřítele "
                     + "\n a to zbraní k tomu určenou.");
    }

    @Override
    public String execute(String... arguments) {
         String cil = arguments[1];
         String zbran = arguments[2];
        SpyWorld world = SpyWorld.getInstance();
        SpySpace currentSpace = world.getCurrentSpace();
       
       Optional<SpyItem> oItemC = currentSpace.getOItem(cil); 
       Optional<SpySpace> oDestSpace = world.getOSpace(currentSpace.toString());
       SpyItem item = oItemC.get();
        if (!oDestSpace.isPresent() || !oItemC.isPresent()) {
        return "Nejste na správném místě";
        }

        if ("pistole".equals(zbran)) 
        {
      
               //              if (currentSpace.equals(world
//                                            .getOSpace("Cílová_oblast")
//                                            .get()) &&
//                item.isKillable() &&  ! State.isMajor())
//            {           
//                return Conversation.start(item);
//            }  
            
        return "Zabil jste "+cil+" pomocí "+zbran;
        } else 
        {
        return zbran+" nelze použít";
        }
    }
    
}
