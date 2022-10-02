package com.crawl.foodcrawler.dto.getir.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Data {
    public List<Item> items;
    public int totalCount;
    public Meta meta;
}
