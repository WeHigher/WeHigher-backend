package com.dongguk.ossdev.backend.domain;

import com.dongguk.ossdev.backend.dto.request.ReadingRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
public class Reading extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reading_id")
    private Long id;

    private int grade;

    private String semester;

    private String subject;

    private String title;

    // ========= mapping =========

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "school_record_id")
    private SchoolRecord schoolRecord;

    @Builder
    public Reading(int grade, String semester, String subject, String title, SchoolRecord schoolRecord) {
        this.grade = grade;
        this.semester = semester;
        this.subject = subject;
        this.title = title;
        this.schoolRecord = schoolRecord;
    }

    // ========= mapping method =========
    public void setSchoolRecord(SchoolRecord schoolRecord) {
        this.schoolRecord = schoolRecord;
        schoolRecord.getReadingList().add(this);
    }

    public void patch(ReadingRequestDto updateRequest) {
        Integer grade = updateRequest.getGrade();
        if (grade != null)
            this.grade = updateRequest.getGrade();
        if (updateRequest.getSemester() != null)
            this.semester = updateRequest.getSemester();
        if (updateRequest.getSubject() != null)
            this.subject = updateRequest.getSubject();
        if (updateRequest.getTitle() != null)
            this.title = updateRequest.getTitle();
    }
}
