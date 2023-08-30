package com.sanha.b_pj._progressive_be.domain.posts;

import com.sanha.b_pj._progressive_be.domain.posts.code.Progress;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUM")
    private String num;

    @Column(name = "PROJECT")
    private String project;

    @Column(name = "ITEM")
    private String item;

    @Column(name = "JIRA_LINK")
    private String jiraLink;

    @Column(name="DEPARTMENT")
    private String department;

    @Column(name = "PRODUCT_OWNER")
    private String productOwner;

    @Column(name = "PRODUCT_MANAGER")
    private String productManager;

    @Column(name = "PROGRESS")
    @Enumerated(EnumType.STRING)
    private Progress progress;

    @Column(name = "PLAN_START_DATE")
    private LocalDate planStartDate;

    @Column(name = "PLAN_END_DATE")
    private LocalDate planEndDate;

    @Column(name = "DESIGN_START_DATE")
    private LocalDate designStartDate;

    @Column(name = "DESIGN_END_DATE")
    private LocalDate designEndDate;

    @Column(name = "DEVELOPMENT_START_DATE")
    private LocalDate developmentStartDate;

    @Column(name = "DEVELOPMENT_END_DATE")
    private LocalDate developmentEndDate;

    @Column(name = "OPEN_START_DATE")
    private LocalDate openStartDate;

    @Column(name = "OPEN_END_DATE")
    private LocalDate openEndDate;

    @Builder
    public Posts(String num,String project,String item,String jiraLink,String department,String productOwner,String productManager, Progress progress,
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

    public void update(String num,String project,String item,String jiraLink,String department,String productOwner,String productManager, Progress progress,
                       LocalDate planStartDate, LocalDate planEndDate, LocalDate designStartDate, LocalDate designEndDate,
                       LocalDate developmentStartDate, LocalDate developmentEndDate, LocalDate openStartDate, LocalDate openEndDate) {
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
