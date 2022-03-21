module io.github.dbc.collections {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.dbc.collections to javafx.fxml;
    exports io.github.dbc.collections;
}