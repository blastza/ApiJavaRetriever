package com.platform.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Province {
    @JsonProperty("display-name")
    private String displayName;
    private String value;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplay_name(String displayName) {
        this.displayName = displayName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
