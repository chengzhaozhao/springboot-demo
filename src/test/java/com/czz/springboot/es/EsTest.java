package com.czz.springboot.es;

import com.czz.springboot.es.bean.Article;
import com.czz.springboot.es.repository.BookRepository;
import com.czz.springboot.rabbitmq.bean.Book;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-22 15:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    private JestClient jestClient;
    @Autowired
    private BookRepository bookRepository;

    /**
     * 创建
     */
    @Test
    @SneakyThrows
    public void textLoads(){
        // 给 es 索引
        Article article = Article.builder().id(1).title("好消息").author("程昭昭").content("es save").build();
        // 构建索引
        Index index = new Index.Builder(article).index("springboot-es-save").type("news").build();
        jestClient.execute(index);
    }

    /**
     * 搜索
     */
    @Test
    @SneakyThrows
    public void textLoads2(){
        // 构建索引
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"es\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search news = new Search.Builder(json).addIndex("springboot-es-save").addType("news").build();
        SearchResult execute = jestClient.execute(news);
        System.out.println(execute.getJsonString());

    }


    @Test
    @SneakyThrows
    public void textLoads3() {
        Book book = Book.builder().build();
        bookRepository.index(book);
    }

    @Test
    @SneakyThrows
    public void textLoads4() {
        List<Book> bookList = bookRepository.findByBookNameLike("西游记");
        System.out.println(bookList);
    }
}
