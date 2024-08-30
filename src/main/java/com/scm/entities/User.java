package com.scm.entities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity
@Table(name="users") //this is how we can give name opf our choice to the table

@Getter
@Setter
@NoArgsConstructor     //all these 5 we will be able to use bcz of lombok dependency
@AllArgsConstructor
@Builder

public class User {
    @Id  //to mark userId as primary key
    private String userId;

    @Column(name = "user_name", nullable = false) //to rename the column name and it should be mentioned....user can't leave this empty
    private String name;

    @Column(unique = true,nullable = false) //email should be unique
    private String email;
    private String password;

    @Column(length = 100)
    private String about;
    @Column(length = 100)
    private String profilePic;

    private String phoneNumber;
    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    //self,gooogle,facebook,github
    private Providers provider=Providers.SELF;
    private String providerUserId;
//cascade means ki jab user delete hoga to delete ho jayenge uske contact detail mtlb automate ho jayenge Cascading relationships are designed to automate actions on associated entities. They ensure that changes made to a parent entity are propagated to its child 
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true) //jab                  //one to many mapping is used bcz one user can have multiple contacts
    private List<Contact> contacts=new ArrayList<>();
}
