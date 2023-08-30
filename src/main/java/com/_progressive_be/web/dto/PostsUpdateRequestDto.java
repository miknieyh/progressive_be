package com.sanha.b_pj._progressive_be.web.dto;

import com.sanha.b_pj._progressive_be.domain.posts.code.Progress;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
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

    @Builder
    public PostsUpdateRequestDto(String num, String project, String item, String jiraLink, String department, String productOwner, String productManager, Progress progress,
                                 LocalDate planStartDate, LocalDate planEndDate, LocalDate designStartDate, LocalDate designEndDate,
                                 LocalDate developmentStartDate, LocalDate developmentEndDate, LocalDate openStartDate, LocalDate openEndDate){
        this.num = num;
        this.project = project;
        this.item = item;
        this.jiraLink = jiraLink;
        this.department = department;
        this.productOwner = productOwner;
        this.productManager = productManager;
        this.progress = progress;
        this.planStartDate = planStartDate;
        this.planEndDate = planEndDate;
        this.designStartDate = designStartDate;
        this.designEndDate = designEndDate;
        this.developmentStartDate = developmentStartDate;
        this.developmentEndDate = developmentEndDate;
        this.openStartDate = openStartDate;
        this.openEndDate = openEndDate;
    }
}
