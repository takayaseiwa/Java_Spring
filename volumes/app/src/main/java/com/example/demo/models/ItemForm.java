package com.example.demo.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemForm implements Serializable {
	private static final long serialVersionUID = -6647247658748349084L;

	private long id;

	@NotBlank
	@Size(max = 10)
	private String itemname;

	@NotNull
	@Max(1000000)
	private int price;

	@NotBlank
	@Size(max = 400)
	private String content;
	
	public void clear() {
		itemname = null;
		content = null;
	}
	
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getItemname() {
        return itemname;
    }
    public void setItemname(String name) {
        this.itemname = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
