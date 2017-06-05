package com.chance;

import java.util.List;

/**
 * Created by Chance on 2016/7/21.
 */
public class MedicalBookStatistics implements Statistics {

    @Override
    public int getBrowseCount() {
        int browseCount = 0;
        List<String> allMedicalBooks = Utility.getAllMedicalBooks();
        for (String medicalBook : allMedicalBooks) {
            browseCount += Utility.getBrowseCount(medicalBook);
        }
        return browseCount;
    }

    @Override
    public int getSalesCount() {
        int saleCount = 0;
        List<String> allMedicalBooks = Utility.getAllMedicalBooks();
        for (String medicalBook : allMedicalBooks) {
            saleCount += Utility.getSaleCount(medicalBook);
        }
        return saleCount;
    }
}
