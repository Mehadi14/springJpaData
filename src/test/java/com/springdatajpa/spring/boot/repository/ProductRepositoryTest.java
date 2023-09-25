package com.springdatajpa.spring.boot.repository;

import com.springdatajpa.spring.boot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

      @Test
      void saveMethod(){
         //create product
          Product product=new Product();
          product.setName("product 1");
          product.setDescription(" pr 2 descipt");
          product.setSku("1000abc");
          product.setPrice(new BigDecimal(1000));
          product.setActiveField(true);
          product.setImageUrl("product.png");

          //save product

      Product savedObject=    productRepository.save(product);

          //display product info
          System.out.println(savedObject.getId());
          System.out.println(savedObject.toString());
      }

      @Test
      void   updateusingSavemethod(){
          //find/retriver enetity by id
         Long id=1L;
         Product product = productRepository.findById(id).get();
          //update entiy info

           product.setName("updated_priduct_1");
           product.setDescription("dec update pr1!!");

          //save updated entity
          productRepository.save(product);
      }

      @Test
      void  findByid() {
          Long id = 1L;
          Product product = productRepository.findById(id).get();

      }
      @Test
      void saveAllMethod(){
          //create product
          Product product=new Product();
          product.setName("product 78");
          product.setDescription(" pr 22 descipt");
          product.setSku("2005abc");
          product.setPrice(new BigDecimal(2000));
          product.setActiveField(true);
          product.setImageUrl("product.2.png");

          //create product
          Product product3=new Product();
          product3.setName("p3rodumct 3");
          product3.setDescription(" pr 3j; descipt");
          product3.setSku("20600abcD");
          product3.setPrice(new BigDecimal(3000));
          product3.setActiveField(true);
          product3.setImageUrl("product.3.png");


          productRepository.saveAll(List.of(product3,product));
      }

      @Test
      void  findAllMethod(){


          List<Product> all = productRepository.findAll();

          all.forEach(p->{
              System.out.println(p.getName());
          });
      }

      @Test
      void detelebyIdmethod(){
           Long id=1L;

           productRepository.deleteById(id);
      }

      @Test
      void  deleteMethod(){
          Long id=4L;

        Product p=  productRepository.findById(id).get();

          productRepository.delete(p);
      }
      @Test
      void  deletAllmethod(){
//        productRepository.deleteAll();

          Product product=productRepository.findById(13L).get();
          Product product1=productRepository.findById(14L).get();

          productRepository.deleteAll(List.of(product1,product));
      }

      @Test
      void  countMethod(){

          Long count=productRepository.count();

          System.out.println(count);

      }

      @Test
      void  existMethod(){

          Long id=10L;

          boolean b = productRepository.existsById(id);

          System.out.println(b);
      }
      @Test
      void findByDateCreatedBetween(){

//          LocalDate startDateTime=LocalDate.of(2023,09,23,14,10,55);
//
//          2023-09-23 14:10:55
      }

      @Test
      void sortingByMultipleField(){
        String sortBy="name";
        String sortByDesc="description";
        String sortDir="desc";


          Sort  sortByName=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                  Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

          Sort  sortByDescp=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                  Sort.by(sortByDesc).ascending():Sort.by(sortByDesc).descending();

          Sort  groupBySort=sortByName.and(sortByDescp);

          List<Product> productList=productRepository.findAll(groupBySort);
          productList.forEach(p->{
               System.out.println(p);
          });


      }
}