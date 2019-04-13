package com.sample3.food;

import com.sample3.Price;

public class Food {
    protected long id;
    protected String name;
    protected Price price;

    public Food(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = new Price(price);
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Price getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(this.id);
        stringBuffer.append(". ");
        stringBuffer.append(this.name);
        stringBuffer.append(" ");
        stringBuffer.append(this.price.get());
        stringBuffer.append(" 円");

        return stringBuffer.toString();
    }
}
