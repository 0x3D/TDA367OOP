package com.teamjeaa.obpaint.model.commands;

/** Interface Command for CommandPattern */
public interface Command {

  /**
   * executeMethod that will execute our Commands tha tare defined in the Command package,
   * "com\teamjeaa\obpaint\model\commands"
   */
  void execute();

  /** Undo command that revert what initially was made by the defined command. */
  void undo();
}
