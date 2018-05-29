/**
 * Date:     2018/5/2921:32
 * AUTHOR:   Administrator
 */
package com.zhou.basejava8.chapter01.sort;

import java.io.File;
import java.io.FileFilter;

/**
 * 帅选隐藏文件夹
 * 2018/5/29  21:32
 * created by zhoumb
 */
public class FileFilterHiden {

    public static void main(String[] args) {
        filterBefore();
    }

    public static void filterBefore(){
        File[] files = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        for (File file:
             files) {
            System.out.println(file.getName());
            System.out.println(file.getPath());
        }
    }

    public void filterInJava8(){

    }
}
