package com.czz.springboot.es.repository;

import com.czz.springboot.rabbitmq.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-22 16:35
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    // 参照官方文档
    public List<Book> findByBookNameLike(String bookName);
}
