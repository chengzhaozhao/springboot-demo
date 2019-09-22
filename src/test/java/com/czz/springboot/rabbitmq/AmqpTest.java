package com.czz.springboot.rabbitmq;

import com.czz.springboot.rabbitmq.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-22 13:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 单播
     */
    @Test
    public void contextLoads(){
        //message 需要自己构造一个 定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routeKey,message);

        // 传入要发送的对象 自动序列化给 rabbitmq
//        rabbitTemplate.convertAndSend(exchange,routeKey,object);

        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data",Arrays.asList("helloword",123,true));
        // 默认的是 jdk 的序列化方式
//        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);

        Book build = Book.builder().bookName("西游记").author("吴承恩").build();

        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",build);

    }


    @Test
    public void contextLoads2(){

        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);

    }



    @Test
    public void contextLoads3(){
        Book build = Book.builder().bookName("西游记").author("吴承恩").build();
        rabbitTemplate.convertAndSend("exchange.fanout","",build);
    }


    @Test
    public void contextLoads4(){


        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("amqpadmin.exchange 创建完成");

        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        System.out.println("amqpadmin.queue 创建完成");

        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.haha", null));
        System.out.println("amqpadmin.binding 创建完成");

    }
}
