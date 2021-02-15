package main.java.org.strategyGame;

import org.terasology.gestalt.entitysystem.component.Component;

public class Health implements Component<Health> {
    public int maxHealth = 100, currentHealth = 100;

    public void copy(Health health){
        this.maxHealth = health.maxHealth;
        this.currentHealth = health.currentHealth;
    }
}
