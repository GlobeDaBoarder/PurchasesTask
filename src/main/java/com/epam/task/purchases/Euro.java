package com.epam.task.purchases;

public class Euro implements Comparable<Euro>{
    private final int value;

    public Euro(int value) {
        this.value = value;
    }

    public Euro(int euros, int cents){
        this.value = euros*100 + cents;
    }

    public Euro(Euro euro){
        this.value = euro.value;
    }

    public int getValue() {
        return value;
    }

    public Euro add(Euro euro){
        return new Euro(this.value + euro.value);
    }

    public Euro sub(Euro euro){
        return new Euro(this.value - euro.value);
    }

    public Euro mul(int k){
        return new Euro(this.value * k);
    }

    public Euro mul(double x, RoundMethods roundMethod, int d){
        return new Euro(roundMethod.round(value * x, roundMethod, d));
    }
    public Euro round(RoundMethods roundMethod, int d){
        return new Euro(roundMethod.round(value, roundMethod, d));
    }



    @Override
    public String toString() {
        return value / 100 + "." + value % 100 / 10 + value % 10;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public int compareTo(Euro o) {
        return Integer.compare(this.value, o.value);
    }
}
