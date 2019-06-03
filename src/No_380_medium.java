import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class No_380_medium {
    /** Initialize your data structure here. */
    Set<Integer> set = new HashSet<Integer>();
    public No_380_medium() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Object[] a = set.toArray();
        Random random = new Random();
        return (int) a[random.nextInt(a.length)];
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
