package com.chance;

import java.util.List;

/**
 * Created by Chance on 2016/7/21.
 */
public class NovelStatistics implements Statistics{

    @Override
    public int getBrowseCount() {
        int browseCount = 0;
        List<String> allNovels = Utility.getAllNovels();
        for (String novel : allNovels) {
            browseCount += Utility.getBrowseCount(novel);
        }
        return browseCount;
    }

    @Override
    public int getSalesCount() {
        int saleCount = 0;
        List<String> allNovels = Utility.getAllNovels();
        for (String novel : allNovels) {
            saleCount += Utility.getSaleCount(novel);
        }
        return saleCount;
    }
}
