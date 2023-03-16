
package com.haui.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.haui.studentmanagement.model.Class;


public interface ClassRepository extends JpaRepository<Class, Long>{
    
}
