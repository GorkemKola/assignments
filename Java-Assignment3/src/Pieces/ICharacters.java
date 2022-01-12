package Pieces;

public interface ICharacters {
    int getAP();

    void setAP(int AP);

    int getMaxMove();

    void setMaxMove(int maxMove);

    String getID();

    void setID(String ID);

    int getMaxHP();

    void setMaxHP(int maxHP);

    int getIndividualHP();

    void setIndividualHP(int individualHP);

    void healthIncrease();

    void healthDecrease(Character attacker);

    String toString();
}
