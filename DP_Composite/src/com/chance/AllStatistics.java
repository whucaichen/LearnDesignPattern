package com.chance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chance on 2016/7/21.
 */
public class AllStatistics implements Statistics {

    private List<Statistics> statistics = new ArrayList<Statistics>();

    public AllStatistics() {
        statistics.add(new NovelStatistics());
        statistics.add(new TechnicalStatistics());
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
