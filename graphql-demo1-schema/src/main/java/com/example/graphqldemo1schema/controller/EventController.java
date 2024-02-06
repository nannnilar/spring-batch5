package com.example.graphqldemo1schema.controller;

import com.example.graphqldemo1schema.event.Event;
import com.example.graphqldemo1schema.event.Session;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {
    private List<Event> events= new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();
    public EventController(){
//        var session1 = new Session(1,"Java Basic","From Ground Up!");
//        var session2 = new Session(2,"Graphql Novice","From Zero to Hero!");
        var event1 = new Event(1,"Java One","Best Java Community",
                LocalDate.now(),LocalDate.now().plusDays(7),LocalDate.now(),LocalDate.now().plusDays(10),
                "New York","https://www.javaone.com");
        var event2 = new Event(1,"Graphql One","Best Java Community",
                LocalDate.now(),LocalDate.now().plusDays(7),LocalDate.now(),LocalDate.now().plusDays(10),
                "LA","https://www.graphql.com");
        events.add(event1);
//        events.add(event2);
//        sessions.add(session1);
//        sessions.add(session2);
    }
    @SchemaMapping
    public List<Session> sessions(Event event){
        var session = new Session(1,"JavaOne","Beginner");

        return List.of(session);
    }

    @QueryMapping
    public List<Event> events(){
        return events;
    }
}
