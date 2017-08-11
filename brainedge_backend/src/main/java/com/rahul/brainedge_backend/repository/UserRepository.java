package com.rahul.brainedge_backend.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.brainedge_backend.entity.User;

@Repository("userRepository")
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
	
	/*@Autowired
	private SessionFactory session;
	
	public void save(User user) {
		session.getCurrentSession().persist(user);
	}*/
}
