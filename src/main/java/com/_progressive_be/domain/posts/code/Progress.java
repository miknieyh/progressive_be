package com.sanha.b_pj._progressive_be.domain.posts.code;

import lombok.Getter;

@Getter
public enum Progress {
    예정,
    요구사항_분석,
    설계,
    구현,
    오픈,
    운영,
    완료,
    이슈,
    보류
}
