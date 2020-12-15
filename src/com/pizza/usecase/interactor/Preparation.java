package com.pizza.usecase.interactor;

import com.pizza.datastore.ProductRepository;
import com.pizza.datastore.SizeRepository;
import com.pizza.datastore.ToppingRepository;
import com.pizza.domain.entity.Product;
import com.pizza.domain.entity.Size;
import com.pizza.domain.entity.Topping;
import com.pizza.usecase.IPreparation;

import java.util.List;

public class Preparation implements IPreparation {
    private final ProductRepository productRepository;
    private final SizeRepository sizeRepository;
    private final ToppingRepository toppingRepository;

    private Preparation(
            final ProductRepository productRepository,
            final SizeRepository sizeRepository,
            final ToppingRepository toppingRepository
    ) {
        this.productRepository = productRepository;
        this.sizeRepository = sizeRepository;
        this.toppingRepository = toppingRepository;
    }

    public static Preparation of(
            final ProductRepository productRepository,
            final SizeRepository sizeRepository,
            final ToppingRepository toppingRepository
    ) {
        return new Preparation(productRepository, sizeRepository, toppingRepository);
    }

    @Override
    public void setup() {
        product();
        size();
        topping();
    }

    private void product() {
        productRepository.saveAll(List.of(
                Product.of("マルゲリータピザ", 1100),
                Product.of("バジルピザ", 980),
                Product.of("シーフードピザ", 1200),
                Product.of("プルコギピザ", 1280),
                Product.of("エビマヨピザ", 1300),
                Product.of("ベーコンピザ", 1000),
                Product.of("スパイシーピザ", 980),
                Product.of("108種のチーズピザ", 1980),
                Product.of("ガーリックピザ", 1100),
                Product.of("ポテマヨピザ", 900)
        ));
    }

    private void size() {
        sizeRepository.saveAll(List.of(
                Size.of("S", 0.8),
                Size.of("M", 1),
                Size.of("L", 1.2)
        ));
    }

    private void topping() {
        toppingRepository.saveAll(List.of(
                Topping.of("なし", 0),
                Topping.of("サラミ", 200),
                Topping.of("ポテト", 100),
                Topping.of("玉ねぎ", 90),
                Topping.of("生ハム", 180)
        ));
    }
}
