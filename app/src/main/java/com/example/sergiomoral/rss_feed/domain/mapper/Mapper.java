package com.example.sergiomoral.rss_feed.domain.mapper;

public interface Mapper<M, P> {

    P map(M model);

    M inverseMap(P model);
}
