package cn.liuyiyou.ds.chapter01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/18
 * @version: V1.0
 */
public class GcdTest {

    @Test
    public void gcd() {
        int gcd = Gcd.gcd(24, 126);
        System.out.println(gcd);
    }
}