package com.mathfacts.business;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUserNameAndPassword(String uname, String pwd);
}