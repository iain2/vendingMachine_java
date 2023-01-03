package main;

import coins.Coin;
import coins.CoinType;
import products.Cola;
import products.Crisps;
import products.Product;
import products.Sweets;
import vendingMachine.CodeType;
import vendingMachine.CoinReturn;
import vendingMachine.Drawer;
import vendingMachine.VendingMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        Sweets sweets = new Sweets("Gummy Drops", "Haribo",90);
        Cola cola = new Cola("Lemonade", "Sprite", 85);
        Crisps crisps = new Crisps("Cheese & Onion", "Walkers", 67);
        Drawer drawer1 = new Drawer(crisps, CodeType.A1);
        Drawer drawer2 = new Drawer(cola, CodeType.A2);
        Drawer drawer3 = new Drawer(sweets,CodeType.A3);
        Coin coin = new Coin(CoinType.ONEPOUND);
        Coin coin50 = new Coin(CoinType.FIFTYPENCE);
        Coin coin20 = new Coin(CoinType.TWENTYPENCE);
        Coin coin10 = new Coin(CoinType.TENPENCE);
        Coin coin5 = new Coin(CoinType.FIVEPENCE);
        Coin coin2 = new Coin(CoinType.TWOPENCE);
        Coin coin1 = new Coin(CoinType.ONEPENCE);
        ArrayList<Coin> coins = new ArrayList<>();
        coins.add(coin1);
        coins.add(coin2);
        coins.add(coin5);
        coins.add(coin10);
        coins.add(coin20);
        coins.add(coin50);
        coins.add(coin);
        vendingMachine.addDrawer(drawer1);
        vendingMachine.addDrawer(drawer2);
        vendingMachine.addDrawer(drawer3);
        Drawer selectedDrawer = null;
        Scanner in = new Scanner(System.in);
        while(true) {
            boolean productSelected = false;
            while (productSelected == false) {
                System.out.println("Welcome to the vending machine, please select an option:" +
                        "\n1. " + drawer1.getProduct().getName() +
                        "\n2. " + drawer2.getProduct().getName() +
                        "\n3. " + drawer3.getProduct().getName());
                System.out.print("Option: ");
                ArrayList<Drawer> drawers = vendingMachine.getDrawers();
                try {
                    int selection = Integer.parseInt(in.next()) - 1;
                    selectedDrawer = drawers.get(selection);
                    System.out.print("You have selected: " + drawers.get(selection).getProduct().getName() +
                            "\nPrice: " + drawers.get(selection).getProduct().getPrice() + "p");
                    if (selectedDrawer != null){
                        productSelected = true;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Selection");
                }
            }
            while(true) {
                try {
                    System.out.print("\nEnter coins, 1p and 2p not accepted:" +
                            "\n1. 1p" +
                            "\n2. 2p" +
                            "\n3. 5p" +
                            "\n4. 10p" +
                            "\n5. 20p" +
                            "\n6. 50p" +
                            "\n7. £1" +
                            "\n8. Done" +
                            "\nCoin in:");
                    int input = Integer.parseInt(in.next()) - 1;
                    if (input == 7) {
                        Product product = vendingMachine.purchase(selectedDrawer);
                        if (product == null) {
                            System.out.println("Insufficient funds");
                        } else {
                            System.out.println("Your Item: " + product.getName());
                            System.out.println("Your Change: ");
                            for (int c = 0; c < vendingMachine.getCoinReturnSize(); c++) {
                                Coin returnCoin = (Coin) vendingMachine.getReturnedChange().get(c);
                                System.out.println(returnCoin.getCoinValue() + "p");
                            }
                        }
                        return;
                    }
                    vendingMachine.addCoin(coins.get(input));
                    System.out.println("Total added: " + vendingMachine.getTillValue() + "p");
                }
                catch (Exception e) {
                System.out.println("Invalid Selection");
            }
            }
        }
    }
}
