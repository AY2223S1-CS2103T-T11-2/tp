package seedu.intrack.logic.commands;

import static seedu.intrack.model.Model.PREDICATE_SHOW_ALL_INTERNSHIPS;

import java.util.List;

import seedu.intrack.logic.commands.exceptions.CommandException;
import seedu.intrack.model.Model;
import seedu.intrack.model.internship.Internship;

/**
 * Sorts all the internships in the internship list by the dates and time of their respective tasks
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all the internships by either\n"
            + "a for ascending time, with internships containing tasks with the nearest dates at the top\n"
            + "or d for descending time, with internships containing tasks with the furthest dates at the top\n"
            + "Example: " + COMMAND_WORD + " a";

    public static final String SORT_COMMAND_CONSTRAINTS = "SORT must be either \"a\" to denote ASCENDING or "
            + "\"d\" to denote DESCENDING";

    public static final String MESSAGE_SUCCESS_A = "Sorted all internships in ascending order";

    public static final String MESSAGE_SUCCESS_D = "Sorted all internships in descending order";

    public static final String MISSING_TASKLIST = "One or more of the internships have no tasks! Cannot be sorted.";

    private final String orderType; //will be either A, a, D or d

    public SortCommand(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Internship> lastShownList = model.getSelectedInternship();
        for (int i = 0; i < lastShownList.size(); i++) {
            Internship internship = lastShownList.get(i);
            if (internship.isTaskListEmpty()) {
                throw new CommandException(MISSING_TASKLIST);
            }
        }
        if (orderType.equals("a")) {
            model.ascendSort();
            model.updateFilteredInternshipList(PREDICATE_SHOW_ALL_INTERNSHIPS);
            return new CommandResult(String.format(MESSAGE_SUCCESS_A, model.getFilteredInternshipList().size()));
        } else if (orderType.equals("d")) {
            model.descendSort();
            model.updateFilteredInternshipList(PREDICATE_SHOW_ALL_INTERNSHIPS);
            return new CommandResult(String.format(MESSAGE_SUCCESS_D, model.getFilteredInternshipList().size()));
        } else {
            throw new CommandException(SORT_COMMAND_CONSTRAINTS);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SortCommand)) {
            return false;
        }
        SortCommand e = (SortCommand) other;
        return orderType.equals(e.orderType);
    }

}
