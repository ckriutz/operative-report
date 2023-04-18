package com.operativereport.web.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.operativereport.web.OperativeObject;

@Controller
public class WebController {
    @RequestMapping(value = "/")
    public String index(@RequestParam(name="id", required=false, defaultValue="0") String name, Model model) { 
        RestTemplate rt = new RestTemplate();
        String operativeApiurl = "http://localhost:5000/code";
        OperativeObject obj = new OperativeObject();

        ResponseEntity<String> response = rt.getForEntity(operativeApiurl, String.class);
        if(response.getStatusCode() == HttpStatus.OK){
            // Okay! This *should* be easier since we have the ability to just call
            // .getForObject(operativeApiurl, OperativeObject.class);
            // but it never works and we get some errors, SO, if we just use ObjectMapper it works better.
            // just need to handle some things.
            String json = response.getBody();
            ObjectMapper mapper = new ObjectMapper();
            try {
                obj = mapper.readValue(json, OperativeObject.class);
            }
            catch(JsonProcessingException jpe) {
                // Something weird happened with processing. Lets jsut create an object and move on.
                obj.Adjective = "error";
                obj.Person = "error";
                obj.MachineName = "error";
                obj.Emoji = "error";
            }
            
        }
        else {
            // oh god something happened. Okay, lets just create a object so we have something to work with.
            obj.Adjective = "error";
            obj.Person = "error";
            obj.MachineName = "error";
            obj.Emoji = "error";
        }

        model.addAttribute("person", obj.Person);
        model.addAttribute("adjective", obj.Adjective);
        model.addAttribute("emoji", emojiMapper(obj.Emoji));
        model.addAttribute("machineName", obj.MachineName);
        return "index";
    }

    private String emojiMapper(String e) {
        // Until we can figure out how to serialize emojis, this will have to do.
        if (e.equals("pineapple")) { return "🍍"; }
        if (e.equals("robot")) { return "🤖"; }
        if (e.equals("fire")) { return "🔥"; }
        if (e.equals("party")) { return "🎉"; }
        if (e.equals("ghost")) { return "👻"; }
        if (e.equals("skull")) { return "💀"; }
        if (e.equals("rocket")) { return "🚀"; }
        if (e.equals("puzzle")) { return "🧩"; }
        return "❓";
    }
}