package com.matthew.feng.other.feb20;

import java.util.ArrayList;
import java.util.List;

public class Factor {
    public long pthFactor(long n, int p) {

        List<Long> factors = getFactors(n);
        if (p > factors.size()) {
            return 0;
        }
        return factors.get(p - 1);

    }

    private List<Long> getFactors(long n) {
        ArrayList<Long> answer = new ArrayList<>();
        for (long i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                answer.add(i);
            }
        }
        return answer;
    }
}
