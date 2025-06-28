package org.gfg.Spring_Minor.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 50)
    String name;

    @Column(unique = true, nullable = false, length = 50)
    String email;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER) //here we are making this as early fetch because whatever the Author we store in Redis and again if we call the same Author from redis it will cause error due to it can't retrieve the data about books in redis due to lazy fetch(default). so we made it as early initialization so that while storing the Author in redis itself it will store along with books information..
//    @JsonIgnore
    @JsonIgnoreProperties(value = "author")
    List<Book> books;

    @CreationTimestamp
    Date createdOn;

    @UpdateTimestamp
    Date updatedOn;
}