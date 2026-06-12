package com.github.houbb.nlp.hanzi.similar.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class HanziSimilarHelperTest {

    @Test
    public void helloTest() {
        double rate1 = HanziSimilarHelper.similar('末', '未');
        System.out.println(rate1);
    }

    @Test
    public void similarTest() {
        double rate1 = HanziSimilarHelper.similar('末', '未');
        double rate2 = HanziSimilarHelper.similar('末', '木');
        double rate3 = HanziSimilarHelper.similar('末', '来');
        double rate4 = HanziSimilarHelper.similar('米', '来');

        System.out.println(rate1);
        System.out.println(rate2);
        System.out.println(rate3);
        System.out.println(rate4);
    }

    @Test
    public void userDefineTest() {
        double rate = HanziSimilarHelper.similar('人', '入');
        System.out.println(rate);
    }

    @Test
    public void test() {
        //[月丷夫马言卂]
        System.out.println(ChaiziHelper.chai("腾讯的微信"));
    }

    @Test
    public void similarListTest() {
        List<String> list = HanziSimilarHelper.similarList('爱');
        Assert.assertEquals("[爰, 爯, 受, 爭, 妥, 憂, 李, 爳, 叐, 雙]", list.toString());
    }

    @Test
    public void findSimilarInTextTest() {
        String text = "未来的路还很长，末日即将来临，木头人游戏开始了";
        List<SimilarMatch> matches = HanziSimilarHelper.findSimilarInText(text, '末', 0.5);

        System.out.println("匹配结果:");
        for (SimilarMatch match : matches) {
            System.out.println(match);
        }

        Assert.assertNotNull(matches);
        Assert.assertTrue(matches.size() > 0);

        for (SimilarMatch match : matches) {
            Assert.assertTrue(match.getScore() >= 0.5);
            Assert.assertTrue(match.getIndex() >= 0);
            Assert.assertTrue(match.getIndex() < text.length());
            Assert.assertEquals(text.charAt(match.getIndex()), match.getHanzi());
        }
    }

    @Test
    public void findSimilarInTextEmptyTest() {
        List<SimilarMatch> matches = HanziSimilarHelper.findSimilarInText("", '末', 0.5);
        Assert.assertTrue(matches.isEmpty());
    }

    @Test
    public void findSimilarInTextNoMatchTest() {
        String text = "一二三四五六七八九十";
        List<SimilarMatch> matches = HanziSimilarHelper.findSimilarInText(text, '末', 0.99);
        Assert.assertTrue(matches.isEmpty());
    }

}
