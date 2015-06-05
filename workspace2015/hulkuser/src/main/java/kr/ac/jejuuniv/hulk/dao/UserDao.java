package kr.ac.jejuuniv.hulk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.hulk.model.User;

@Repository
public interface UserDao {

	List<User> findAll();

}
