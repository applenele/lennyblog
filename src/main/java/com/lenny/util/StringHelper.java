package com.lenny.util;

/**
 * Created by apple on 15/4/2.
 */
public class StringHelper {

    /***
     * 截取文章的部分内容
     * @param str
     * @return
     */
    public static String getSomeConent(String str) {
        int size = str.length();
        if (size > 100) {
            return subString(str, 100)+"......";
        } else {
            return str;
        }
    }

    /***
     * 截取中英文字符串
     * @author nele 2015-03-24
     * @param sourceString
     * @param maxLength
     * @return
     */
    public static String subString(String sourceString, int maxLength) {
        String resultString = "";
        if (sourceString == null || sourceString.equals("") || maxLength < 1) {
            return resultString;
        } else if (sourceString.length() <= maxLength) {
            return sourceString;
        } else if (sourceString.length() > 2 * maxLength) {
            sourceString = sourceString.substring(0, 2 * maxLength);
        }

        if (sourceString.length() > maxLength) {
            char[] chr = sourceString.toCharArray();
            int strNum = 0;
            int strGBKNum = 0;
            boolean isHaveDot = false;

            for (int i = 0; i < sourceString.length(); i++) {
                if (chr[i] >= 0xa1) // 0xa1汉字最小位开始
                {
                    strNum = strNum + 2;
                    strGBKNum++;
                } else {
                    strNum++;
                }

                if (strNum == 2 * maxLength || strNum == 2 * maxLength + 1) {
                    if (i + 1 < sourceString.length()) {
                        isHaveDot = true;
                    }
                    break;
                }
            }
            resultString = sourceString.substring(0, strNum - strGBKNum);
            if (!isHaveDot) {
                resultString = resultString + "...";
            }
        }

        return resultString;
    }
}
