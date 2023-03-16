
package com.haui.studentmanagement.repository;

import com.haui.studentmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
    
}
