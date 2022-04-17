module de.noltetrost.ps_rest_client {
    requires javafx.controls;
    requires javafx.fxml;
	requires transitive jakarta.ws.rs;
	requires transitive javafx.graphics;
	requires jakarta.xml.bind;

    opens de.noltetrost.ps_rest_client to javafx.fxml;
    opens model to javafx.base;
    
    exports de.noltetrost.ps_rest_client;
    exports model;
}
