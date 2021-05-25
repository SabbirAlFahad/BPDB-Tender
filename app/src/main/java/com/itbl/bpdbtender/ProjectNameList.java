package com.itbl.bpdbtender;

public class ProjectNameList {

    private String projectName,projectId;

    public ProjectNameList(String projectName, String projectId) {
        this.projectName = projectName;
        this.projectId = projectId;
    }



    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


}
