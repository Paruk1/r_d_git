package api;

import api.requestData.AssignmentForGroupData;
import api.requestData.ContentData;
import api.requestData.GroupData;
import api.requestData.StudentData;
import api.responseData.AssignmentForGroup;
import api.responseData.Content;
import api.responseData.Group;
import api.responseData.Student;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

public class ApiTest extends BaseTest {
    @Test
    public void studentsMethodsTest(){
        Student studentFirst = RestAssured.given()
                .body(new StudentData("Andriy","Parail"))
                .post("/students")
                .then().statusCode(200)
                .extract().as(Student.class);
        Assert.assertNotNull(studentFirst.id);

        Student studentSecond = RestAssured.given()
                .body(new StudentData("Sashsa","Pozenko"))
                .post("/students")
                .then().statusCode(200)
                .extract().as(Student.class);
        Assert.assertNotNull(studentSecond.id);

        Student studentThird = RestAssured.given()
                .body(new StudentData("Masha","Krivosheeva"))
                .post("/students")
                .then().statusCode(200)
                .extract().as(Student.class);
        Assert.assertNotNull(studentThird.id);

        Integer[] studentIds = {
                studentFirst.id,
                studentSecond.id,
                studentThird.id
        };

        Group group = RestAssured.given()
                .body(new GroupData("Footballers", studentIds))
                .post("/groups")
                .then().statusCode(200)
                .extract().as(Group.class);

        Student[] students = {
                studentFirst,
                studentSecond,
                studentThird
        };
        Assert.assertEquals(group.students,students);

        Content contentCreated = RestAssured.given()
                .body(new ContentData("Українська мова!"))
                .post("/content")
                .then().statusCode(200)
                .extract().as(Content.class);

        Content[] contentList = RestAssured.get("/content").as(Content[].class);

        if(Arrays.asList(contentList).contains(contentCreated)) assert true;
        else assert false;

        AssignmentForGroup[] assignmentForGroup = RestAssured.given()
                .body(new AssignmentForGroupData("group",String.valueOf(group.id),contentCreated.id))
                .post("/assignments").then().log().all().statusCode(200)
                .extract().as(AssignmentForGroup[].class);

        for (AssignmentForGroup assignment: assignmentForGroup) {
            Assert.assertEquals(String.valueOf(assignment.content_id),contentCreated.id);
        }
    }
}
