module br.senac.sp {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.senac.sp to javafx.fxml;
    exports br.senac.sp;
}
