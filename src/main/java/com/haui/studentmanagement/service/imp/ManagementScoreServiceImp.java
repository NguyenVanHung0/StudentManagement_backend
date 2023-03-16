package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.ManagementScoreDto;
import com.haui.studentmanagement.model.ManagementScore;
import com.haui.studentmanagement.model.Class;
import com.haui.studentmanagement.model.Student;
import com.haui.studentmanagement.model.Subject;
import com.haui.studentmanagement.model.Teacher;
import com.haui.studentmanagement.repository.ClassRepository;
import com.haui.studentmanagement.repository.ManagementScoreRepository;
import com.haui.studentmanagement.repository.StudentRepository;
import com.haui.studentmanagement.repository.SubjectRepository;
import com.haui.studentmanagement.repository.TeacherRepository;
import com.haui.studentmanagement.service.ManagementScoreService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementScoreServiceImp implements ManagementScoreService {

    @Autowired
    ManagementScoreRepository managementScoreRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    Mapper mapper;

    @Override
    public ManagementScoreDto createManagementScore(ManagementScoreDto managementScoreDto) {
        ManagementScore managementScore = mapper.toManagementScore(managementScoreDto);
        managementScore.setCreatedDate(new Date());
        Class clasz = classRepository.findById(managementScoreDto.getClassId()).orElse(null);
        Student student = studentRepository.findById(managementScoreDto.getStudentId()).orElse(null);
        Subject subject = subjectRepository.findById(managementScoreDto.getSubjectId()).orElse(null);
        Teacher teacher = teacherRepository.findById(managementScoreDto.getTeacherId()).orElse(null);

        if (clasz == null) {
            throw new NoSuchElementException("Khong tim thay lop");
        }
        if (student == null) {
            throw new NoSuchElementException("Khong tim thay hoc sinh");
        }
        if (subject == null) {
            throw new NoSuchElementException("Khong tim thay mon hoc");
        }
        if (teacher == null) {
            throw new NoSuchElementException("Khong tim thay giao vien");
        }

        managementScore.setStudent(student);
        managementScore.setSubject(subject);
        managementScore.setClasz(clasz);
        managementScore.setTeacher(teacher);

        if (managementScoreDto.getRank() == null) {
            float avg = ((managementScoreDto.getDiemHeSo1Ky1()
                    + managementScoreDto.getDiemHeSo2Ky1() * 2
                    + managementScoreDto.getDiemHocKy1() * 3) / 6
                    + (managementScoreDto.getDiemHeSo1Ky2()
                    + managementScoreDto.getDiemHeSo2Ky2() * 2
                    + managementScoreDto.getDiemHocKy2() * 3) / 3) / 3;

            managementScore.setAvgScore(avg);
            if (avg >= 8) {
                managementScore.setRank("Giỏi");
            } else if (avg >= 6.5) {
                managementScore.setRank("Khá");
            } else if (avg >= 5) {
                managementScore.setRank("Trung bình");
            } else if (avg >= 3.5) {
                managementScore.setRank("Yếu");
            } else {
                managementScore.setRank("Kém");
            }
        }
        managementScoreRepository.save(managementScore);

        return mapper.toManagementScoreDto(managementScore);
    }

    @Override
    public List<ManagementScoreDto> getManagementScoreByStudentClassId(Long studentId, Long classId) {
        List<ManagementScore> managementScore = managementScoreRepository.getManagementScoreByStudentClassId(studentId, classId);
        List<ManagementScoreDto> result = new ArrayList<>();
        if (managementScore == null) {
            throw new NoSuchElementException("Khong tim thay ket qua");
        }

        for (ManagementScore m : managementScore) {
            result.add(mapper.toManagementScoreDto(m));
        }

        return result;
    }

    @Override
    public ManagementScoreDto getManagementScoreBySubjectStudentClassId(Long studentId, Long subjectId, Long classId) {
        ManagementScore managementScore = managementScoreRepository.getManagementScoreByStudentSubjectClassId(studentId, subjectId, classId);
        if (managementScore == null) {
            throw new NoSuchElementException("Khong tim thay ket qua");
        }
        return mapper.toManagementScoreDto(managementScore);
    }

    @Override
    public List<ManagementScoreDto> getManagementScoreByTeacherClassIdAndyear(Long teacherId, Long classId, int year) {
        List<ManagementScore> managementScores = managementScoreRepository.getManagementScoreByTeacherClassIdAndYear(teacherId, classId, year);
        List<ManagementScoreDto> result = new ArrayList<>();
        if (managementScores == null) {
            throw new NoSuchElementException("Khong tim thay ban ghi nao");
        }
        for (ManagementScore m : managementScores) {
            result.add(mapper.toManagementScoreDto(m));
        }

        return result;
    }

    @Override
    public ManagementScoreDto updateManagementScore(Long id, ManagementScoreDto managementScoreDto) {
        ManagementScore managementScore = managementScoreRepository.findById(id).orElse(null);
        if(managementScore == null){
            throw new NoSuchElementException("Khong tim thay ban ghi");
        }
        else{
            managementScore = mapper.toManagementScore(managementScore, managementScoreDto);
        }
        
        managementScore.setModifiedDate(new Date());
        
        managementScoreRepository.save(managementScore);

        return mapper.toManagementScoreDto(managementScore);
    }

}
