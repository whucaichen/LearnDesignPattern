package com.chance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Chance on 2016/7/21.
 */
public class Utility {

    public static List<String> getAllNovels(){
        List<String> lists = new ArrayList<String>();
        for (int i=0; i<10; i++){
            lists.add("Novel"+ i);
        }
        return lists;
    }

    public static List<String> getAllComputerBooks(){
        List<String> lists = new ArrayList<String>();
        for (int i=0; i<5; i++){
            lists.add("ComputerBook"+ i);
        }
        return lists;
    }

    public static List<String> getAllMedicalBooks(){
        List<String> lists = new ArrayList<String>();
        for (int i=0; i<5; i++){
            lists.add("MedicalBook"+ i);
        }
        return lists;
    }

    public static int getBrowseCount(String name){
        return getInt(getString(10));
    }

    public static int getSaleCount(String name){
        return getInt(getString(10));
    }

    private static String getString(int digits){
        String result = "";
        if(digits>0){
            int flag;
            while (digits-->0){
                flag = new Random().nextInt(2);
                if(flag == 0){
                    result+= (char)(65+ new Random().nextInt(26));
                }else {
                    result+= (char)(97+ new Random().nextInt(26));
                }
            }
        }else {
            result = "ERROR";
        }
        return result.toString();
    }

    private static int getInt(String string){
        return string.hashCode();
    }
}
