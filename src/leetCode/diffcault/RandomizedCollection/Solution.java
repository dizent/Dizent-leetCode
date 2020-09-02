package leetCode.diffcault.RandomizedCollection;

import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.insert(2);
        boolean param_3 = obj.remove(1);
        int param_4 = obj.getRandom();
    }

}

class RandomizedCollection {


    Integer[] nodes;
    int length = 16;

    int size = 0;
    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        nodes = new Integer[length];
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        return true;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return 0;
    }
}
