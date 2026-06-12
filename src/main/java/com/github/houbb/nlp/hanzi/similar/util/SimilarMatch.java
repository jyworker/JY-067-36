package com.github.houbb.nlp.hanzi.similar.util;

/**
 * 相似匹配结果
 *
 * @author binbin.hou
 * @since 1.5.0
 */
public class SimilarMatch {

    private char hanzi;

    private int index;

    private double score;

    public SimilarMatch(char hanzi, int index, double score) {
        this.hanzi = hanzi;
        this.index = index;
        this.score = score;
    }

    public char getHanzi() {
        return hanzi;
    }

    public void setHanzi(char hanzi) {
        this.hanzi = hanzi;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "SimilarMatch{" +
                "hanzi=" + hanzi +
                ", index=" + index +
                ", score=" + score +
                '}';
    }

}
