package com.sanha.b_pj._progressive_be.web;

import com.sanha.b_pj._progressive_be.domain.posts.Posts;
import com.sanha.b_pj._progressive_be.domain.posts.PostsRepository;
import com.sanha.b_pj._progressive_be.domain.posts.code.Progress;
import com.sanha.b_pj._progressive_be.web.dto.PostsSaveRequestDto;
import com.sanha.b_pj._progressive_be.web.dto.PostsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_save() throws Exception {
        //given
        String num = "PJ0010";
        String project = "고객";
        String item = "Connectivity 연동";
        String jiraLink = "JIRA.COM";
        String department = "연구";
        String productOwner = "홍길동";
        String productManager = "이순신";
        String progress = "구현";

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .num(num)
                .project(project)
                .item(item)
                .jiraLink(jiraLink)
                .department(department)
                .productOwner(productOwner)
                .productManager(productManager)
                .progress(Progress.구현)
                .build();
        String url = "http://localhost:"+ port +"/v1/posts";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,requestDto,Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getNum()).isEqualTo(num);
        assertThat(all.get(0).getProject()).isEqualTo(project);
        assertThat(all.get(0).getItem()).isEqualTo(item);
        assertThat(all.get(0).getJiraLink()).isEqualTo(jiraLink);
        assertThat(all.get(0).getDepartment()).isEqualTo(department);
        assertThat(all.get(0).getProductOwner()).isEqualTo(productOwner);
        assertThat(all.get(0).getProductManager()).isEqualTo(productManager);
        assertThat(all.get(0).getProgress().name()).isEqualTo(progress);

    }

    @Test
    public void Post_update() throws Exception {
        //given
        String num = "PJ0010";
        String project = "고객";
        String item = "Connectivity 연동";
        String jiraLink = "JIRA.COM";
        String department = "연구";
        String productOwner = "홍길동";
        String productManager = "이순신";

        Posts savePosts = postsRepository.save(Posts.builder()
                .num(num)
                .project(project)
                .item(item)
                .jiraLink(jiraLink)
                .department(department)
                .productOwner(productOwner)
                .productManager(productManager)
                .progress(Progress.구현)
                .build());

        Long updateId = savePosts.getId();

        String expectedNum = "PJ0020";
        String expectedProject = "야놀자";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .num(expectedNum)
                .project(expectedProject)
                .build();

        String url = "http://localhost:"+port+"/v1/posts/"+updateId;

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();

        assertThat(all.get(0).getNum()).isEqualTo(expectedNum);
        assertThat(all.get(0).getProject()).isEqualTo(expectedProject);

    }


}
