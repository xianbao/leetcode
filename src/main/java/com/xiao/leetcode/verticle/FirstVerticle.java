package com.xiao.leetcode.verticle;

import io.vertx.core.AbstractVerticle;

/**
 * @Auther: xxb
 * @Date: 2020/6/15 15:16
 * @Description:
 */
public class FirstVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req->{
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello World!");
        }).listen(8080);
    }
}
