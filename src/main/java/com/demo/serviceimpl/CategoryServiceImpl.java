
package com.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Category;
import com.demo.repository.CategoryRepo;
import com.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepo.findById(id).orElse(null);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryRepo.deleteById(id);
	}

	@Override
	public Optional<Category> updateCategory(Category category, Integer id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			Category uCategory = optionalCategory.get();
			uCategory.setCname(category.getCname());
			uCategory.setDescription(category.getDescription());
			uCategory.setProducts(category.getProducts());
			categoryRepo.save(uCategory);
		}
		return optionalCategory;
	}
}
