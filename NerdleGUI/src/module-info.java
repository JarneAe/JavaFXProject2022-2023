module be.kdg.nerdle {
    requires javafx.controls;
    requires MathParser.org.mXparser;
    requires com.google.gson;
    exports be.kdg.nerdle.model;
    exports be.kdg.nerdle;
    exports be.kdg.nerdle.model.jsonManager;
}