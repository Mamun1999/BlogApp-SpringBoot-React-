package com.mamun.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamun.blog.payloads.ApiResponse;
import com.mamun.blog.payloads.CategoryDto;
import com.mamun.blog.services.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory( @Valid 
        @RequestBody CategoryDto categoryDto){
      CategoryDto categoryDto2= this.categoryService.createCategory(categoryDto);

       return new ResponseEntity<>(categoryDto2,HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto>
     updateCategory(@Valid @RequestBody CategoryDto categoryDto,
        @PathVariable Integer categoryId ){

            this.categoryService.updateCategory(categoryDto, categoryId);

            return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
        
        return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));
        //return new ResponseEntity<>(this.categoryService.getCategoryById(categoryId),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){

        return ResponseEntity.ok(this.categoryService.getAllCategory());

    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
         this.categoryService.deleteCategory(categoryId);

        return new ResponseEntity<>(new ApiResponse("category deleted Successfully", true),HttpStatus.OK);
        
    }
}
