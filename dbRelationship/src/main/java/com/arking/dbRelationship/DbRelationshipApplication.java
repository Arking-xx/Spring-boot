package com.arking.dbRelationship;

import com.arking.dbRelationship.Entity.Customer;
import com.arking.dbRelationship.Entity.Order;
import com.arking.dbRelationship.Entity.Product.Category;
import com.arking.dbRelationship.Entity.Product.Product;
import com.arking.dbRelationship.Entity.student.Course;
import com.arking.dbRelationship.Entity.student.Student;
import com.arking.dbRelationship.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class DbRelationshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbRelationshipApplication.class, args);

    }

//    @Bean
//    @Transactional
//    CommandLineRunner run(CustomerRepository customerRepository){
//        return args -> {
//            Customer customer = new Customer();
//            customer.setName("don");
//            customer.setEmail("don@gmail.com");
//
//            Order order1 = new Order();
//            order1.setOrderDate(LocalDate.now());
//            order1.setTotal(new BigDecimal("199.00"));
//
//            Order order2 = new Order();
//            order2.setOrderDate(LocalDate.now());
//            order2.setTotal(new BigDecimal("160.00"));
//
//            Order order3 = new Order();
//            order2.setOrderDate(LocalDate.now());
//            order2.setTotal(new BigDecimal("499.00"));
//
//            customer.addOrder(order1);
//            customer.addOrder(order2);
//            customer.addOrder(order3);
//
//            customerRepository.save(customer);
//
//            Long id = 10L;
//
//            Customer saved = customerRepository.findByIdWithOrders(id).orElseThrow();
//            System.out.println("Customer: " + saved.getName());
//            saved.getOrders().forEach(o ->
//                    System.out.println("  Order #" + o.getId() + " - $" + o.getTotal())
//            );
//        };

//    @Bean
//    @Transactional
//    CommandLineRunner run(ProductRepository productRepository, CategoryRepository categoryRepository) {
//        return args -> {


//            Product iphone = new Product();
//            iphone.setName("Iphone 13 Pro Max");
//
//            Category phone = new Category();
//            phone.setName("Phone");
//
//
//            iphone.addCategories(phone);
//            productRepository.save(iphone);

//            Long id = 1L;
//            Product product = productRepository.findByIdWithCategories(id).orElseThrow();
//            System.out.println("Product: " + product.getName());
//            product.getCategories().forEach( c -> System.out.println(c.getName()) );


//        };

    @Bean
    @Transactional
    CommandLineRunner run(StudentRepository studentRepository, CourseRepository courseRepository) {
        return args -> {

//            Student pedro = new Student();
//            pedro.setStudentName("Pedro Pendoko");
//
//            Student mark = new Student();
//            mark.setStudentName("Mark Lester");
//
//            Course bscs = new Course();
//            bscs.setCourseName("Computer Science");
//
//            Course sw = new Course();
//            sw.setCourseName("Social work");
//
//            pedro.addCourse(sw);
//            mark.addCourse(bscs);
//
//            studentRepository.save(mark);
//            studentRepository.save(pedro);

            Long id = 2L;
            Student student = studentRepository.findStudentWithCourse(id).orElseThrow();
            System.out.println(student.getStudentName());
            student.getCourses().forEach( c -> System.out.println(c.getCourseName()));


        };

    }
}


