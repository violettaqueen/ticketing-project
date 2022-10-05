package com.cydeo.dto;

import com.cydeo.enums.Status;

import java.time.LocalDate;

public class ProjectDTO {

    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private String projectDetail;
    private Status projectStatus;
}
