package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post extends Model {
    @ManyToOne
    public User user;

    public String message;

    public Post(String message, User user) {
        this.message = message;
        this.user = user;
    }
}
