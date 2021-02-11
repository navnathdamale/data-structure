package com.java.practice.design.structure.proxy;

public class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;

	private CommandExecutor commandExecutor;

	public CommandExecutorProxy(String userName, String password) {
		if (userName.equals("navnath") && password.equals("Admin@123")) {
			isAdmin = true;
		}
		commandExecutor = new CommandExecutorImpl();
	}

	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin) {
			commandExecutor.runCommand(cmd);
		} else {
			if (cmd.trim().startsWith("rm")) {
				throw new Exception("rm command is not allowed for non-admin users.");
			} else {
				commandExecutor.runCommand(cmd);
			}
		}
	}

}
