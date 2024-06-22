package com.vileladev.testmongorabbit.util;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponse<T> {

    public PageResponse(Page<T> page) {
        List<T> content = page.getContent();
        int pageNumber = page.getNumber();
        int pageSize = page.getSize();
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
    }
}
