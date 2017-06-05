package com.chance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chance on 2016/7/21.
 */
public class TechnicalStatistics implements Statistics {

    private List<Statistics> statistics = new ArrayList<Statistics>();

    public TechnicalStatistics() {
        statistics.add(new ComputerBookStatistics());
        statistics.add(new MedicalBookStatistics());
    }

    @Override
    public int getBrowseCount() {
        int browseCount = 0;
        for (Statistics s : statistics) {
            browseCount += s.getBrowseCount();
        }
        return browseCount;
    }

    @Override
    public int getSalesCount() {
        int saleCount = 0;
        for (Statistics s : statistics) {
            saleCount += s.getBrowseCount();
        }
        return saleCount;
    }
}
