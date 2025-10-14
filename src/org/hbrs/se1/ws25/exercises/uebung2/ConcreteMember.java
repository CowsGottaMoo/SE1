package org.hbrs.se1.ws25.exercises.uebung2;

public class ConcreteMember implements Member {
    private Integer id;

    public ConcreteMember(Integer id) {
        this.id = id;
    }

    public Integer getID() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Member (ID = " + id +")";
    }
}
