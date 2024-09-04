package org.scoula.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoVO {
    private Long id;
    private String title;
    private String description;
    private Boolean done;
    private String userId;

    public TodoVO(String title, String description, Boolean done, String userId) {
        this.title = title;
        this.description = description;
        this.done = done;
        this.userId = userId;
    }
}