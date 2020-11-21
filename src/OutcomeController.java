import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class OutcomeController {

    public RadioButton singleButton;
    public RadioButton doubleButton;
    public RadioButton tripleButton;
    public RadioButton homeRunButton;
    public RadioButton walkButton;
    public RadioButton outButton;

    public void initialize() {
        ToggleGroup outcomeToggle = new ToggleGroup();
        singleButton.setToggleGroup(outcomeToggle);
        doubleButton.setToggleGroup(outcomeToggle);
        tripleButton.setToggleGroup(outcomeToggle);
        homeRunButton.setToggleGroup(outcomeToggle);
        walkButton.setToggleGroup(outcomeToggle);
        outButton.setToggleGroup(outcomeToggle);
    }

    public void submit() {
        
    }
}
