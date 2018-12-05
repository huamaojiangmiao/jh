package com.jh.suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayNesting {


    public static void main(String [] args) {
        int [] array = {5,4,0,3,1,6,2};
        Map<Integer, Element> map = new HashMap<Integer, Element>();
        //所有元素创建当前节点，以及它的下一个节点
        for (int i = 0 ; i < array.length; i++) {
            Integer value = array[i];
            Element e = map.get(value);
            if (e == null) {
                e = new Element(value);
                map.put(value, e);
            }

            if (e.getNext() == null && value < array.length) {
                if(map.get(array[value]) == null) {
                    map.put(array[value], new Element(array[value]));
                }
                e.setNext(map.get(array[value]));
            }
        }
        List<Integer> start = null;
        int n = 0;
        for (Integer key : map.keySet()) {
            Element tmp = map.get(key);
            int count = 1;
            List<Integer> nums = new ArrayList<Integer>();
            nums.add(tmp.getAaaaaa());
            while(tmp.next != null && tmp.next.getAaaaaa().intValue() != map.get(key).getAaaaaa().intValue()) {
                count ++;
                tmp = tmp.next;
                nums.add(tmp.getAaaaaa());
            }
            if (count > n) {
                n = count;
                start = nums;
            }
        }
        System.out.println("--->"+start+",  count:"+n);

//        System.out.println("--->"+max(array));
    }

    /**
     854 / 856 test cases passed.
     * @param array
     * @return
     */
    public static int max(int [] array) {
        int max = 0;
        int i = 0;
        while(i < array.length) {
            int now = array[i];
            int tmpMax = 1;
            int tmp = now;
            while (tmp < array.length && array[tmp] != now) {
                tmpMax ++;
                tmp = array[tmp];
            }

            if (tmpMax > max) {
                max = tmpMax;
            }
            i++;
        }
        return max;
    }
}

/**
 * 定义一个元素结构， pre:上一个节点，value:当前值， next:下一个节点
 */
class Element {
    Integer aaaaaa;
    Element next;

    @Override
    public String toString() {
        return "value:"+(aaaaaa==null ? "": aaaaaa);
    }

    public Element(Integer value) {
        this.aaaaaa = value;
    }

    public Integer getAaaaaa() {
        return aaaaaa;
    }

    public void setAaaaaa(Integer aaaaaa) {
        this.aaaaaa = aaaaaa;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
