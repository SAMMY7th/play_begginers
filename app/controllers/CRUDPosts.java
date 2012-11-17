package controllers;

import models.Post;
import play.mvc.*;

@CRUD.For(Post.class)
public class CRUDPosts extends CRUD {
}
