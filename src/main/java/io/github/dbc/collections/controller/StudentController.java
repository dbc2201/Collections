package io.github.dbc.collections.controller;

import io.github.dbc.collections.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class StudentController {

    @FXML
    public TextField createFirstNameTextField;
    @FXML
    public TextField createLastNameTextField;

    @FXML
    public Button createNewStudentButton;

    private List<Student> studentList;

    public StudentController() {
        this.studentList = new ArrayList<>();
    }

    // create
    @FXML
    public void createNewStudentInList(ActionEvent actionEvent) {
        // get the string value for first name, and last name from the text fields
        String firstName = createFirstNameTextField.getText();
        String lastName = createLastNameTextField.getText();

        // check if the string is null or empty
        if (firstName == null || firstName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("First Name should not be empty!");
            alert.showAndWait();
        } else if (lastName == null || lastName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Last Name should not be empty!");
            alert.showAndWait();
        } else {
            Student student = new Student(firstName, lastName);
            studentList.add(student);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("SUCCESS");
            alert.setContentText(firstName + " added to the list!");
            alert.show();
        }
    }

    // read
    @FXML
    public void readAllStudentsFromList(ActionEvent actionEvent) {

    }

    // update
    @FXML
    public void updateStudentDetailsInList(ActionEvent actionEvent) {

    }

    // delete
    @FXML
    public void deleteStudentFromList(ActionEvent actionEvent) {

    }
}
