/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Rodrigo Núñez Mujica
 */
public class Usuario {
    public static void main (String args[]) {
        List<UUID> ids = new ArrayList<>();
        for(int i=0;i<=1000000;i++) {
            UUID uuid = UUID.randomUUID();
            if(ids.contains(uuid)) {
                System.out.println("UUID REPETIDO!!! "+uuid.toString());
            } else {
                ids.add(uuid);
               //System.out.println("UUID "+i+": "+UUID.randomUUID().toString());
            }            
            if(i%10000 == 0) {
                System.out.println(i);
            }
        }
    }    
}
