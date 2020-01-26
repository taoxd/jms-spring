package com.imooc.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;
    //@Resource(name = "queueDestination")
    @Resource(name = "topicDestination")
    Destination destination;

    @Override
    public void sendMessage(String message) {
        //ʹ��JmsTemplate������Ϣ
        jmsTemplate.send(destination, new MessageCreator() {
            //����һ����Ϣ
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
        System.out.println("������Ϣ: " + message);
    }
}
