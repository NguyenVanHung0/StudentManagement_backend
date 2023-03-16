
package com.haui.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Base{
    private String teacherName;
    
    private String password;
    
    private String email;
    
    private String gender;
    
    @OneToMany(mappedBy = "teacher")
    private List<ClassTeacher> classTeachers;
    
    @OneToMany(mappedBy = "teacher")
    private List<Message> messages;
    
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
    
    @OneToMany(mappedBy = "teacher")
    private List<ManagementScore> managementScores;
}
