package rpg_lab;
//created by J.M.

public interface Weapon {


    int getAttackPoints();

    int getDurabilityPoints();

    void attack(Target target);
}
