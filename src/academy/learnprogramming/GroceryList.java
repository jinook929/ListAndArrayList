package academy.learnprogramming;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

//    public static void main(String[] args) {
//
//    }

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String item, String newItem) {
        int position = findItem(item);
        if(position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }
    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item #" + (position + 1) + " has been modified.");
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if(position >= 0) {
            removeGroceryItem(position);
        }
    }
    private void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        System.out.println(theItem + " is being removed...");
        groceryList.remove(position);
        System.out.println("Grocery item #" + (position + 1) + " has been removed.");
    }

    public int findItem(String searchItem) {
//        System.out.println(groceryList.indexOf(searchItem));
        return groceryList.indexOf(searchItem);
    }
}
