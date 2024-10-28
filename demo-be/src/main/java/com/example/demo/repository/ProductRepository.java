package com.example.demo.repository;

import com.example.demo.entity.Product;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = """
    select p.product_name as productName
    , b.brand_name as brandName
    , origin_price as originPrice
    , s.status_name as status
    , sc.sub_cate_Name as subCategory
    from product p join product_brand pb on p.id = pb.product_id
    				join brand b on pb.brand_id = b.id
    				join sub_category sc on p.subcate_id = sc.id
    				join status s on p.status_id = s.id
""", nativeQuery = true)
    Page<ProductResponse> getProducts(Pageable pageable);
}
