package com.haui.studentmanagement.convert;

import com.haui.studentmanagement.dto.ClassDto;
import com.haui.studentmanagement.dto.ClassTeacherDto;
import com.haui.studentmanagement.dto.ManagementScoreDto;
import com.haui.studentmanagement.dto.MessageDto;
import com.haui.studentmanagement.dto.SchoolDto;
import com.haui.studentmanagement.dto.StudentClassDto;
import com.haui.studentmanagement.dto.StudentDto;
import com.haui.studentmanagement.dto.StudentSubjectDto;
import com.haui.studentmanagement.dto.SubjectDto;
import com.haui.studentmanagement.dto.TeacherDto;
import com.haui.studentmanagement.dto.UserDto;
import com.haui.studentmanagement.model.Class;
import com.haui.studentmanagement.model.ClassTeacher;
import com.haui.studentmanagement.model.ManagementScore;
import com.haui.studentmanagement.model.Message;
import com.haui.studentmanagement.model.School;
import com.haui.studentmanagement.model.Student;
import com.haui.studentmanagement.model.StudentClass;
import com.haui.studentmanagement.model.StudentSubject;
import com.haui.studentmanagement.model.Subject;
import com.haui.studentmanagement.model.Teacher;
import com.haui.studentmanagement.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    // Class
    public Class toClass(ClassDto classDto) {
        Class clasz = new Class();
        clasz.setName(classDto.getName());

        return clasz;
    }

    public Class toClass(Class clasz, ClassDto classDto) {
        clasz.setName(classDto.getName());

        return clasz;
    }

    public ClassDto toClassDto(Class clasz) {
        ClassDto classDto = new ClassDto();
        classDto.setName(clasz.getName());
        classDto.setId(clasz.getId());
        classDto.setCreatedBy(clasz.getCreatedBy());
        classDto.setCreatedDate(clasz.getCreatedDate());
        classDto.setModifiedBy(clasz.getModifiedBy());
        classDto.setModifiedDate(clasz.getModifiedDate());

        List<Long> classTeachers = new ArrayList<>();
        List<Long> managementScores = new ArrayList<>();
        List<Long> studentclass = new ArrayList<>();

        if (clasz.getClassTeachers() != null) {
            for (ClassTeacher t : clasz.getClassTeachers()) {
                classTeachers.add(t.getId());
            }
        }
        if (clasz.getManagementScores() != null) {
            for (ManagementScore m : clasz.getManagementScores()) {
                managementScores.add(m.getId());
            }
        }
        if (clasz.getStudentClasss() != null) {
            for (StudentClass s : clasz.getStudentClasss()) {
                studentclass.add(s.getId());
            }
        }

        classDto.setClassTeachers(classTeachers);
        classDto.setManagementScores(managementScores);
        classDto.setStudentClasss(studentclass);

        return classDto;
    }

    //ClassTeacher
    public ClassTeacher toClassTeacher(ClassTeacherDto classTeacherDto) {
        ClassTeacher classTeacher = new ClassTeacher();
        classTeacher.setYear(classTeacherDto.getYear());

        return classTeacher;
    }

    public ClassTeacher toClassTeacher(ClassTeacher classTeacher, ClassTeacherDto classTeacherDto) {
        classTeacher.setYear(classTeacherDto.getYear());

        return classTeacher;
    }

    public ClassTeacherDto toClassTeacherDto(ClassTeacher classTeacher) {
        ClassTeacherDto classTeacherDto = new ClassTeacherDto();
        classTeacherDto.setYear(classTeacher.getYear());
        classTeacherDto.setId(classTeacher.getId());
        if (classTeacher.getClasz() != null) {
            classTeacherDto.setClassId(classTeacher.getClasz().getId());
        }
        if (classTeacher.getTeacher() != null) {
            classTeacherDto.setTeacherId(classTeacher.getTeacher().getId());
        }

        return classTeacherDto;
    }

    //ManagementScore
    public ManagementScore toManagementScore(ManagementScoreDto managementScoreDto) {
        ManagementScore managementScore = new ManagementScore();
        managementScore.setDiemHeSo1Ky1(managementScoreDto.getDiemHeSo1Ky1());
        managementScore.setDiemHeSo1Ky2(managementScoreDto.getDiemHeSo1Ky2());
        managementScore.setDiemHeSo2Ky1(managementScoreDto.getDiemHeSo2Ky1());
        managementScore.setDiemHeSo2Ky2(managementScoreDto.getDiemHeSo2Ky2());
        managementScore.setDiemHocKy1(managementScoreDto.getDiemHocKy1());
        managementScore.setDiemHocKy2(managementScoreDto.getDiemHocKy2());
        managementScore.setCreatedBy(managementScoreDto.getCreatedBy());
        managementScore.setModifiedBy(managementScoreDto.getModifiedBy());
        managementScore.setCommentInClass(managementScoreDto.getCommentInClass());
        managementScore.setYear(managementScoreDto.getYear());

        return managementScore;
    }

    public ManagementScore toManagementScore(ManagementScore managementScore, ManagementScoreDto managementScoreDto) {
        managementScore.setDiemHeSo1Ky1(managementScoreDto.getDiemHeSo1Ky1());
        managementScore.setDiemHeSo1Ky2(managementScoreDto.getDiemHeSo1Ky2());
        managementScore.setDiemHeSo2Ky1(managementScoreDto.getDiemHeSo2Ky1());
        managementScore.setDiemHeSo2Ky2(managementScoreDto.getDiemHeSo2Ky2());
        managementScore.setDiemHocKy1(managementScoreDto.getDiemHocKy1());
        managementScore.setDiemHocKy2(managementScoreDto.getDiemHocKy2());
        managementScore.setAvgScore(managementScoreDto.getAvgScore());
        managementScore.setRank(managementScoreDto.getRank());
        managementScore.setModifiedBy(managementScoreDto.getModifiedBy());
        managementScore.setCommentInClass(managementScoreDto.getCommentInClass());

        return managementScore;
    }

    public ManagementScoreDto toManagementScoreDto(ManagementScore managementScore) {
        ManagementScoreDto managementScoreDto = new ManagementScoreDto();
        managementScoreDto.setDiemHeSo1Ky1(managementScore.getDiemHeSo1Ky1());
        managementScoreDto.setDiemHeSo1Ky2(managementScore.getDiemHeSo1Ky2());
        managementScoreDto.setDiemHeSo2Ky1(managementScore.getDiemHeSo2Ky1());
        managementScoreDto.setDiemHeSo2Ky2(managementScore.getDiemHeSo2Ky2());
        managementScoreDto.setDiemHocKy1(managementScore.getDiemHocKy1());
        managementScoreDto.setDiemHocKy2(managementScore.getDiemHocKy2());
        managementScoreDto.setAvgScore(managementScore.getAvgScore());
        managementScoreDto.setRank(managementScore.getRank());
        managementScoreDto.setCommentInClass(managementScore.getCommentInClass());
        managementScoreDto.setCommentInTest(managementScore.getCommentInTest());
        managementScoreDto.setYear(managementScore.getYear());
        managementScoreDto.setId(managementScore.getId());
        managementScoreDto.setCreatedBy(managementScore.getCreatedBy());
        managementScoreDto.setCreatedDate(managementScore.getCreatedDate());
        managementScoreDto.setModifiedBy(managementScore.getModifiedBy());
        managementScoreDto.setModifiedDate(managementScore.getModifiedDate());
        if (managementScore.getClasz() != null) {
            managementScoreDto.setClassId(managementScore.getClasz().getId());
        }
        if (managementScore.getSubject() != null) {
            managementScoreDto.setSubjectId(managementScore.getSubject().getId());
        }
        if (managementScore.getTeacher() != null) {
            managementScoreDto.setTeacherId(managementScore.getTeacher().getId());
        }
        if (managementScore.getStudent() != null) {
            managementScoreDto.setStudentId(managementScore.getStudent().getId());
        }

        return managementScoreDto;
    }

    //Message
    public Message toMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setDetail(messageDto.getDetail());
        message.setCreatedBy(messageDto.getCreatedBy());
        message.setModifiedBy(messageDto.getModifiedBy());
        message.setToAccount(messageDto.getToAccount());

        return message;
    }

    public Message toMessage(Message message, MessageDto messageDto) {
        message.setDetail(messageDto.getDetail());
        message.setCreatedBy(messageDto.getCreatedBy());
        message.setModifiedBy(messageDto.getModifiedBy());
        message.setToAccount(messageDto.getToAccount());

        return message;
    }

    public MessageDto toMessageDto(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setDetail(message.getDetail());
        messageDto.setCreatedBy(message.getCreatedBy());
        messageDto.setModifiedBy(message.getModifiedBy());
        messageDto.setCreatedDate(message.getCreatedDate());
        messageDto.setModifiedDate(message.getModifiedDate());
        messageDto.setId(message.getId());
        messageDto.setTimeMessage(message.getTimeMessage());
        messageDto.setToAccount(message.getToAccount());
        if (message.getTeacher() != null) {
            messageDto.setTeacherId(message.getTeacher().getId());
        }
        if (message.getUser() != null) {
            messageDto.setUserId(message.getUser().getId());
        }

        return messageDto;
    }

    //School
    public School toSchool(SchoolDto schoolDto) {
        School school = new School();
        school.setAddress(schoolDto.getAddress());
        school.setFoundedYear(schoolDto.getFoundedYear());
        school.setName(schoolDto.getName());

        return school;
    }

    public School toSchool(School school, SchoolDto schoolDto) {
        school.setAddress(schoolDto.getAddress());
        school.setFoundedYear(schoolDto.getFoundedYear());
        school.setName(schoolDto.getName());

        return school;
    }

    public SchoolDto toSchoolDto(School school) {
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setAddress(school.getAddress());
        schoolDto.setFoundedYear(school.getFoundedYear());
        schoolDto.setName(school.getName());
        schoolDto.setId(school.getId());
        schoolDto.setCreatedBy(school.getCreatedBy());
        schoolDto.setCreatedDate(school.getCreatedDate());
        schoolDto.setModifiedBy(school.getModifiedBy());
        schoolDto.setModifiedDate(school.getModifiedDate());
        List<Long> teachers = new ArrayList<>();
        List<Long> users = new ArrayList<>();

        if (school.getTeachers() != null) {
            for (Teacher t : school.getTeachers()) {
                teachers.add(t.getId());
            }
        }
        if (school.getUsers() != null) {
            for (User u : school.getUsers()) {
                users.add(u.getId());
            }
        }

        schoolDto.setTeachers(teachers);
        schoolDto.setUsers(users);

        return schoolDto;
    }

    //StudentClass
    public StudentClass toStudentClass(StudentClassDto studentClassDto) {
        StudentClass studentClass = new StudentClass();
        studentClass.setYear(studentClassDto.getYear());

        return studentClass;
    }

    public StudentClass toStudentClass(StudentClass studentClass, StudentClassDto studentClassDto) {
        studentClass.setYear(studentClassDto.getYear());

        return studentClass;
    }

    public StudentClassDto toStudentClassDto(StudentClass studentClass) {
        StudentClassDto studentClassDto = new StudentClassDto();
        studentClassDto.setYear(studentClass.getYear());
        studentClassDto.setId(studentClass.getId());
        if (studentClass.getClasz() != null) {
            studentClassDto.setClassId(studentClass.getClasz().getId());
        }
        if (studentClass.getStudent() != null) {
            studentClassDto.setStudentId(studentClass.getStudent().getId());
        }

        return studentClassDto;
    }

    //Student
    public Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setAddress(studentDto.getAddress());
        student.setBirthDate(studentDto.getBirthDate());
        student.setName(studentDto.getName());
        student.setGender(studentDto.getGender());

        return student;
    }

    public Student toStudent(Student student, StudentDto studentDto) {
        student.setAddress(studentDto.getAddress());
        student.setBirthDate(studentDto.getBirthDate());
        student.setName(studentDto.getName());
        student.setGender(studentDto.getGender());

        return student;
    }

    public StudentDto toStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setAddress(student.getAddress());
        studentDto.setBirthDate(student.getBirthDate());
        studentDto.setName(student.getName());
        studentDto.setGender(student.getGender());
        studentDto.setId(student.getId());
        studentDto.setCode(student.getCode());
        if(student.getUser()!= null){
            studentDto.setUserId(student.getUser().getId());
        }
        
        studentDto.setCreatedBy(student.getCreatedBy());
        studentDto.setCreatedDate(student.getCreatedDate());
        studentDto.setModifiedBy(student.getModifiedBy());
        studentDto.setModifiedDate(student.getModifiedDate());
        List<Long> managementScores = new ArrayList<>();
        List<Long> studentClasss = new ArrayList<>();
        List<Long> studentSubjects = new ArrayList<>();

        if (student.getManagementScores() != null) {
            for (ManagementScore m : student.getManagementScores()) {
                managementScores.add(m.getId());
            }
        }
        if (student.getStudentClass() != null) {
            for (StudentClass s : student.getStudentClass()) {
                studentClasss.add(s.getId());
            }
        }
        if (student.getStudentSubjects() != null) {
            for (StudentSubject s : student.getStudentSubjects()) {
                studentSubjects.add(s.getId());
            }
        }

        studentDto.setManagementScores(managementScores);
        studentDto.setStudentClass(studentClasss);
        studentDto.setStudentSubjects(studentSubjects);
        return studentDto;
    }

    //StudentSubject
    public StudentSubject toStudentSubject(StudentSubjectDto studentSubjectDto) {
        StudentSubject studentSubject = new StudentSubject();
        studentSubject.setYear(studentSubjectDto.getYear());

        return studentSubject;
    }

    public StudentSubject toStudentSubject(StudentSubject studentSubject, StudentSubjectDto studentSubjectDto) {
        studentSubject.setYear(studentSubjectDto.getYear());

        return studentSubject;
    }

    public StudentSubjectDto toStudentSubjectDto(StudentSubject studentSubject) {
        StudentSubjectDto studentSubjectDto = new StudentSubjectDto();
        studentSubjectDto.setYear(studentSubject.getYear());
        studentSubjectDto.setId(studentSubject.getId());
        if (studentSubject.getStudent() != null) {
            studentSubjectDto.setStudentId(studentSubject.getStudent().getId());
        }
        if (studentSubject.getSubject() != null) {
            studentSubjectDto.setSubjectId(studentSubject.getSubject().getId());
        }

        return studentSubjectDto;
    }

    //Subject
    public Subject toSubject(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());

        return subject;
    }

    public Subject toSubject(Subject subject, SubjectDto subjectDto) {
        subject.setName(subjectDto.getName());

        return subject;
    }

    public SubjectDto toSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setName(subject.getName());
        subjectDto.setId(subject.getId());
        subjectDto.setCreatedBy(subject.getCreatedBy());
        subjectDto.setCreatedDate(subject.getCreatedDate());
        subjectDto.setModifiedBy(subject.getModifiedBy());
        subjectDto.setModifiedDate(subject.getModifiedDate());
        List<Long> managementScores = new ArrayList<>();
        List<Long> studentSubjects = new ArrayList<>();
        List<Long> teachers = new ArrayList<>();

        if (subject.getManagementScore() != null) {
            for (ManagementScore m : subject.getManagementScore()) {
                managementScores.add(m.getId());
            }
        }
        if (subject.getStudentSubjects() != null) {
            for (StudentSubject s : subject.getStudentSubjects()) {
                studentSubjects.add(s.getId());
            }
        }
        if (subject.getTeachers() != null) {
            for (Teacher t : subject.getTeachers()) {
                teachers.add(t.getId());
            }
        }

        subjectDto.setManagementScore(managementScores);
        subjectDto.setStudentSubjects(studentSubjects);
        subjectDto.setTeachers(teachers);
        return subjectDto;
    }

    //Teacher
    public Teacher toTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPassword(teacherDto.getPassword());
        teacher.setTeacherName(teacherDto.getTeacherName());
        teacher.setGender(teacherDto.getGender());

        return teacher;
    }

    public Teacher toTeacher(Teacher teacher, TeacherDto teacherDto) {
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPassword(teacherDto.getPassword());
        teacher.setTeacherName(teacherDto.getTeacherName());
        teacher.setGender(teacherDto.getGender());

        return teacher;
    }

    public TeacherDto toTeacherDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setPassword(teacher.getPassword());
        teacherDto.setTeacherName(teacher.getTeacherName());
        teacherDto.setGender(teacher.getGender());
        teacherDto.setId(teacher.getId());
        teacherDto.setCreatedDate(teacher.getCreatedDate());
        teacherDto.setCreatedBy(teacher.getCreatedBy());
        teacherDto.setModifiedDate(teacher.getModifiedDate());
        teacherDto.setModifiedBy(teacher.getModifiedBy());
        List<Long> classTeachers = new ArrayList<>();
        List<Long> managementScores = new ArrayList<>();
        List<Long> messages = new ArrayList<>();

        if (teacher.getClassTeachers() != null) {
            for (ClassTeacher c : teacher.getClassTeachers()) {
                classTeachers.add(c.getId());
            }
        }
        if (teacher.getManagementScores() != null) {
            for (ManagementScore m : teacher.getManagementScores()) {
                managementScores.add(m.getId());
            }
        }
        if (teacher.getMessages() != null) {
            for (Message m : teacher.getMessages()) {
                messages.add(m.getId());
            }
        }
        if (teacher.getSchool() != null) {
            teacherDto.setSchoolId(teacher.getSchool().getId());
        }
        if (teacher.getSubject() != null) {
            teacherDto.setSubjectId(teacher.getSubject().getId());
        }

        teacherDto.setClassTeachers(classTeachers);
        teacherDto.setManagementScores(managementScores);
        teacherDto.setMessages(messages);
        return teacherDto;
    }

    //User
    public User toUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getUserName());
        user.setGender(userDto.getGender());
        user.setDefaultStudent(userDto.getDefaultStudent());

        return user;
    }

    public User toUser(User user, UserDto userDto) {
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getUserName());
        user.setGender(userDto.getGender());
        user.setDefaultStudent(userDto.getDefaultStudent());

        return user;
    }

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setUserName(user.getUserName());
        userDto.setGender(user.getGender());
        userDto.setDefaultStudent(user.getDefaultStudent());
        userDto.setId(user.getId());
        userDto.setCreatedBy(user.getCreatedBy());
        userDto.setCreatedDate(user.getCreatedDate());
        userDto.setModifiedBy(user.getModifiedBy());
        userDto.setModifiedDate(user.getModifiedDate());
        List<Long> messages = new ArrayList<>();
        List<Long> students = new ArrayList<>();

        if (user.getMessage() != null) {
            for (Message m : user.getMessage()) {
                messages.add(m.getId());
            }
        }
        if (user.getStudents()!= null) {
            for (Student s : user.getStudents()) {
                students.add(s.getId());
            }
        }
        if (user.getSchool() != null) {
            userDto.setSchoolId(user.getSchool().getId());
        }
        
        userDto.setStudents(students);
        userDto.setMessage(messages);
        return userDto;
    }

}
