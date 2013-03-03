package controllers;

import play.*;
import views.html.*;

import java.util.List;
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;

import models.*;

public class Application extends Controller {
  
//    public static Result index() {
//        return ok(index.render("Your new application is ready."));
//    }
  
  public static Result index() {
    // 1番目を保存
    Parent parent1 = new Parent();
    parent1.name = "新宿太郎";
    parent1.save();

    // 2番目を保存
    Parent parent2 = new Parent();
    parent2.name = "代々木太郎";
    parent2.save();

    // 3番目を保存
    Parent parent3 = new Parent();
    parent3.name = "原宿太郎";
    parent3.save();

    // 現在のParentを全検索して表示
    Finder<Long, Parent> finder = new Finder<Long, Parent>(Long.class,
            Parent.class);
    List<Parent> parents = finder.all();

    StringBuilder msg = new StringBuilder();
    for (Parent parent : parents) {
        msg.append(parent.toString()).append("\n");
    }
    return ok(msg.toString());
  }

  public static Result index2() {

    // 親1の作成
    Parent parent1 = new Parent();
    parent1.name = "渋谷太郎";

    // 子1の追加
    Child child1_1 = new Child();
    child1_1.name = "渋谷小太郎";
    parent1.children.add(child1_1);

    // 子2の追加
    Child child1_2 = new Child();
    child1_2.name = "渋谷小二郎";
    parent1.children.add(child1_2);

    // 親1の保存
    parent1.save();

    // 親2の作成
    Parent parent2 = new Parent();
    parent2.name = "恵比寿太郎";

    // 子1の追加
    Child child2_1 = new Child();
    child2_1.name = "恵比寿小太郎";
    parent2.children.add(child2_1);

    // 子2の追加
    Child child2_2 = new Child();
    child2_2.name = "恵比寿小二郎";
    parent2.children.add(child2_2);

    // 親2の保存
    parent2.save();

    // 現在のParentを全検索して表示
    Finder<Long, Parent> finder = new Finder<Long, Parent>(Long.class,
            Parent.class);
    List<Parent> parents = finder.all();

    StringBuilder msg = new StringBuilder();
    for (Parent parent : parents) {
      msg.append(parent.toString()).append("\n");
      // Child の表示
      for (Child child : parent.children){
        msg.append("   ").append(child.toString()).append("\n");
      }
    }
    return ok(msg.toString());
  }

}
