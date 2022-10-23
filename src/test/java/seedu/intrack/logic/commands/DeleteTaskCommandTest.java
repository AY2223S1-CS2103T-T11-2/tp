package seedu.intrack.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.intrack.testutil.TypicalIndexes.INDEX_FIRST_INTERNSHIP;
import static seedu.intrack.testutil.TypicalIndexes.INDEX_SECOND_INTERNSHIP;

import org.junit.jupiter.api.Test;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code DeleteTaskCommand}.
 */
public class DeleteTaskCommandTest {
    @Test
    public void equals() {
        DeleteTaskCommand deletetaskFirstCommand = new DeleteTaskCommand(INDEX_FIRST_INTERNSHIP);
        DeleteTaskCommand deletetaskSecondCommand = new DeleteTaskCommand(INDEX_SECOND_INTERNSHIP);

        // same object -> returns true
        assertTrue(deletetaskFirstCommand.equals(deletetaskFirstCommand));

        // same values -> returns true
        DeleteTaskCommand deletetaskFirstCommandCopy = new DeleteTaskCommand(INDEX_FIRST_INTERNSHIP);
        assertTrue(deletetaskFirstCommand.equals(deletetaskFirstCommandCopy));

        // different types -> returns false
        assertFalse(deletetaskFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deletetaskFirstCommand.equals(null));

        // different internship -> returns false
        assertFalse(deletetaskFirstCommand.equals(deletetaskSecondCommand));
    }
}
