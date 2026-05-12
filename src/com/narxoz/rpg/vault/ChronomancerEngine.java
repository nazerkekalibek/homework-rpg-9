package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.CurseDetector;
import com.narxoz.rpg.artifact.EnchantmentScanner;
import com.narxoz.rpg.artifact.GoldAppraiser;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import java.util.List;

public class ChronomancerEngine{
    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n--- Chronomancer's Vault opens ---");

        Inventory vaultLoot=new Inventory();
        vaultLoot.addArtifact(new Weapon("Rusted Sword", 50, 8, 4));
        vaultLoot.addArtifact(new Weapon("Excalibur", 500, 6, 12));
        vaultLoot.addArtifact(new Potion("Minor Heal", 30, 1, 20));
        vaultLoot.addArtifact(new Potion("Black Brew", 10, 1, -15));
        vaultLoot.addArtifact(new Scroll("Old Parchment", 80, 1, "Fireball"));
        vaultLoot.addArtifact(new Scroll("Dark Tome", 200, 2, "Doom Wave"));
        vaultLoot.addArtifact(new Ring("Silver Band", 150, 1, 3));
        vaultLoot.addArtifact(new Armor("Iron Plate", 200, 12, 8));

        System.out.println("Vault inventory contains "+vaultLoot.size()+" artifacts.\n");

        GoldAppraiser appraiser=new GoldAppraiser();
        EnchantmentScanner scanner=new EnchantmentScanner();
        CurseDetector detector=new CurseDetector();

        System.out.println(">> GoldAppraiser walks the inventory:");
        vaultLoot.accept(appraiser);
        System.out.println("Total resale value= "+appraiser.getTotalGold()+" gold\n");

        System.out.println(">> EnchantmentScanner walks the inventory:");
        vaultLoot.accept(scanner);
        System.out.println("Enchanted artifacts found= "+scanner.getEnchantedCount()+"\n");

        System.out.println(">> CurseDetector walks the inventory:");
        vaultLoot.accept(detector);
        System.out.println("Cursed artifacts found= "+detector.getCursedCount()+"\n");
        int artifactsAppraised=vaultLoot.size()*3;

        Caretaker caretaker=new Caretaker();
        int mementosCreated=0;
        int restoredCount=0;

        if(!party.isEmpty()){
            Hero hero=party.get(0);
            hero.getInventory().addArtifact(new Ring("Hero's Ring", 100, 1, 2));

            System.out.println(">> Hero state BEFORE the vault trap:");
            System.out.println("   "+hero);

            HeroMemento snapshot=hero.createMemento();
            caretaker.save(snapshot);
            mementosCreated++;
            System.out.println("[Caretaker] Snapshot saved. History size= "+caretaker.size()+"\n");

            System.out.println(">> VAULT TRAP TRIGGERED! Spikes + mana siphon + gold trap!");
            hero.takeDamage(40);
            hero.spendMana(20);
            hero.spendGold(50);
            System.out.println("   Hero state AFTER the trap:");
            System.out.println("   "+hero+"\n");

            System.out.println(">> Chronomancer rewinds time...");
            HeroMemento restored=caretaker.undo();
            if(restored!=null){
                hero.restoreFromMemento(restored);
                restoredCount++;
                System.out.println("   Hero state AFTER rewind:");
                System.out.println("   "+hero+"\n");
            }
        }

        System.out.println("--- Chronomancer's Vault closes ---\n");
        return new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);
    }
}
