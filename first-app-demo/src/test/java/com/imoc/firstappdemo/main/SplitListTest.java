package com.imoc.firstappdemo.main;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author jianghua
 * @date 2021/01/25
 */
public class SplitListTest {

    /**
     * 批量更新电池，数量上限
     */
    private static final int BATCH_LIMIT = 4;

    public static void main(String [] args) {
        List<String> guids = Lists.newArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17");
        List<List<String>> result = split(guids);
        System.out.println("result:" + result);
    }


    private static List<List<String>> split(List<String> list) {
        List<List<String>> result = Lists.newArrayList();
        int size = list.size();
        if (size <= BATCH_LIMIT) {
            result.add(list);
            return result;
        }

        int batch = size / BATCH_LIMIT + (size % BATCH_LIMIT == 0 ? 0 : 1);

        int from = 0;
        for (int i = 1; i <= batch; i++) {
            if (i == batch) {
                result.add(list.subList(from, size));
            } else {
                result.add(list.subList(from, from + BATCH_LIMIT));
            }
            from += BATCH_LIMIT;
        }
        return result;

    }
}
