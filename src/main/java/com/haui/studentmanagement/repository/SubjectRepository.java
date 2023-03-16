
package com.haui.studentmanagement.repository;

import com.haui.studentmanagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Long>{
    
}
