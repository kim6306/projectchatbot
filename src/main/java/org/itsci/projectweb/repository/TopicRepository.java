//package org.itsci.projectweb.repository;
//
//import org.itsci.projectweb.model.Topic;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class TopicRepository extends CrudRepository<Topic,long> {
//    @Query("SELECT p FROM Product p WHERE " +
//            "p.name LIKE CONCAT('%',:query, '%')" +
//            "Or p.description LIKE CONCAT('%', :query, '%')")
//    List<Product> searchProducts(String query);
//}
