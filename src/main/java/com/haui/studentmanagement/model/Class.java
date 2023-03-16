
package com.haui.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Class extends Base{
    private String name;
    
    @OneToMany(mappedBy = "clasz")
    private List<StudentClass> studentClasss;
    
    @OneToMany(mappedBy = "clasz")
    private List<ManagementScore> managementScores;
    
    @OneToMany(mappedBy = "clasz")
    private List<ClassTeacher> classTeachers;
    
    
}
