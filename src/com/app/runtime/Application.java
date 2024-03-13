package com.app.runtime;
import com.app.models.ConverterModel;
import com.app.views.View;
import com.app.controller.*;
public class Application {
	public static void main(String[] args) {
        
		ConverterModel model = new ConverterModel();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.start();
        
    }
}
