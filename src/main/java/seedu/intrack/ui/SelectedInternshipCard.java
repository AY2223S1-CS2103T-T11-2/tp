package seedu.intrack.ui;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.intrack.model.internship.Internship;
import seedu.intrack.model.internship.Task;

/**
 * An UI component that displays information of a {@code Internship}.
 */
public class SelectedInternshipCard extends UiPart<Region> {

    private static final String FXML = "SelectedInternshipCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Internship internship;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label position;
    @FXML
    private FlowPane status;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tasks;
    @FXML
    private FlowPane tags;
    @FXML
    private Label remark;

    /**
     * Creates a {@code InternshipCode} with the given {@code Internship} to display.
     */
    public SelectedInternshipCard(Internship internship) {
        super(FXML);

        Label lab = new Label(internship.getStatus().toString());
        PseudoClass rejected = PseudoClass.getPseudoClass("rejected");
        lab.pseudoClassStateChanged(rejected, (internship.getStatus().toString()).equals("Rejected"));
        PseudoClass offered = PseudoClass.getPseudoClass("offered");
        lab.pseudoClassStateChanged(offered, (internship.getStatus().toString()).equals("Offered"));

        this.internship = internship;
        name.setText(internship.getName().fullName);
        position.setText(internship.getPosition().positionName);
        status.getChildren().add(lab);
        phone.setText(internship.getPhone().value);
        address.setText(internship.getAddress().value);
        email.setText(internship.getEmail().value);

        tasks.setMaxWidth(0);
        AtomicInteger count = new AtomicInteger();
        internship.getTasks().stream()
                .forEach(task -> {
                    Label temp = new Label(count.incrementAndGet() + ". " + task.taskName
                            + " at " + task.taskTime.format(Task.FORMATTER));
                    tasks.getChildren().add(temp);
                });

        internship.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
        remark.setText(internship.getRemark().value);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SelectedInternshipCard)) {
            return false;
        }

        // state check
        SelectedInternshipCard card = (SelectedInternshipCard) other;
        return internship.equals(card.internship);
    }
}
