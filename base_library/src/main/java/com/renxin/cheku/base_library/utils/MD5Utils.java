package com.renxin.cheku.base_library.utils;

import android.os.MemoryFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Desc: MD5转换
 * Created by ${junhua.li} on 2016/10/31 11:10.
 * Email: lijunhuayc@sina.com
 */
public class MD5Utils {

    public static String MD5EncodeString(byte[] source) {
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};// 用来将字节转换成16进制表示的字符
        byte tmp[] = MD5EncodeByte(source);// MD5 的计算结果是一个 128 位的长整数，
        // 用字节表示就是 16 个字节
        char str[] = new char[16 * 2];// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
        // 进制需要 32 个字符
        int k = 0;// 表示转换结果中对应的字符位置
        for (int i = 0; i < 16; i++) {// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
            // 进制字符的转换
            byte byte0 = tmp[i];// 取第 i 个字节
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,// >>>
            // 为逻辑右移，将符号位一起右移
            str[k++] = hexDigits[byte0 & 0xf];// 取字节中低 4 位的数字转换

        }
        s = new String(str);// 换后的结果转换为字符串
        return s;
    }

    public static String MD5EncodeMemoryFileString(MemoryFile mf) {
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};// 用来将字节转换成16进制表示的字符
        byte tmp[] = MD5EncodeMemoryFile(mf);// MD5 的计算结果是一个 128 位的长整数，
        // 用字节表示就是 16 个字节
        char str[] = new char[16 * 2];// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
        // 进制需要 32 个字符
        int k = 0;// 表示转换结果中对应的字符位置
        for (int i = 0; i < 16; i++) {// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
            // 进制字符的转换
            byte byte0 = tmp[i];// 取第 i 个字节
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,// >>>
            // 为逻辑右移，将符号位一起右移
            str[k++] = hexDigits[byte0 & 0xf];// 取字节中低 4 位的数字转换

        }
        s = new String(str);// 换后的结果转换为字符串

        return s;
    }

    public static byte[] MD5EncodeMemoryFile(MemoryFile mf) {
        if (mf != null) {
            int i;
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
            byte[] data = new byte[4096];
            InputStream fis = mf.getInputStream();
            while (true) {
                try {
                    i = fis.read(data);
                    if (i != -1) {
                        md.update(data, 0, i);
                    } else {
                        fis.close();
                        return md.digest();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    try {
                        fis.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    return null;
                }

            }
        }
        return null;
    }

    public static String MD5EncodeFile(String filename) {
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};// 用来将字节转换成16进制表示的字符
        byte tmp[] = MD5EncodeFileByte(filename);// MD5 的计算结果是一个 128 位的长整数，
        // 用字节表示就是 16 个字节
        char str[] = new char[16 * 2];// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
        // 进制需要 32 个字符
        int k = 0;// 表示转换结果中对应的字符位置
        for (int i = 0; i < 16; i++) {// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
            // 进制字符的转换
            byte byte0 = tmp[i];// 取第 i 个字节
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,// >>>
            // 为逻辑右移，将符号位一起右移
            str[k++] = hexDigits[byte0 & 0xf];// 取字节中低 4 位的数字转换

        }
        s = new String(str);// 换后的结果转换为字符串

        return s;
    }

    public static byte[] MD5EncodeFileByte(String filename) {
        if (filename != null) {
            int i;
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
            byte[] data = new byte[4096];
            FileInputStream fis;
            try {
                fis = new FileInputStream(filename);
            } catch (FileNotFoundException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
                return null;
            }
            while (true) {
                try {
                    i = fis.read(data);
                    if (i != -1) {
                        md.update(data, 0, i);
                    } else {
                        fis.close();
                        return md.digest();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    try {
                        fis.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    return null;
                }

            }
        }
        return null;
    }

    public static byte[] MD5EncodeByte(byte[] source) {
        byte[] tmp = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            tmp = md.digest();// MD5 的计算结果是一个 128 位的长整数，
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return tmp;
    }
}

