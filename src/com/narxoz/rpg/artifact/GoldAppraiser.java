package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor{
    private int totalGold=0;

    @Override
    public void visit(Weapon weapon){
        int resale=weapon.getValue()+weapon.getAttackBonus()*5;
        totalGold+=resale;
        System.out.println("[GoldAppraiser] Weapon '"+weapon.getName()+"' resale= "+resale+" gold");
    }

    @Override
    public void visit(Potion potion){
        int resale=(int) (potion.getValue()*0.7);
        totalGold+=resale;
        System.out.println("[GoldAppraiser] Potion '"+potion.getName()+"' resale= "+resale+" gold");
    }

    @Override
    public void visit(Scroll scroll){
        int resale=scroll.getValue();
        totalGold+=resale;
        System.out.println("[GoldAppraiser] Scroll '"+scroll.getName()+"' resale = "+resale+" gold");
    }

    @Override
    public void visit(Ring ring){
        int resale=(int) (ring.getValue()*1.5)+ring.getMagicBonus()*10;
        totalGold+=resale;
        System.out.println("[GoldAppraiser] Ring '"+ring.getName()+"' resale = "+resale+" gold");
    }

    @Override
    public void visit(Armor armor){
        int resale=armor.getValue()+armor.getDefenseBonus()*4;
        totalGold+=resale;
        System.out.println("[GoldAppraiser] Armor '" +armor.getName()+"' resale= "+resale+" gold");
    }

    public int getTotalGold(){
        return totalGold;
    }

}
