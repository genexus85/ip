package Gene.command;

import Gene.task.Event;
import Gene.GeneException;
import Gene.task.TaskList;

/**
 * Represents a command to add events to the task list.
 */
public class EventCommand {

    /**
     * Execute the event command, adding the event task into the user task list.
     *
     * @param command User input of the event command.
     * @param taskList User list of tasks.
     * @throws GeneException if there is any formatting issues
     */
    public static void execute(String command, TaskList taskList) throws GeneException {
        String[] parts = command.replaceFirst("\\S+", "").split("/");
        if (parts.length < 3) {
            throw new GeneException("Invalid event format." + System.lineSeparator() + "Use Format: event <Task Description> /from <Date> /to <Date>");
        }
        Event newEvent = new Event(parts[0].trim(), parts[1].replace("from", "").trim()
                , parts[2].replace("to", "").trim());
        taskList.addTask(newEvent);
    }
}
