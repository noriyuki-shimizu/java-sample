package com.pizza.domain.input;

import com.pizza.domain.entity.Topping;
import com.pizza.util.DisplayDictionary;
import com.sample3.domain.utils.NumberUtil;

import java.util.List;
import java.util.Optional;

public class SelectToppingContent extends SelectContent<Topping> {

    private SelectToppingContent(final List<Topping> toppings) {
        super(toppings);
    }

    public static SelectToppingContent create(final List<Topping> toppings) {
        return new SelectToppingContent(toppings);
    }

    @Override
    Topping get() {
        contents.forEach(topping -> {
            final String money = CURRENCY_FORMAT.format(topping.getMoney());
            final String displayInformation = String.format("%3d. %s ...%s", topping.getOrder(), topping.getName(), money);
            System.out.println(displayInformation);
        });

        System.out.print(DisplayDictionary.topping());
        final String order = SCANNER.next();

        if (!NumberUtil.isNumber(order)) {
            System.out.println(DisplayDictionary.onlyNumeric() + "\n");
            return get();
        }

        final long orderNum = Long.parseLong(order);
        final Optional<Topping> orderSizeOpt = contents.stream()
                .filter(size -> size.getOrder() == orderNum)
                .findFirst();

        if (orderSizeOpt.isEmpty()) {
            System.out.println(DisplayDictionary.selectToppingNotFound(orderNum) + "\n");
            return get();
        }

        return orderSizeOpt.get();
    }
}
