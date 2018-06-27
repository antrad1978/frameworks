package com.samples;

import org.springframework.stereotype.Component;

@Component("formatter")
public class Formatter {

    public String format() {
        return "foo";
    }
}
