package com.pizza.domain.model;

import com.pizza.domain.entity.Product;
import com.pizza.domain.entity.Size;
import com.pizza.domain.entity.Topping;
import com.pizza.util.DisplayDictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private static class ConfirmedProduct {
        private final Product product;
        private final Size size;
        private final List<Topping> toppings;

        ConfirmedProduct(
                final Product product,
                final Size size,
                final List<Topping> toppings
        ) {
            this.product = product;
            this.size = size;
            this.toppings = toppings;
        }

        int calcTotalPrice() {
            int toppingTotalPrice = toppings.stream().mapToInt(Topping::getMoney).sum();
            int productPrice = (int) (product.getMoney() * size.getRatio());
            return toppingTotalPrice + productPrice;
        }
    }

    private Cart() {}

    public static Cart of() {
        return new Cart();
    }

    private static final String SEPARATOR = "============================";
    private final List<ConfirmedProduct> confirmedProducts = new ArrayList<>();

    public void add(final Product product, final Size size, final List<Topping> toppings) {
        confirmedProducts.add(new ConfirmedProduct(product, size, toppings));
    }

    public int calcTotalPrice() {
        return confirmedProducts.stream().mapToInt(ConfirmedProduct::calcTotalPrice).sum();
    }

    @Override
    public String toString() {
        Collections.reverse(confirmedProducts);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s\n", SEPARATOR));

        String detail = confirmedProducts.stream()
                .map(confirmedProduct -> {
                    final String toppingName = confirmedProduct.toppings.stream()
                            .map(Topping::getName)
                            .collect(Collectors.joining(", "));
                    return String.format("%s: %s\n%s: %s\n%s: %s",
                            DisplayDictionary.pizza(), confirmedProduct.product.getName(),
                            DisplayDictionary.size(), confirmedProduct.size.getName(),
                            DisplayDictionary.topping(), toppingName
                    );
                })
                .collect(Collectors.joining(String.format("\n%s\n", SEPARATOR)));

        stringBuilder.append(detail);
        stringBuilder.append(String.format("\n%s", SEPARATOR));

        Collections.reverse(confirmedProducts);
        return stringBuilder.toString();
    }
}
