package com.example.demo.api.sample;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sample")
public class Sample implements Serializable {

    @Id
    @GeneratedValue(generator = "sequence_dep_id")
    private Long id;
    private String name;
    private String content;

    public Sample() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Sample(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sample [id=" + id + ", name=" + name + "]";
    }

}
