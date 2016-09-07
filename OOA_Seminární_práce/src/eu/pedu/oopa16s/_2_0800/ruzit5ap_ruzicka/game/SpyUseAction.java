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
public class SpyUseAction extends SpyAAction{

    public SpyUseAction() {
        super("Využij", "Využij co k čemu,"
                      + "\n Využije něco k otevření trezoru.");
    }

    
    
    @Override
    public String execute(String... arguments) {
    
    String trezor =  arguments[2];   
    String kod    =  arguments[1];  
    
     SpyWorld world = SpyWorld.getInstance();
     SpySpace currentSpace = world.getCurrentSpace();
     Optional<SpyItem> oItem = currentSpace.getOItem(trezor);
     if (arguments.length < 2) 
     {
     return "Co chcete využít";
     }
     if (!oItem.isPresent() && (trezor != "trezor")) {
     return "V místnosti není"+trezor;
     }
 
     world.setCurrentSpace(currentSpace);
     Hands bag =    Hands .getInstance();
     Optional<SpyItem> sItem = bag.getOItem(kod);
     bag.removeItem(sItem.get());
     currentSpace.addItem(sItem.get());
     return "Otevřít dveře "+trezor+" pomocí "+kod;
    }
    
}
