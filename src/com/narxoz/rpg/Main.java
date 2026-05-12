package com.narxoz.rpg;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.artifact.WeightCalculator;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Hero arwen=new Hero("Arwen the Mage", 80, 8, 4);
        Hero borin=new Hero("Borin the Knight", 120, 15, 10);

        arwen.restoreMana(50);
        arwen.addGold(200);
        borin.restoreMana(20);
        borin.addGold(300);

        System.out.println("Party at start:");
        System.out.println("  "+arwen);
        System.out.println("  "+borin);

        ChronomancerEngine engine=new ChronomancerEngine();
        List<Hero> party=Arrays.asList(arwen, borin);
        VaultRunResult result=engine.runVault(party);

        System.out.println(">> Open/Closed proof: a 4th visitor (WeightCalculator)");
        System.out.println("   is added WITHOUT modifying any artifact class.\n");

        Inventory partyLoot=new Inventory();
        partyLoot.addArtifact(new Weapon("Travel Dagger", 40, 3, 3));
        partyLoot.addArtifact(new Potion("Stamina Tonic", 25, 1, 10));
        partyLoot.addArtifact(new Scroll("Light Spell", 60, 1, "Lumos"));
        partyLoot.addArtifact(new Ring("Copper Loop", 20, 1, 1));
        partyLoot.addArtifact(new Armor("Leather Vest", 70, 5, 4));

        WeightCalculator weigher=new WeightCalculator();
        partyLoot.accept(weigher);
        System.out.println("Total effective carry weight= "+weigher.getTotalWeight()+"\n");

        System.out.println("=== Final Report ===");
        System.out.println(result);
        System.out.println("\n=== End of Homework 9 Demo ===");
    }
}
