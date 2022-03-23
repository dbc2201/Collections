module io.github.dbc.collections {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.dbc.collections to javafx.fxml;
    exports io.github.dbc.collections;

    opens io.github.dbc.collections.controller to javafx.fxml;
    exports io.github.dbc.collections.controller;

    opens io.github.dbc.collections.model to javafx.fxml;
    exports io.github.dbc.collections.model;
}