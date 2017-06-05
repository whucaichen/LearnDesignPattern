package com.chance;

/**
 * Created by Chance on 2016/7/21.
 */
public class Test {

    public static void main(String[] args) {
        String result;
        result = XMLBuilder.buildXML(new ServerOne());
        System.out.println(result+"\n");
        result = XMLBuilder.buildXML(new ServerTwo());
        System.out.println(result+"\n");
        result = XMLBuilder.buildXML(new ServerThree());
        System.out.println(result + "\n");
    }
}
