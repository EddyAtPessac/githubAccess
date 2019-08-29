package com.wcs.githubacces.entities;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="githuber")
public class Githuber {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(name="github_id")
    private Long gitId;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="login")
    private String login;
    @Column(name="avatar_url")
    private String avatarUrl;



    public Githuber() {
    }

    public Githuber(Long gitId, String name, String email, String login, String avatarUrl) {
        this.gitId = gitId;
        this.name = name;
        this.email = email;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "Githuber{" +
                "id=" + id +
                ", gitId='" + gitId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }

    public Long getId() {   return id;   }

    //public void setId(Long id) { this.id = id;   }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getgitId() {
        return gitId;
    }

    public void setgitId(Long id) {
        this.gitId = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}

