package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void sayHello(@Required String myName, String message) {
        if (validation.hasErrors()) {
            validation.keep();
            index();
        }

        try {
            //throw new Exception();
        } catch(Exception e) {
            flash.error("予期せぬエラーが発生しました。");
            params.flash();
            index();
        }

        User user = User.findOrCreate(myName);
        Post post = new Post(message, user);
        post.save();

        List<Post> posts = Post.findAll();


        session.put("logged", myName);

        render(myName, posts, user);
    }

}