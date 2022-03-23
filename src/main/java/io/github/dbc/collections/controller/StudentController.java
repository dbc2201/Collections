package io.github.dbc.collections.controller;

import io.github.dbc.collections.model.Student;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Optional;

public class StudentController {

    @FXML
    public TextField createFirstNameTextField;
    @FXML
    public TextField createLastNameTextField;

    @FXML
    public Button createNewStudentButton;

    @FXML
    public ListView<Student> studentListView = new ListView<>();

    @FXML
    public Button loadStudentsButton;

    @FXML
    public TextField updateNameTextField;

    @FXML
    public TextField updateFirstNameTextField;

    @FXML
    public TextField updateLastNameTextField;

    @FXML
    public Button updateStudentButton;

    @FXML
    public Button searchButton;

    @FXML
    public Button createFakeStudentButton;

    @FXML
    public Button deleteStudentButton;

    @FXML
    public TextField deleteNameTextField;

    private boolean doesUserExist = false;

    @FXML
    public void createFakeStudent(ActionEvent actionEvent) {
        String firstName = "Random";
        String lastName = "Student";
        Student student = new Student(firstName, lastName);
        MainController.getStudentList().add(student);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("SUCCESS");
        alert.setContentText("Nobita added to the list");
        alert.show();
    }

    private Student searchedStudent;

    @FXML
    private boolean searchName(ActionEvent actionEvent) {
        String firstName = updateNameTextField.getText().split(",\\s")[0];
        String lastName = updateNameTextField.getText().split(",\\s")[1];

        boolean doesUserExist = MainController.getStudentList().stream()
                .anyMatch(
                        student -> student.getFirstName().equals(firstName)
                                && student.getLastName().equals(lastName)
                );

        if (doesUserExist) {
            Optional<Student> existingStudent = MainController.getStudentList().stream()
                    .filter(student -> student.getFirstName().equals(firstName) &&
                            student.getLastName().equals(lastName))
                    .findFirst();

            if (existingStudent.isPresent()) {
                // load the details fo the text fields
                Student student = existingStudent.get();
                searchedStudent = student;
                updateFirstNameTextField.setText(student.getFirstName());
                updateLastNameTextField.setText(student.getLastName());
            }
        }

        return doesUserExist;
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
            MainController.getStudentList().add(student);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("SUCCESS");
            alert.setContentText(firstName + " added to the list!");
            alert.show();
        }
    }

    // read
    @FXML
    public void readAllStudentsFromList(ActionEvent actionEvent) {
        studentListView.setItems(FXCollections.observableArrayList(MainController.getStudentList()));
        studentListView.setEditable(true);
        studentListView.setPrefSize(100.0, 100.0);
    }

    private boolean searchNameInList(String firstName, String lastName) {
        return doesUserExist = MainController.getStudentList()
                .stream()
                .anyMatch(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName));
    }

    // update
    @FXML
    public void updateStudentDetailsInList(ActionEvent actionEvent) {
        String name = updateNameTextField.getText();
        String firstName = name.split(",\\s")[0];
        String lastName = name.split(",\\s")[1];

        if (!searchNameInList(firstName, lastName)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Student Not Found");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("SUCCESS");
            alert.setContentText(firstName + " found in the list");
            alert.show();
            doesUserExist = true;
        }
        if (doesUserExist) {
            searchedStudent.setFirstName(updateFirstNameTextField.getText());
            searchedStudent.setLastName(updateLastNameTextField.getText());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("SUCCESS");
            alert.setContentText("Student Details Modified Successfully!");
            alert.show();
        }
    }

    // delete
    @FXML
    public void deleteStudentFromList(ActionEvent actionEvent) {
        String name = updateNameTextField.getText();
        String firstName = name.split(",\\s")[0];
        String lastName = name.split(",\\s")[1];

        if (!searchNameInList(firstName, lastName)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Student Not Found");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("SUCCESS");
            alert.setContentText(firstName + " found in the list");
            alert.show();
            doesUserExist = true;
        }

        if (doesUserExist) {
            boolean result = MainController.getStudentList().remove(searchedStudent);
            Alert alert;
            if (result) {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESS");
                alert.setContentText("Student removed from list!");
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("ERROR!");
            }
            alert.show();
        }
    }
}
