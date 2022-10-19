package com.example.demo.core;

import java.io.Serializable;
import java.time.Instant;

public class SnowFlake {
    private static SnowFlake instance;
    private long epoch;
    private long shareId;
    private long seq;
    private long timeCurrent;


    public SnowFlake(long epoch, long shareId, long seq) {
        long current = Instant.now().toEpochMilli();
        this.epoch = epoch;
        this.shareId = shareId;
        this.seq = seq;
        this.timeCurrent = current - this.epoch;
    }

    public static SnowFlake getInstance() {
        if (instance == null) {
            instance = new SnowFlake(1666168106646L, 10L, 0L);
        }
        return instance;
    }

    public Serializable gen() {
        long current = Instant.now().toEpochMilli() - this.epoch;
        if (this.timeCurrent == current) {
            this.seq += 1L;
        } else {
            this.seq = 0L;
        }

        this.timeCurrent = current;
        return this.timeCurrent << 23 | this.shareId << 10 | this.seq;
    }
}
