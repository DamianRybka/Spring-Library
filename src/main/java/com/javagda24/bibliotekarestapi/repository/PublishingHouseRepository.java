package com.javagda24.bibliotekarestapi.repository;

import com.javagda24.bibliotekarestapi.model.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Long> {
}
