package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="LoginUser")
public class User extends Model {
    @Required
    public String name;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    public List<Post> posts;

    public User(String name) {
        this.name = name;
    }

    public static User findOrCreate(String name) {
        User user = User.find("byName", name).first();
        if (user == null) {
            user = new User(name);
        }
        user.save();
        return user;
    }
}
