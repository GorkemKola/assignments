package Pieces;

import Pieces.Calliance.Calliance;
import Pieces.Zorde.Zorde;

public abstract class Character implements ICharacters {
    private int AP;
    private int maxMove;
    private String ID;
    private int maxHP;
    private int individualHP;

    public int getAP() {
        return AP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    public int getMaxMove() {
        return maxMove;
    }

    public void setMaxMove(int maxMove) {
        this.maxMove = maxMove;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getIndividualHP() {
        return individualHP;
    }

    public void setIndividualHP(int individualHP) {
        this.individualHP = individualHP;
    }

    public void healthDecrease(Character attacker) {
        if (attacker instanceof Zorde && this instanceof Calliance) {
            this.setIndividualHP(this.getIndividualHP() - attacker.getAP());
        } else if (attacker instanceof Calliance && this instanceof Zorde) {
            this.setIndividualHP(this.getIndividualHP() - attacker.getAP());
        }
    }

    @Override
    public String toString() {
        return getID() + "\t" + getIndividualHP() + "\t(" + getMaxHP() + ")\n";
    }

    public void healthIncrease() {
        if (this instanceof Zorde) {
            if (this.getIndividualHP() <= this.getMaxHP() - 10) {
                this.setIndividualHP(this.getIndividualHP() + 10);
            } else if (this.getIndividualHP() < this.getMaxHP()) {
                this.setIndividualHP(this.getMaxHP());
            }
        }
    }
}
