package io.github.dbc.collections.controller;

import io.github.dbc.collections.CRUDApplication;
import io.github.dbc.collections.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainController {
    @FXML
    public Button createNewStudentButton;

    @FXML
    public Button viewAllStudentsButton;

    @FXML
    public Button updateStudentInfoButton;

    @FXML
    public Button deleteStudentButton;

    @FXML
    private Label welcomeText;

    private static final List<Student> studentList = new LinkedList<>();

    public static List<Student> getStudentList() {
        return studentList;
    }

    @FXML

    public void createNewStudent(ActionEvent actionEvent) throws IOException {
        Stage createStudentStage = new Stage();
        FXMLLoader loader = new FXMLLoader(CRUDApplication.class.getResource("create-view.fxml"));
        Scene scene = new Scene(loader.load(), 400.0, 400.0);
        createStudentStage.setTitle("Create New Student");
        createStudentStage.setScene(scene);
        createStudentStage.show();
    }

    @FXML
    public void viewAllStudents(ActionEvent actionEvent) throws IOException {
        Stage viewAllStudentsStage = new Stage();
        FXMLLoader loader = new FXMLLoader(CRUDApplication.class.getResource("read-view.fxml"));
        Scene scene = new Scene(loader.load(), 400.0, 400.0);
        viewAllStudentsStage.setTitle("View All Students");
        viewAllStudentsStage.setScene(scene);
        viewAllStudentsStage.show();
    }

    @FXML
    public void updateStudentInfo(ActionEvent actionEvent) throws IOException {
        Stage updateStudentInfo = new Stage();
        FXMLLoader loader = new FXMLLoader(CRUDApplication.class.getResource("update-view.fxml"));
        Scene scene = new Scene(loader.load(), 400.0, 400.0);
        updateStudentInfo.setTitle("Update Student Info");
        updateStudentInfo.setScene(scene);
        updateStudentInfo.show();
    }

    @FXML
    public void deleteStudent(ActionEvent actionEvent) throws IOException {
        Stage deleteStudentStage = new Stage();
        FXMLLoader loader = new FXMLLoader(CRUDApplication.class.getResource("delete-view.fxml"));
        Scene scene = new Scene(loader.load(), 400.0, 400.0);
        deleteStudentStage.setTitle("Delete Student");
        deleteStudentStage.setScene(scene);
        deleteStudentStage.show();
    }

}