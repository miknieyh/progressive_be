package com.sanha.b_pj._progressive_be.web.dto;

import com.sanha.b_pj._progressive_be.domain.posts.Posts;
import com.sanha.b_pj._progressive_be.domain.posts.code.Progress;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostResponseDto {

    private Long id;

    private String num;

    private String project;

    private String item;

    private String jiraLink;

    private String department;

    private String productOwner;

    private String productManager;

    private Progress progress;

    private LocalDate planStartDate;

    private LocalDate planEndDate;

    private LocalDate designStartDate;

    private LocalDate designEndDate;

    private LocalDate developmentStartDate;

    private LocalDate developmentEndDate;

    private LocalDate openStartDate;

    private LocalDate openEndDate;

    public PostResponseDto(Posts entity){
        this.id = entity.getId();
        this.num = entity.getNum();
        this.project = entity.getProject();
        this.item = entity.getItem();
        this.jiraLink = entity.getJiraLink();
        this.department = entity.getDepartment();
        this.productOwner = entity.getProductOwner();
        this.productManager = entity.getProductManager();
        this.progress = entity.getProgress();
        this.planStartDate = entity.getPlanStartDate();
        this.planEndDate = entity.getPlanEndDate();
        this.designStartDate = entity.getDesignStartDate();
        this.designEndDate = entity.getDesignEndDate();
        this.developmentStartDate = entity.getDevelopmentStartDate();
        this.developmentEndDate = entity.getDevelopmentEndDate();
        this.openStartDate = entity.getOpenStartDate();
        this.openEndDate = entity.getOpenEndDate();
    }
}
