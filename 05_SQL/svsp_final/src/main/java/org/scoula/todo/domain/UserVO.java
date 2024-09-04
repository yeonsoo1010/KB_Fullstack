package org.scoula.todo.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {
    private String id;
    private String password;
    private String name;
    private String role;
}
