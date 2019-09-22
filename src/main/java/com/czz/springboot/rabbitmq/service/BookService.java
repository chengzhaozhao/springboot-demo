package com.czz.springboot.rabbitmq.service;

import com.czz.springboot.rabbitmq.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-22 13:49
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息 :" + book);
    }

    @RabbitListener(queues = {"atguigu.emps"})
    public void receive2(Message message){
        System.out.println("body :"+ message.getBody());

        System.out.println("message:" + message.getMessageProperties());
    }
}
