package org.Medical.data.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

    @Data
    @Document
    @NoArgsConstructor
    @AllArgsConstructor

    public class User{
        @Id
        private String id;
        private String email;
        private String password;
        private String role;
    }

