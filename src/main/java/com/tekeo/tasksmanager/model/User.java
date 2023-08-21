package com.tekeo.tasksmanager.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="users")
public class User {
	@Id
    private String userID;
    private String fname;
    private String lname;
    private String password;
    private String email;
    private String userName;

    @DBRef
    private List<Task> task = new ArrayList<>();

}
