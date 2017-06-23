package com.example.demo.Service;

import com.example.demo.Model.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vadyan on 6/23/2017.
 */
@Singleton
@Service
public class MessageService {

    List<Message> messages = Collections.synchronizedList(new ArrayList<Message>()) ;

    @PostConstruct
    public void init() {
        messages.add(new Message("Joe","Hello"));
        messages.add(new Message("Jane","Spring Boot is cool!"));

    }

    public List<Message> getMessages() {
        return messages ;
    }

    public void postMessage(Message msg) {
        messages.add(msg);

    }
}
