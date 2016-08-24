package com.amazon.cart1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.cart1.model.UserDetails;

@Repository
@Transactional
public interface UserDetailsDAO {
	public boolean save(UserDetails userDetails);
	public boolean update(UserDetails userDetails);
	public boolean delete(UserDetails userDetails);
	public UserDetails get(String id);
    public List<UserDetails> list();

}