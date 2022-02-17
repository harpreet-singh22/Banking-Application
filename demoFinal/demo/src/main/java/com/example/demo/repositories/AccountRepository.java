package com.example.demo.repositories;

import com.example.demo.models.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Long> {
}
