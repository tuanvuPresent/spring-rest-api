package com.example.demo.api.sample;

public class SampleDto {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SampleDto(Sample sample) {
        this.id = sample.getId();
        this.name = sample.getName();
    }
}
