package org.scoula.todo.domain;

import lombok.Builder;

@Builder
public class TodoVO {
    private Long id;
    private String title;
    private String description;
    private Boolean done;
    private String userId;

    // 기본 생성자
    public TodoVO() {}

    // 모든 필드를 인자로 받는 생성자
    public TodoVO(Long id, String title, String description, Boolean done, String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.userId = userId;
    }

    // toString
    @Override
    public String toString() {
        return "TodoVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", userId='" + userId + '\'' +
                '}';
    }

    // Getter, Setter
    // id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // done
    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    // userid
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    // Builder 패턴 구현
    public static class Builder {
        private Long id;
        private String title;
        private String description;
        private Boolean done;
        private String userId;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder done(Boolean done) {
            this.done = done;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public TodoVO build() {
            return new TodoVO(id, title, description, done, userId);
        }
    }



}


