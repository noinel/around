package com.cos.around.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.around.admin.model.WebPage;

public interface WebPageRepository extends JpaRepository<WebPage, Integer>{

}
