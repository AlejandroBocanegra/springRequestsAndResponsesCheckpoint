package com.galvanize.springRequestsAndResponsesCheckpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController {

    //server test
    @GetMapping ("/hello")
    public String helloWorld () {
        return "hello world from test";
    }

    //GET /camelize
    @GetMapping ("/camelize")
    public String getCamelize(
            @RequestParam (value="original") String snakeCase
    )
    {
        if (snakeCase.contains("_")) {
            String[] result = snakeCase.split("_");
            return result[0];
        }else {
            return snakeCase;
        }
    }

    //GET /redact
    @GetMapping("/redact")
    public String original (
            @RequestParam (value="badWord") String obscenity
    )
    {
        return "hello from redact";
    }

    //POST /encode
    @PostMapping ("/encode")
    public String formData (
            @RequestParam (value= "key") String cipher,
            @RequestParam (value= "message") String missive
    )
    {
        return "hello from encode";
    }

    //POST /s/<find>/<replacement>
    @PostMapping ("/s")
    public String findReplace (
            @RequestParam (value= "body") String bodeh,
            @RequestParam (value= "find") String descry,
            @RequestParam (value= "replace") String oust
    )
    {
        String body = bodeh;
        String find = descry;
        String replace = oust;
        String findReplaceBody = body.replace(find,replace);
        return findReplaceBody;
    }
}
