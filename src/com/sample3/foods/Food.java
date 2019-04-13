package com.sample3.foods;

import com.sample3.Price;
import com.sample3.foods.serial.Id;

public class Food {
    protected long id;
    protected String name;
    protected Price price;

    public Food(String name, int price) {
        this.id = new Id().get();
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
