package com.pizza.domain.input;

import com.pizza.domain.entity.Size;
import com.pizza.util.DisplayDictionary;
import com.sample3.domain.utils.NumberUtil;

import java.util.List;
import java.util.Optional;

public class SelectSizeContent extends SelectContent<Size> {

    private SelectSizeContent(final List<Size> sizes) {
        super(sizes);
    }

    public static SelectSizeContent create(final List<Size> sizes) {
        return new SelectSizeContent(sizes);
    }

    @Override
    public Size get() {
        contents.forEach(size -> {
            final String displayInformation = String.format("%3d. %s ...%f", size.getOrder(), size.getName(), size.getRatio());
            System.out.println(displayInformation);
        });

        System.out.print(DisplayDictionary.size());
        final String order = SCANNER.next();

        if (!NumberUtil.isNumber(order)) {
            System.out.println(DisplayDictionary.onlyNumeric() + "\n");
            return get();
        }

        final long orderNum = Long.parseLong(order);
        final Optional<Size> orderSizeOpt = contents.stream()
                .filter(size -> size.getOrder() == orderNum)
                .findFirst();

        if (orderSizeOpt.isEmpty()) {
            System.out.println(DisplayDictionary.selectSizeNotFound(orderNum) + "\n");
            return get();
        }

        return orderSizeOpt.get();
    }
}
