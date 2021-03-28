package rpg_lab;
//created by J.M.

public interface Target {

    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();
}

