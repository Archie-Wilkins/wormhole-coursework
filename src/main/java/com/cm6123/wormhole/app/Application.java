package com.cm6123.wormhole.app;

import com.cm6123.wormhole.GameLogic.Board;
import com.cm6123.wormhole.GameLogic.Square;
import com.cm6123.wormhole.dice.Dice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

// import java.util.Scanner;


public final class Application {
  /**
   * Create a logger for the class.
   */
  private static Logger logger = LoggerFactory.getLogger(Application.class);


  private Application() {
  }

  /**
   * main entry point.If args provided, result is displayed and program exists.
   * Otherwise, user is prompted for input.
   *
   * @param args command line args.
   */
  public static void main(final String[] args) {


    logger.info("Application Started with args:{}", String.join(",", args));

    UserInterface commandConsoleInterface = new UserInterface();
    commandConsoleInterface.playGame();



    logger.info("Application closing");
  }


}



