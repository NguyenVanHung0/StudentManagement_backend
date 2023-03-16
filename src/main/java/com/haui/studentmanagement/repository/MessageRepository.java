
package com.haui.studentmanagement.repository;

import com.haui.studentmanagement.model.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepository extends JpaRepository<Message, Long>{
    @Query(value = "select * from message where user_id = ?1", nativeQuery = true)
    List<Message> getListMessageByUserId(Long userId);
    
    @Query(value = "select * from message where teacher_id = ?1", nativeQuery = true)
    List<Message> getListMessageByTeacherId(Long userId);
    
    @Query(value = "select * from message where to_account = ?1", nativeQuery = true)
    List<Message> getListMessageByToAccount(Long toAccount);
}
