
package com.haui.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends Base{
    private String name;
    
    @OneToMany(mappedBy = "subject")
    private List<StudentSubject> studentSubjects;
    
    @OneToMany(mappedBy = "subject")
    private List<ManagementScore> managementScore;
    
    @OneToMany(mappedBy = "subject")
    private List<Teacher> teachers;
}
