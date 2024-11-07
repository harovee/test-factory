package com.example.demo.service.impl;

import com.example.demo.entity.Brand;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductBrand;
import com.example.demo.entity.Status;
import com.example.demo.entity.SubCategory;
import com.example.demo.model.request.AddProductRequest;
import com.example.demo.model.request.UpdateProductRequest;
import com.example.demo.model.response.ProductFormResponse;
import com.example.demo.model.response.ProductResponse;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.SubCateRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final StatusRepository statusRepository;
    private final BrandRepository brandRepository;

    private final SubCateRepository subCateRepository;

    @Override
    public ResponseEntity<?> getProduct(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>("Danh sach rong", HttpStatus.BAD_REQUEST);
        }
        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Product p : productPage.getContent()) {
            List<String> brandNames = new ArrayList<>();
            for (ProductBrand pb : p.getListProductBrand()) {
                brandNames.add(pb.getBrand().getBrandName());
            }

            ProductResponse productResponse = new ProductResponse() {
                @Override
                public Long getId() {
                    return p.getId();
                }

                @Override
                public String getProductName() {
                    return p.getProductName();
                }

                @Override
                public List<String> getBrandName() {
                    return brandNames;
                }

                @Override
                public String getSubCategory() {
                    return p.getSubCategory().getSubCateName();
                }

                @Override
                public Float getOriginPrice() {
                    return p.getOriginPrice();
                }

                @Override
                public String getStatus() {
                    return p.getStatus() == null ? "": p.getStatus().getStatusName();
                }
            };
            productResponseList.add(productResponse);
        }

        return new ResponseEntity<>(new PageImpl<>(productResponseList, pageable, productPage.getTotalElements()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addProduct(AddProductRequest request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setOriginPrice(request.getOriginPrice());
        product.setSellPrice(request.getSellPrice());
        product.setColor(request.getColor());
        product.setQuantity(request.getQuantity());
//        Status status = statusRepository.findById(request.getStatusId()).get();
//        product.setStatus(status);
        Brand brand = brandRepository.findById(request.getBrandId()).get();

        ProductBrand productBrand = new ProductBrand();
        productBrand.setBrand(brand);
        productBrand.setProduct(product);
        List<ProductBrand> productBrandList = new ArrayList<>();
        productBrandList.add(productBrand);
        product.setListProductBrand(productBrandList);

        SubCategory subCategory = subCateRepository.findById(request.getSubCategoryId()).get();
        product.setSubCategory(subCategory);
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateProduct(Long id, UpdateProductRequest request) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setProductName(request.getProductName());
            product.setSellPrice(request.getSellPrice());
            product.setOriginPrice(request.getOriginPrice());
            product.setColor(request.getColor());
            product.setQuantity(request.getQuantity());

            Brand brand = brandRepository.findById(request.getBrandId()).get();
            if (product.getListProductBrand() != null && !product.getListProductBrand().isEmpty()) {
                product.getListProductBrand().get(0).setBrand(brand);
            }else{
                ProductBrand productBrand = new ProductBrand();
                productBrand.setBrand(brand);
                productBrand.setProduct(product);
                List<ProductBrand> productBrandList = new ArrayList<>();
                productBrandList.add(productBrand);
                product.setListProductBrand(productBrandList);
            }

            SubCategory subCategory = subCateRepository.findById(request.getSubCategoryId()).get();
            product.setSubCategory(subCategory);

            Status status = statusRepository.findById(request.getStatusId()).get();
            product.setStatus(status);

            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepository.delete(product);
            return new ResponseEntity<>("Deleted"+id, HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return new ResponseEntity<>(convertToProductFormResponse(product) ,HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
    }

    private ProductFormResponse convertToProductFormResponse(Product product) {
        Long brandId = (product.getListProductBrand() != null && !product.getListProductBrand().isEmpty())
                ? product.getListProductBrand().get(0).getId()
                : null;
        Long subCategoryId = (product.getSubCategory() != null) ? product.getSubCategory().getId() : null;
        Long statusId = (product.getStatus() != null) ? product.getStatus().getId() : null;

        return new ProductFormResponse() {
            @Override
            public Long getId() {
                return product.getId();
            }

            @Override
            public String getProductName() {
                return product.getProductName();
            }

            @Override
            public String getColor() {
                return product.getColor();
            }

            @Override
            public Long getQuantity() {
                return product.getQuantity();
            }

            @Override
            public Float getSellPrice() {
                return product.getSellPrice();
            }

            @Override
            public Float getOriginPrice() {
                return product.getOriginPrice();
            }

            @Override
            public Long getBrandId() {
                return brandId;
            }

            @Override
            public Long getSubCategoryId() {
                return subCategoryId;
            }

            @Override
            public Long getStatusId() {
                return statusId;
            }
        };
    }
}
