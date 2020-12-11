package com.pizza.domain;

import com.pizza.domain.entity.Product;
import com.pizza.domain.entity.Size;
import com.pizza.domain.entity.Topping;
import com.pizza.domain.input.SelectAnswer;
import com.pizza.domain.input.SelectProductContent;
import com.pizza.domain.input.SelectSizeContent;
import com.pizza.domain.input.SelectToppingContent;
import com.pizza.domain.model.Cart;
import com.pizza.util.DisplayDictionary;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final SelectProductContent selectProductContent;
    private final SelectSizeContent selectSizeContent;
    private final SelectToppingContent selectToppingContent;

    private Order(
            final SelectProductContent selectProductContent,
            final SelectSizeContent selectSizeContent,
            final SelectToppingContent selectToppingContent
            ) {
        this.selectProductContent = selectProductContent;
        this.selectSizeContent = selectSizeContent;
        this.selectToppingContent = selectToppingContent;
    }

    public static Order of(
            final SelectProductContent selectProductContent,
            final SelectSizeContent selectSizeContent,
            final SelectToppingContent selectToppingContent
    ) {
        return new Order(selectProductContent, selectSizeContent, selectToppingContent);
    }

    public Cart take(final Cart cart) {
        System.out.println(DisplayDictionary.selectProduct());
        final Product product = selectProductContent.get();

        System.out.println(DisplayDictionary.selectSize());
        final Size size = selectSizeContent.get();

        System.out.println(DisplayDictionary.selectTopping());
        final List<Topping> toppings = takeToppings(new ArrayList<>());

        cart.add(product, size, toppings);

        System.out.println(DisplayDictionary.reorder());

        return SelectAnswer.is() ? take(cart) : cart;
    }

    private List<Topping> takeToppings(List<Topping> toppings) {
        toppings.add(selectToppingContent.get());

        System.out.println(DisplayDictionary.toppingReorder());

        return SelectAnswer.is() ? takeToppings(toppings) : toppings;
    }
}
