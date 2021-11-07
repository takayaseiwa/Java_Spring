package com.example.demo.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ItemForm;

/**
* 問い合わせを保存する用のリポジトリ
* @author ta-kun
*
*/
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

}