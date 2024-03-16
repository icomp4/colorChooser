package org.example.colorchooser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class HelloController {

    @FXML
    private Slider alphaSlider;

    @FXML
    private TextField alphaText;

    @FXML
    private Slider blueSlider;

    @FXML
    private TextField blueText;

    @FXML
    private Rectangle colorBox;

    @FXML
    private Slider greenSlider;

    @FXML
    private TextField greenText;

    @FXML
    private Slider redSlider;

    @FXML
    private TextField redText;

    @FXML
    public void initialize() {
        // binding sliders to their corresponding text fields
        bindSliderAndTextField(redSlider, redText);
        bindSliderAndTextField(greenSlider, greenText);
        bindSliderAndTextField(blueSlider, blueText);
        bindSliderAndTextField(alphaSlider, alphaText);

        ChangeListener<Number> colorChangeListener = (observable, oldValue, newValue) -> updateColorBox();
        redSlider.valueProperty().addListener((ChangeListener<? super java.lang.Number>) colorChangeListener);
        greenSlider.valueProperty().addListener((ChangeListener<? super java.lang.Number>) colorChangeListener);
        blueSlider.valueProperty().addListener((ChangeListener<? super java.lang.Number>) colorChangeListener);
        alphaSlider.valueProperty().addListener((ChangeListener<? super java.lang.Number>) colorChangeListener);
    }

    private void bindSliderAndTextField(Slider slider, TextField textField) {
        // bidirectional binding so that if either value is changed, the other value / object updates
        textField.textProperty().bindBidirectional(slider.valueProperty(), new NumberStringConverter());
    }

    private void updateColorBox() {
        // getting the values from the sliders to create a new color object
        double red = redSlider.getValue();
        double green = greenSlider.getValue();
        double blue = blueSlider.getValue();
        double alpha = alphaSlider.getValue();

        // creating the new color with the values, color values are 1 -> 255 and alpha is 0.0 -> 1.0
        Color color = Color.rgb((int) red, (int) green, (int) blue, alpha);
        colorBox.setFill(color);
    }
}
