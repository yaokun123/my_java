package com.designmode.p_adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 适配器模式(包装器/转换器)-将原来不兼容的两个类融合在一起
 */
public class Main {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("/tmp/demo.txt");
        InputStreamReader isr = new InputStreamReader(fis);// 充当转接器
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")){
            System.out.println(line);
        }
        br.close();
    }
}
