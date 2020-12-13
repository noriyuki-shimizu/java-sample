package com.pizza.usecase.interactor;

import com.pizza.datastore.ProductRepository;
import com.pizza.datastore.SizeRepository;
import com.pizza.datastore.ToppingRepository;
import com.pizza.domain.Order;
import com.pizza.domain.input.SelectProductContent;
import com.pizza.domain.input.SelectSizeContent;
import com.pizza.domain.input.SelectToppingContent;
import com.pizza.domain.model.Cart;
import com.pizza.usecase.ICustomerService;

public class CustomerService implements ICustomerService {
    private final ProductRepository productRepository;
    private final SizeRepository sizeRepository;
    private final ToppingRepository toppingRepository;

    private CustomerService(
            final ProductRepository productRepository,
            final SizeRepository sizeRepository,
            final ToppingRepository toppingRepository
    ) {
        this.productRepository = productRepository;
        this.sizeRepository = sizeRepository;
        this.toppingRepository = toppingRepository;
    }

    public static CustomerService of(
            final ProductRepository productRepository,
            final SizeRepository sizeRepository,
            final ToppingRepository toppingRepository
    ) {
       return new CustomerService(productRepository, sizeRepository, toppingRepository);
    }

    @Override
    public void serve() {
        final SelectProductContent selectProductContent = SelectProductContent.create(
                productRepository.findAll()
        );
        final SelectSizeContent selectSizeContent = SelectSizeContent.create(
                sizeRepository.findAll()
        );
        final SelectToppingContent selectToppingContent = SelectToppingContent.create(
                toppingRepository.findAll()
        );

        final Order order = Order.of(
                selectProductContent,
                selectSizeContent,
                selectToppingContent
        );

        final Cart cart = order.take(Cart.of());

        System.out.println(cart.toString());
    }
}
