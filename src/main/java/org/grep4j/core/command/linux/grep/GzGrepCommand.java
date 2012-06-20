package org.grep4j.core.command.linux.grep;

/**
 * GzGrepCommand is a LinuxCommand object that build the command to grep compressed files.
 * Example: "gunzip -c /tmp/server.log.gz | grep ERROR  
 * 
 * @author Marco Castigliego
 *
 */
public class GzGrepCommand extends AbstractGrepCommand {

	private static final String GUNZIP = "gunzip";
	private static final String GUNZIP_CONSOLE_OPTION = "-c";
	private static final String PIPE = "|";

	public GzGrepCommand(String expression, String file) {
		super(expression, file);
	}

	@Override
	public String getCommandToExecute() {
		command.append(GUNZIP);
		command.append(SPACE);
		command.append(GUNZIP_CONSOLE_OPTION);
		command.append(SPACE);
		command.append(file);
		command.append(SPACE);
		command.append(PIPE);
		command.append(SPACE);
		command.append(GREP_COMMAND);
		command.append(SPACE);
		command.append(SEP);
		command.append(expression);
		command.append(SEP);
		appendContextControl();
		return command.toString();
	}

}
