package seedu.intrack.logic.commands;

import static seedu.intrack.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.intrack.model.Model.PREDICATE_SHOW_ALL_INTERNSHIPS;

import java.util.ArrayList;
import java.util.List;

import seedu.intrack.commons.core.Messages;
import seedu.intrack.commons.core.index.Index;
import seedu.intrack.logic.commands.exceptions.CommandException;
import seedu.intrack.model.Model;
import seedu.intrack.model.internship.Internship;
import seedu.intrack.model.internship.Task;

/**
 * Deletes a Task from the selected Internship.
 */
public class DeleteTaskCommand extends Command {

    public static final String COMMAND_WORD = "deltask";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes the task identified by the index number used "
            + "in the displayed list of the selected internship application.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_TASK_SUCCESS = "Deleted task: %1$s";

    private final Index index;

    /**
     * @param index Index of the task to be deleted
     */
    public DeleteTaskCommand(Index index) {
        requireAllNonNull(index);

        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Internship> lastShownList = model.getSelectedInternship();
        if (lastShownList.size() != 1) {
            throw new CommandException(Messages.MESSAGE_NO_INTERNSHIP_SELECTED);
        }
        Internship internshipToEdit = lastShownList.get(0);

        List<Task> copyTasks = internshipToEdit.getTasks();
        if (index.getZeroBased() >= copyTasks.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_INTERNSHIP_DISPLAYED_INDEX);
        }
        List<Task> editedTasks = new ArrayList<>(copyTasks);
        editedTasks.remove(index.getZeroBased());

        Internship editedInternship = new Internship(internshipToEdit.getName(), internshipToEdit.getPosition(),
                internshipToEdit.getStatus(), internshipToEdit.getPhone(), internshipToEdit.getEmail(),
                internshipToEdit.getAddress(), editedTasks, internshipToEdit.getTags(), internshipToEdit.getRemark());

        model.setInternship(internshipToEdit, editedInternship);
        model.updateFilteredInternshipList(PREDICATE_SHOW_ALL_INTERNSHIPS);

        return new CommandResult(String.format(MESSAGE_DELETE_TASK_SUCCESS, editedInternship));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DeleteTaskCommand)) {
            return false;
        }

        DeleteTaskCommand e = (DeleteTaskCommand) other;

        return index.equals(e.index);
    }

}
