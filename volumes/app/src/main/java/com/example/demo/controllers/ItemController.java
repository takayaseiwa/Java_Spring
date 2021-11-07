package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.models.ItemForm;
import com.example.demo.service.ItemService;

import java.util.List;


@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
    ItemService itemService;

	/**
	 * 下記よりCRUD機能のコード
	 * @param itemForm
	 * @return
	 */
	@GetMapping("/create")
	public String create(ItemForm itemForm) {
		return "item/create";
	}

	@PostMapping("/create")
	public String create(@Validated ItemForm itemForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "item/create";
		}
		/**
		 * 登録画面からformを送るのでここはitemFormでOK
		 */
		itemService.saveAndFlush(itemForm);
		itemForm.clear();
		model.addAttribute("message", "商品を登録しました。");
		return "item/create";
	}
	/**
	 * 一覧画面の表示
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(Model model) {
		/**
		 * ItemForm
		 */
		List<ItemForm> itemlists = itemService.findAll(); 
		model.addAttribute("itemlists",itemlists);
		return "item/list";
	}
	/**
	 * 編集画面の表示
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		ItemForm itemForm = itemService.findById(id);
		model.addAttribute("itemForm", itemForm);
		return "item/edit";
	}
	/**
	 * 編集したときの更新処理
	 * @param id
	 * @param itemForm
	 * @return
	 */
	@PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @Validated @ModelAttribute ItemForm itemForm,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			return "item/edit";
		}
		itemService.save(itemForm);
        return "root/index";
    }
	/**
	 * 削除機能
	 * @param id
	 * @return
	 */
	@PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        itemService.deleteById(id);
        return "root/index";
    }	

}
