package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    @NotBlank
    private String projectName;

    @NotBlank
    private String projectCode;

    @NotNull
    private UserDTO assignedManager;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectStartDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectEndDate;

    @NotBlank
    private String projectDetail;

    private Status projectStatus;

    private int completeTaskCounts;  //new properties for Project Status Page
    private int unfinishedTaskCounts;

    public ProjectDTO(String projectName, String projectCode, UserDTO assignedManager, LocalDate projectStartDate, LocalDate projectEndDate, String projectDetail, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignedManager = assignedManager;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectDetail = projectDetail;
        this.projectStatus = projectStatus;
    }
}
