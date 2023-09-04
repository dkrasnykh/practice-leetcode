package array.design_an_atm_machine_2241;

import java.util.HashMap;
class ATM {
    int[] d = new int[]{20, 50, 100, 200, 500};
    HashMap<Integer, Long> balance;

    public ATM() {
        balance = new HashMap<>();
        for(int i = 0; i < d.length; ++i){
            balance.put(d[i], 0L);
        }
    }

    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < banknotesCount.length; ++i){
            final long increment = banknotesCount[i];
            balance.compute(d[i], (k,v) -> v += increment);
        }
    }

    public int[] withdraw(int amount) {
        int[] banknotesCount = new int[5];
        for(int i = 4; i >= 0; --i){
            if(d[i] <= amount && balance.get(d[i]) > 0){
                long cnt = Math.min(amount / d[i], balance.get(d[i]));
                banknotesCount[i] = (int)cnt;
                amount -= d[i]*banknotesCount[i];
            }
        }
        if(amount != 0){
            return new int[]{-1};
        }
        for(int i = 0; i < banknotesCount.length; ++i){
            final long increment = banknotesCount[i];
            balance.compute(d[i], (k,v) -> v -= increment);
        }
        return banknotesCount;
    }
}