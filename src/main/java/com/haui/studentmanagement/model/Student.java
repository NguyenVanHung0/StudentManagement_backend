
package com.haui.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Base{
    private String name;
    
    private Date birthDate;
    
    private String address;
    
    private String code;
    
    private String gender;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "student")
    private List<ManagementScore> managementScores;
    
    @OneToMany(mappedBy = "student")
    private List<StudentSubject> studentSubjects;
    
    @OneToMany(mappedBy = "student")
    private List<StudentClass> studentClass;
    
}
