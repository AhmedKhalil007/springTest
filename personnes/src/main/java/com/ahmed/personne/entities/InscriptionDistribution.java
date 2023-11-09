package com.ahmed.personne.entities;

public class InscriptionDistribution {

	private int month;
    private int count;

    public InscriptionDistribution(int month, int count) {
        this.month = month;
        this.count = count;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
