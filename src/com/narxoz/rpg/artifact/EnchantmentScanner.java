package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor{
    private int enchantedCount=0;

    @Override
    public void visit(Weapon weapon){
        if(weapon.getAttackBonus()>5){
            enchantedCount++;
            System.out.println("[EnchantmentScanner] Weapon '"+weapon.getName()+"' radiates+"+weapon.getAttackBonus()+" attack enchantment");
        } 
        else{
            System.out.println("[EnchantmentScanner] Weapon '"+weapon.getName()+"' is mundane");
        } 
    }

    @Override
    public void visit(Potion potion){
        enchantedCount++;
        System.out.println("[EnchantmentScanner] Potion '"+potion.getName()+"' bubbles with healing magic (+"+ potion.getHealing()+" HP)");
    }

    @Override
    public void visit(Scroll scroll){
        enchantedCount++;
        System.out.println("  [EnchantmentScanner] Scroll '" + scroll.getName()+"' contains spell: " + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring){
        enchantedCount++;
        System.out.println("  [EnchantmentScanner] Ring '" + ring.getName()+ "' shimmers with +" + ring.getMagicBonus() + " magic aura");
    }

    @Override
    public void visit(Armor armor) {
        if(armor.getDefenseBonus()>5){
            enchantedCount++;
            System.out.println("  [EnchantmentScanner] Armor '" + armor.getName()+ "' is blessed with +" + armor.getDefenseBonus() + " defense ward");
        } 
        else {
            System.out.println("  [EnchantmentScanner] Armor '" + armor.getName()+"' is plain steel");
        }
    }

    public int getEnchantedCount(){
        return enchantedCount;
    }

}
