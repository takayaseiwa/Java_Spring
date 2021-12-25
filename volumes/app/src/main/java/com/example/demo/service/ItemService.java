package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ItemForm;
import com.example.demo.repositries.ItemRepository;
import com.example.demo.repositries.ItemEntity;
import java.util.List;
import java.util.ArrayList;


@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	/**
	 * 新規登録処理
	 * @param itemForm
	 */
	public void saveAndFlush(ItemForm itemForm) {
		  ItemEntity itemEntity = new ItemEntity();
		  itemEntity.setId(itemForm.getId());
		  itemEntity.setItemname(itemForm.getItemname());
		  itemEntity.setPrice(itemForm.getPrice());
		  itemEntity.setContent(itemForm.getContent());
	      itemRepository.saveAndFlush(itemEntity);	
	}
    /**
     * データ一覧処理
     * コントローラー側でItemFormを使いたいので、Listとfor文でItemEntityの情報をItemFormに格納する 
     * @return
     */
	public List<ItemForm> findAll() {
		List<ItemEntity> itemlists = itemRepository.findAll(); 
		List<ItemForm> newItemForm = new ArrayList<>();
		for (ItemEntity itemlist : itemlists) {
			ItemForm itemForm = new ItemForm();
			itemForm.setId(itemlist.getId());
			itemForm.setItemname(itemlist.getItemname());
			itemForm.setPrice(itemlist.getPrice());
			itemForm.setContent(itemlist.getContent());
			newItemForm.add(itemForm);
		}
		return newItemForm;
	}
	/**
	 * idを基にデータを参照する処理
	 * ItemEntityの中のデータをItemFormの中に格納する
	 * @param id
	 * @return
	 */
	public ItemForm findById(Long id) {
		ItemEntity itemEntity = itemRepository.findById(id).get();
		ItemForm itemForm = new ItemForm();
		itemForm.setId(itemEntity.getId());
		itemForm.setItemname(itemEntity.getItemname());
		itemForm.setPrice(itemEntity.getPrice());
		itemForm.setContent(itemEntity.getContent());
		return itemForm;
	}
	/**
	 * 更新処理
	 * @param itemEntity
	 */
	public void save(ItemForm itemForm) {
		  ItemEntity itemEntity = new ItemEntity();
		  itemEntity.setId(itemForm.getId());
		  itemEntity.setItemname(itemForm.getItemname());
		  itemEntity.setPrice(itemForm.getPrice());
		  itemEntity.setContent(itemForm.getContent());
	      itemRepository.save(itemEntity);	
	}
	/**
	 * 削除処理
	 * @param id
	 */
	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}

}
