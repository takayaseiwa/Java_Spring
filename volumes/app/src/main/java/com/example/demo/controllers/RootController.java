package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.InquiryForm;
import com.example.demo.repositries.InquiryRepository;
import com.example.demo.models.InquiryForm2;
import com.example.demo.repositries.InquiryRepository2;


@Controller
@RequestMapping("/")
public class RootController {

	@Autowired
	InquiryRepository repository;
	@Autowired
	InquiryRepository2 repository2;

	
	@GetMapping
	public String index() {
		return "root/index";
	}

	@GetMapping("/form")
	public String form(InquiryForm inquiryForm) {
		return "root/form";
	}

	@PostMapping("/form")
	public String form(@Validated InquiryForm inquiryForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/form";
		}
		
		// RDBと連携できることを確認しておきます。
		repository.saveAndFlush(inquiryForm);
		inquiryForm.clear();
		model.addAttribute("message", "お問い合わせを受け付けました。");
		return "root/form";
	}
	
	@GetMapping("/form2")
	public String form2(InquiryForm inquiryForm) {
		return "root/form2";
	}

	@PostMapping("/form2")
	public String form2(@Validated InquiryForm inquiryForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/form2";
		}
		
		// RDBと連携できることを確認しておきます。
		repository.saveAndFlush(inquiryForm);
		inquiryForm.clear();
		model.addAttribute("message", "お問い合わせを受け付けました。");
		return "root/form2";
	}
	//form2までのDBとは別のDBに接続するための実装
	@GetMapping("/form3")
	public String form3(InquiryForm2 inquiryForm2) {
		return "root/form3";
	}

	@PostMapping("/form3")
	public String form3(@Validated InquiryForm2 inquiryForm2, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/form3";
		}
		
		// RDBと連携できることを確認しておきます。
		repository2.saveAndFlush(inquiryForm2);
		inquiryForm2.clear();
		model.addAttribute("message", "お問い合わせを受け付けました。");
		return "root/form3";
	}
	
}