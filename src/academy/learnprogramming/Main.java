package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);

    private static GroceryList groceryList = new GroceryList();

    private static int[] baseData = new int[3];

    public static void main(String[] args) {
        groceryList.addGroceryItem("Soy Milk");
        groceryList.addGroceryItem("Eggs");
        groceryList.addGroceryItem("Bread");
        groceryList.addGroceryItem("Tomato");
        groceryList.addGroceryItem("Mayo");
        groceryList.addGroceryItem("Ham");
        groceryList.printGroceryList();

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.print("Enter your choice : ");
            choice = s.nextInt();
            s.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processedArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    // ======================================================
        System.out.println("Enter 3 integers : ");
        getInput();
        printArray(baseData);
        resizeArray();
        System.out.println("New baseData : " + Arrays.toString(baseData));
        System.out.println("Enter 5 integers : ");
        getInput();
        printArray(baseData);
    }

// *****************************************************

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To print processed array.");
        System.out.println("\t 7 - To quit the application.");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item : ");
        groceryList.addGroceryItem(s.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Enter item name : ");
        String itemName = s.nextLine();
        System.out.print("Enter new item : ");
        String newItem = s.nextLine();
        groceryList.modifyGroceryItem(itemName, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item name : ");
        String itemName = s.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    public static void searchForItem() {
        System.out.print("Enter item name to search for : ");
        String searchItem = s.nextLine();
        if(groceryList.findItem(searchItem) >= 0) {
            System.out.println("Found " + searchItem + " in the grocery list");
        } else {
            System.out.println(searchItem + " is not in the grocery list");
        }
    }

    public static void processedArrayList() {
        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);

        System.out.println(Arrays.toString(myArray));
    }
    // =================================================================
    private static void getInput() {
        for(int i = 0; i < baseData.length; i++) {
            baseData[i] = s.nextInt();
//            s.nextLine();
        }
    }

    private static void printArray(int[] array) {
        System.out.println("Array : " + Arrays.toString(array));
    }

    private static void resizeArray() {
        int[] originalArray = baseData;

        baseData = new int[5];
        for(int i = 0; i < originalArray.length; i++) {
            baseData[i] = originalArray[i];
        }
    }
}
