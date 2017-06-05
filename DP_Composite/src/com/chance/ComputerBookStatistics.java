package com.chance;

import java.util.List;

/**
 * Created by Chance on 2016/7/21.
 */
public class ComputerBookStatistics implements Statistics {

    @Override
    public int getBrowseCount() {
        int browseCount = 0;
        List<String> allComputerBooks = Utility.getAllComputerBooks();
        for (String computerBook : allComputerBooks) {
            browseCount += Utility.getBrowseCount(computerBook);
        }
        return browseCount;
    }

    @Override
    public int getSalesCount() {
        int saleCount = 0;
        List<String> allComputerBooks = Utility.getAllComputerBooks();
        for (String computerBook : allComputerBooks) {
            saleCount += Utility.getSaleCount(computerBook);
        }
        return saleCount;
    }
}
