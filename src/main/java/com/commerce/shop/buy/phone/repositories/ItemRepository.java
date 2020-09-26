package com.commerce.shop.buy.phone.repositories;

import com.commerce.shop.buy.phone.Schemas.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT i FROM Item  i where " + "(:#{#ref.shortName} =NULL OR i.shortName=:#{#ref.shortName} ) AND"
            + "(:#{#ref.longName}=NULL OR i.longName=:#{#ref.longName} ) AND"
            + "(:#{#ref.color}=NULL OR i.color=:#{#ref.color} ) AND"
            + "(:#{#ref.count}=0 OR i.count=:#{#ref.count} ) AND" + "(:#{#ref.upc}=NULL OR i.upc=:#{#ref.upc} ) AND"
            + "( :#{#ref.price}=0 OR i.price= :#{#ref.price} ) AND"
            + "( :#{#ref.description}=NULL OR i.description like %:#{#ref.description}% ) AND"
            + "( :#{#ref.currency}=NULL OR i.currency= :#{#ref.currency} )"

    )
    Item[] get(@Param("ref") Item aLIKE);
}
