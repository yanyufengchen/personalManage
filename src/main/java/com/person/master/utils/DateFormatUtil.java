package com.person.master.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jjma3
 * @created 2019/08/29
 */
public class DateFormatUtil {

    /**
     * 解决timestramp日期格式查询出来多一个.0的问题
     * @param date
     * @return
     * @throws Exception
     */
    public static String dataFormat(String date) throws Exception{

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //创建要显示的日期格式
        //将从数据库读出来的 timestamp 类型的时间转换为java的Date类型
        Date date1 = formatDate.parse(date);
        //将这个时间格式化，转换为String类型
        String dataFormat = formatDate.format(date1);

        System.out.println(dataFormat);
        return dataFormat;
    }

    public static String dataFormat2(String date) throws Exception{

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd"); //创建要显示的日期格式
        //将从数据库读出来的 timestamp 类型的时间转换为java的Date类型
        Date date1 = formatDate.parse(date);
        //将这个时间格式化，转换为String类型
        String dataFormat = formatDate.format(date1);

        System.out.println(dataFormat);
        return dataFormat;
    }
}
