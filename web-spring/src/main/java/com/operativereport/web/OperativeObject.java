package com.operativereport.web;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
//public record OperativeObject(String Person, String Adjective, String Emoji, String MachineName) { }
public class OperativeObject implements Serializable  {
    public String Person;
    public String Adjective;
    public String Emoji;
    public String MachineName;

    public OperativeObject() {
        super();
    }

    public OperativeObject(String Person, String Adjective, String Emoji, String MachineName) {
        this.Person = Person;
        this.Adjective = Adjective;
        this.Emoji = Emoji;
        this.MachineName = MachineName;
    }
}