package array.insert_delete_getRandom_O_1_380;

import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> valMap;
    List<Integer> valList;

    public RandomizedSet() {
        valMap = new HashMap<>();
        valList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(valMap.containsKey(val)){
            return false;
        } else {
            valMap.put(val, valList.size());
            valList.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(!valMap.containsKey(val)){
            return false;
        } else {
            int lastInd = valList.size() - 1;
            int lastVal = valList.get(lastInd);
            int removeInd = valMap.get(val);
            valMap.remove(val);
            if(lastInd != removeInd){
                valList.set(removeInd, lastVal);
                valMap.replace(lastVal, removeInd);
            }
            valList.remove(lastInd);
            return true;
        }
    }

    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(valList.size());
        return valList.get(i);
    }


    public static void main(String[] args) {
        //["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
        //[[],[0],[1],[0],[2],[1],[]]
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
    }
}
