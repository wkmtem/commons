package com.compass.common.algorithm;

import java.util.Random;

/**
 * 
 * <p>Class Name: RandomCode</p>
 * <p>Description: 按一定的概率生成>=3位的随机码</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日上午11:56:00
 * @version 2.0
 */
public class RandomCode {
	
	private static final byte INDEX_NUMBER = 0;
    private static final byte INDEX_LETTER = 1;
    private static final byte INDEX_SPECIAL_CHAR = 2;

    /**
     * 特殊符号
     */
    private static final char[] SPECIAL_CHARS = {
    	'`', '~', '!', '@', '#', '$', '%', '^', '*', '(', 
    	')', '-', '_', '+', '[', ']', '{', '}', '\\', '|', 
    	';', ':', '\'', '"', ',', '<', '.', '>', '/' };

    /**
     * 
     * <p>Method Name: generateRandomCode</p>
     * <p>Description: 按一定的概率生成>=3位的随机码，由字母数字特殊符号组成，三者缺一不可</p>
     * @author wkm
     * @date 2017年8月15日上午11:57:33
     * @version 2.0
     * @param len 随机码长度,必须大于等于3
     * @param paramGenChances 依次是数字、字母、特殊符号的概率
     * @return code 生成的随机码
     * @throws IllegalArgumentException
     */
    public static char[] generateRandomCode(final int len, final byte[] paramGenChances) 
    		throws IllegalArgumentException {
        
    	if (len < 3) {
            throw new IllegalArgumentException("len must not smaller than 3, but now is " + len);
        }
        final char[] code = new char[len];
        // 复制一份：为了使函数不对外产生影响
        final byte[] genChances = paramGenChances.clone();
        final byte[] genNums = new byte[genChances.length];
        for (byte i = 0; i < genChances.length; i++) {
            genNums[i] = 0;
        }
        final Random random = new Random();
        int r;
        for (int i = 0; i < len; i++) {
            adjustGenChance(len, i, genChances, genNums);
            byte index = getCodeCharType(random, genChances);
            genNums[index]++;
            switch (index) {
            case INDEX_NUMBER:
                code[i] = (char) ('0' + random.nextInt(10));
                break;
            case INDEX_LETTER:
                r = random.nextInt(52);
                if (r < 26) {
                    code[i] = (char) ('A' + r);
                } else {
                    code[i] = (char) ('a' + r - 26);
                }
                break;
            case INDEX_SPECIAL_CHAR:
                r = random.nextInt(SPECIAL_CHARS.length);
                code[i] = SPECIAL_CHARS[r];
                break;
            default:
                code[i] = ' ';
                break;
            }
        }
        logChances(genNums); // 打印各类字符的个数
        return code;
    }
    

    /**
     * 
     * <p>Method Name: adjustGenChance</p>
     * <p>Description: 根据当前需要生成随机码字符的位置,动态调整生成概率</p>
     * @author wkm
     * @date 2017年8月15日下午12:00:37
     * @version 2.0
     * @param len 待生成的总长度
     * @param index 当前位置
     * @param genChances 依次是生成数字、字母、特殊符号的概率
     * @param genNums 数字、字母、特殊符号已经生成过的次数
     */
    private static void adjustGenChance(final int len, final int index, final byte[] genChances, final byte[] genNums) {
        final int leftCount = len - index;
        byte notGenCount = 0;
        for (byte i = 0; i < genChances.length; i++) {
            if (genNums[i] == 0) {
                notGenCount++;
            }
        }
        if (notGenCount > 0 && leftCount < genChances.length && leftCount == notGenCount) {
            for (byte i = 0; i < genChances.length; i++) {
                if (genNums[i] > 0) {
                    genChances[i] = 0;
                }
            }
        }
    }
    

    /**
     * 
     * <p>Method Name: getCodeCharType</p>
     * <p>Description: 获取该密码字符的类型</p>
     * @author wkm
     * @date 2017年8月15日下午12:02:23
     * @version 2.0
     * @param random 随机数生成器
     * @param genChances 依次是生成数字、字母、特殊符号的概率
     * @return 随机码字符的类型
     */
    private static byte getCodeCharType(final Random random, final byte[] genChances) {
        int total = 0;
        byte i = 0;
        for (; i < genChances.length; i++) {
            total += genChances[i];
        }
        int r = random.nextInt(total);
        for (i = 0; i < genChances.length; r -= genChances[i], i++) {
            if (r < genChances[i]) {
                break;
            }
        }
        return i;
    }


    /**
     * 
     * <p>Method Name: logChances</p>
     * <p>Description: 控制台输出随机码中各类字符的个数</p>
     * @author wkm
     * @date 2017年8月15日下午12:03:18
     * @version 2.0
     * @param genNums 计数器
     */
    private static void logChances(byte[] genNums) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (byte i = 0; i < genNums.length; i++) {
            sb.append(genNums[i]);
            if (i != genNums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}
