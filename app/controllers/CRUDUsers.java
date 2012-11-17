package controllers;

import models.User;
import play.mvc.*;

@CRUD.For(User.class)
public class CRUDUsers extends CRUD {
}
