
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
@Table(name = "school")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class School extends Base{
    private String name;
    
    private String address;
    
    private String foundedYear;
    
    @OneToMany(mappedBy = "school")
    private List<User> users;
    
    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;
}
