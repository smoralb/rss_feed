package com.example.sergiomoral.rss_feed.domain.executor;

public interface MainThreadExecutor {

    void execute(Runnable runnable);
}
