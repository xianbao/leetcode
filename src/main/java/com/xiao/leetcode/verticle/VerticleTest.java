package com.xiao.leetcode.verticle;

import io.vertx.core.Vertx;

/**
 * @Auther: xxb
 * @Date: 2020/6/15 15:14
 * @Description:
 */
public class VerticleTest {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(FirstVerticle.class.getName());
    }
}
