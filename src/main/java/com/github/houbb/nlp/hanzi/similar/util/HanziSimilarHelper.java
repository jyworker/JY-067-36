package com.github.houbb.nlp.hanzi.similar.util;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.nlp.hanzi.similar.bs.HanziSimilarBs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 汉字相似度工具类
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public final class HanziSimilarHelper {

    private HanziSimilarHelper(){}

    /**
     * 默认实例
     * @since 1.4.0
     */
    private static final HanziSimilarBs DEFAULT_INSTANCE = HanziSimilarBs.newInstance().init();

    /**
     * 相似度
     * @param hanziOne 汉字一
     * @param hanziTwo 汉字二
     * @return 结果
     */
    public static double similar(char hanziOne, char hanziTwo) {
        return DEFAULT_INSTANCE.similar(hanziOne, hanziTwo);
    }

    /**
     * 相似的列表
     * @param hanziOne 汉字一
     * @param limit 大小
     * @return 结果
     * @since 1.3.0
     */
    public static List<String> similarList(char hanziOne, int limit) {
        return DEFAULT_INSTANCE.similarList(hanziOne, limit);
    }

    /**
     * 相似的列表
     * @param hanziOne 汉字一
     * @return 结果
     * @since 1.3.0
     */
    public static List<String> similarList(char hanziOne) {
        return similarList(hanziOne, 10);
    }

    /**
     * 在文本中查找与目标汉字相似度超过阈值的所有汉字及其位置
     * @param text 文本
     * @param target 目标汉字
     * @param threshold 相似度阈值
     * @return 结果列表
     * @since 1.5.0
     */
    public static List<SimilarMatch> findSimilarInText(String text, char target, double threshold) {
        ArgUtil.notNull(text, "text");
        ArgUtil.notNegative(threshold, "threshold");

        if (text.isEmpty()) {
            return Collections.emptyList();
        }

        List<SimilarMatch> resultList = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            double score = similar(target, current);
            if (score >= threshold) {
                resultList.add(new SimilarMatch(current, i, score));
            }
        }
        return resultList;
    }

}
