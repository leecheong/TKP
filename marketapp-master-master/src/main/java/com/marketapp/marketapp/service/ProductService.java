package com.marketapp.marketapp.service;


import com.marketapp.marketapp.DTO.productDTO;
import com.marketapp.marketapp.exception.ItemNotFoundException;
import com.marketapp.marketapp.model.category;
import com.marketapp.marketapp.model.product;
import com.marketapp.marketapp.model.status;
import com.marketapp.marketapp.repository.CategoryRepository;
import com.marketapp.marketapp.repository.ProductRepository;
import com.marketapp.marketapp.repository.StatusRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {

    @Autowired
    private ProductRepository p_repository;
    @Autowired
    private StatusRepository s_repository;
    @Autowired
    private CategoryRepository c_repository;

    //show all product
        public List<product> ShowAllProducts() {
            List<product> allproducts = new ArrayList<>();
            p_repository.findAll().forEach(allproducts::add);

            return allproducts;
        }

    //find product
//    public List<Object[]> searchproduct(String keyword) {
//        if (p_repository.findByp_name(keyword).isEmpty()) {
//            throw new ItemNotFoundException(keyword);
//        }
//        System.out.println(keyword);
//        return p_repository.findByp_name(keyword);
//    }
    public Optional<product> findProduct(Integer P_id){
        return p_repository.findById(P_id);
    }



    //add product
    public void addproduct (product p) {
        p_repository.save(  p);
    }

//    }
@Transactional
public void updateProduct(Integer P_id, product p) {
    Optional<product> existingProductOptional = p_repository.findById(P_id);
    if (existingProductOptional.isPresent()) {
        product existingProduct = existingProductOptional.get();
        existingProduct.setP_name(p.getP_name());
        existingProduct.setP_amt(p.getP_amt());
        existingProduct.setP_day(p.getP_day());
        existingProduct.setP_price(p.getP_price());
        existingProduct.setS_code(p.getS_code());
        existingProduct.setC_code(p.getC_code());
        p_repository.save(existingProduct);  // 저장합니다
    } else {
        throw new RuntimeException("Product not found with id: " + P_id);
    }
}

    //delete product
    public void deleteproduct(Integer P_id){
        p_repository.deleteById(P_id);
    }




}
