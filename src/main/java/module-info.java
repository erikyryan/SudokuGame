module com.sudoku.javadesktopsudoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sudoku.domain to javafx.fxml;
    exports com.sudoku.domain;
    exports com.sudoku;
    opens com.sudoku to javafx.fxml;
    exports com.sudoku.userinterface;
    opens com.sudoku.userinterface to javafx.fxml;
    exports com.sudoku.buildlogic;
    opens com.sudoku.buildlogic to javafx.fxml;
}