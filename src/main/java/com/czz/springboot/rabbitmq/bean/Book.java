package com.czz.springboot.rabbitmq.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-22 13:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "book-es",type = "book")
public class Book {
    private Integer id;
    private String bookName;
    private String author;

}
