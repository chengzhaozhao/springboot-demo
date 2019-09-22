package com.czz.springboot.es.bean;

import io.searchbox.annotations.JestId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-22 15:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

}
