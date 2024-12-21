package ForoHub.Blog.Domain.DTOs;


import java.util.List;

import org.springframework.data.domain.Page;

public record PageableDTO(List<ResponseDTO> content) {
    public static PageableDTO fromPage(Page<ResponseDTO> page) {
        return new PageableDTO(page.getContent());
    }
}