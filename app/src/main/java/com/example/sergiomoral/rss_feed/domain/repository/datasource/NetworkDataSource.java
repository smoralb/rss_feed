package com.example.sergiomoral.rss_feed.domain.repository.datasource;

import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;

public interface NetworkDataSource {

    Wrapper getNews(String rssFeed);

}
