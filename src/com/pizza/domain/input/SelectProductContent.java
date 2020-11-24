package com.pizza.domain.input;

import com.pizza.domain.entity.Product;
import com.pizza.util.DisplayDictionary;
import com.sample3.domain.utils.NumberUtil;

import java.util.List;
import java.util.Optional;

public class SelectProductContent extends SelectContent<Product> {

    private SelectProductContent(final List<Product> products) {
        super(products);
    }

    public static SelectProductContent create(final List<Product> products) {
        return new SelectProductContent(products);
    }

    @Override
    public Product get() {
        contents.forEach(product -> {
            final String money = CURRENCY_FORMAT.format(product.getMoney());
            final String displayInformation = String.format("%3d. %s ...%s", product.getOrder(), product.getName(), money);
            System.out.println(displayInformation);
        });

        System.out.print(DisplayDictionary.order());
        final String order = SCANNER.next();

        if (!NumberUtil.isNumber(order)) {
            System.out.println(DisplayDictionary.onlyNumeric() + "\n");
            return get();
        }

        final long orderNum = Long.parseLong(order);
        final Optional<Product> orderProductOpt = contents.stream()
                .filter(product -> product.getOrder() == orderNum)
                .findFirst();

        if (orderProductOpt.isEmpty()) {
            System.out.println(DisplayDictionary.selectProductNotFound(orderNum) + "\n");
            return get();
        }

        return orderProductOpt.get();
    }
}
