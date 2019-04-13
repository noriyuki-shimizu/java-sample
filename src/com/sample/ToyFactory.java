package com.sample;

import java.util.Arrays;

public class ToyFactory {

    private Employee[] employees;

    public ToyFactory(Employee[] employees) {
        this.employees = employees;
    }

    public ToyProduct[] makeProduct(ToyMaterial[] toyMaterials) {

        int totalSalary = Arrays.asList(employees).stream().map(employee -> employee.getSalary())
                                               .reduce((base, salaly) -> base + salaly).get();

        int totalCost = Arrays.asList(toyMaterials).stream().map(toyMaterial -> toyMaterial.getCost())
                                                 .reduce((base, cost) -> base + cost).get();

        ToyProduct[] toyProducts = new ToyProduct[toyMaterials.length];
        for(int i=0; i<toyMaterials.length; i++) {
            int productPrice = (int)((totalSalary + totalCost) / toyMaterials.length * 1.5);

            ToyProduct toyProduct = new ToyProduct(
                    "超合金ロボット",
                    productPrice
            );
            toyProducts[i] = toyProduct;
        }

        return toyProducts;
    }

}

