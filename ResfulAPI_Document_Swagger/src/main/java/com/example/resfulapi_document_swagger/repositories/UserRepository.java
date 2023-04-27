package com.example.resfulapi_document_swagger.repositories;

import com.example.resfulapi_document_swagger.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
