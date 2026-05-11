package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor{
    private int cursedCount=0;

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getWeight()>10 && weapon.getAttackBonus()<5){
            cursedCount++;
            System.out.println("[CurseDetector] !!! Weapon '"+weapon.getName()+"' is CURSED (heavy and weak)");
        }
        else{
            System.out.println("[CurseDetector] Weapon '"+weapon.getName()+"' is safe");
        }
    }

    @Override
    public void visit(Potion potion){
        if (potion.getHealing()<0){
            cursedCount++;
            System.out.println("[CurseDetector] !!! Potion '"+potion.getName()+"' is POISONOUS");
        } 
        else{
            System.out.println("[CurseDetector] Potion '"+potion.getName()+"' is safe");
        }
    }

    @Override
    public void visit(Scroll scroll){
        String spell=scroll.getSpellName().toLowerCase();
        if(spell.contains("doom") || spell.contains("death") || spell.contains("curse")){
            cursedCount++;
            System.out.println("[CurseDetector] !!! Scroll '"+scroll.getName()+"' contains a CURSED spell: " + scroll.getSpellName());
        } 
        else{
            System.out.println("[CurseDetector] Scroll '"+scroll.getName()+"' is safe");
        }
    }

    @Override
    public void visit(Ring ring){
        if(ring.getMagicBonus()<0){
            cursedCount++;
            System.out.println("[CurseDetector] !!! Ring '"+ring.getName()+"' is CURSED (drains magic)");
        } else {
            System.out.println("[CurseDetector] Ring '"+ring.getName()+"' is safe");
        }
    }

    @Override
    public void visit(Armor armor){
        if(armor.getWeight()>15 && armor.getDefenseBonus()<3){
            cursedCount++;
            System.out.println("[CurseDetector] !!! Armor '"+armor.getName()+"' is CURSED (heavy but useless)");
        } else {
            System.out.println("[CurseDetector] Armor '"+armor.getName()+"' is safe");
        }
    }
    public int getCursedCount(){
        return cursedCount;
    }

}
