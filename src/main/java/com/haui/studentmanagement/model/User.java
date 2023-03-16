
package com.haui.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Base{
    
    private String userName;
    
    private String password;
    
    private String email;
    
    private String gender;
    
    private Long defaultStudent;
    
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
    
    @OneToMany(mappedBy = "user")
    private List<Student> students;
    
    @OneToMany(mappedBy = "user")
    private List<Message> message;
}
