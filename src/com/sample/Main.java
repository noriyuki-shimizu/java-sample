package com.sample;

public class Main {
    public static void main(String[] args) {
        execute();
    }

    public static void execute() {

        ToyMaterial[] toyMaterials = new ToyMaterial[10];
        for(int i=0; i<10; i++) {
            toyMaterials[i] = new ToyMaterial("アルミ", 10000);
        }

        Employee[] employees = new Employee[3];
        employees[0] = new Employee("木村", 180000);
        employees[1] = new Employee("佐藤", 240000);
        employees[2] = new Employee("山田", 210000);

        ToyFactory toyFactory = new ToyFactory(employees);
        ToyProduct[] toyProducts = toyFactory.makeProduct(toyMaterials);

        for(int i=0; i<toyProducts.length; i++) {
           System.out.println(toyProducts[i].toString());
        }
    }
}
