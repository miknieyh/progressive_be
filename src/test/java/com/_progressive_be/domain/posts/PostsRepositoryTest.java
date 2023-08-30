package com.sanha.b_pj._progressive_be.domain.posts;

import com.sanha.b_pj._progressive_be.domain.posts.code.Progress;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void saveAndGet() {
        //given
        String num = "PJ0010";
        String project = "고객";
        String item = "Connectivity";
        String jiraLink = "JIRA.COM";
        String department = "연구";
        String productOwner = "홍길동";
        String productManager = "이순신";
        String progress = "구현";

        postsRepository.save(Posts.builder()
                .num(num)
                .project(project)
                .item(item)
                .jiraLink(jiraLink)
                .department(department)
                .productOwner(productOwner)
                .productManager(productManager)
                .progress(Progress.구현)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getNum()).isEqualTo(num);
        assertThat(posts.getProject()).isEqualTo(project);
        assertThat(posts.getJiraLink()).isEqualTo(jiraLink);
        assertThat(posts.getDepartment()).isEqualTo(department);
        assertThat(posts.getProductOwner()).isEqualTo(productOwner);
        assertThat(posts.getProductManager()).isEqualTo(productManager);
        assertThat(posts.getProgress().name()).isEqualTo(progress);
    }


}
