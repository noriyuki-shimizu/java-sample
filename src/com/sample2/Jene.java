package com.sample2;

public abstract class Jene<T extends Object> {
    protected T t;

    public Jene(T t) {
        this.t = t;
    }

    public abstract void display();
    public abstract void method1(T t);

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
