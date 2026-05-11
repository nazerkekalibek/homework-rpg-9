package com.narxoz.rpg.artifact;

public class WeightCalculator implements ArtifactVisitor{
    private double totalWeight=0.0;

    @Override
    public void visit(Weapon weapon){
        double effective=weapon.getWeight()*1.2;
        totalWeight+=effective;
        System.out.println("[WeightCalculator] Weapon '" + weapon.getName()+"' effective weight = " + effective);
    }

    @Override
    public void visit(Potion potion){
        double effective=potion.getWeight()*0.8;
        totalWeight+=effective;
        System.out.println("[WeightCalculator] Potion '" + potion.getName()+"' effective weight = " + effective);
    }

    @Override
    public void visit(Scroll scroll){
        double effective=scroll.getWeight()*0.5;
        totalWeight+=effective;
        System.out.println("[WeightCalculator] Scroll '" + scroll.getName()+"' effective weight = " + effective);
    }

    @Override
    public void visit(Ring ring){
        double effective=ring.getWeight()*0.1;
        totalWeight+=effective;
        System.out.println("[WeightCalculator] Ring '" + ring.getName()+ "' effective weight = " + effective);
    }

    @Override
    public void visit(Armor armor) {
        double effective = armor.getWeight()*1.5;
        totalWeight+=effective;
        System.out.println("[WeightCalculator] Armor '" + armor.getName()+ "' effective weight = " + effective);
    }

    public double getTotalWeight(){
        return totalWeight;
    }

}
