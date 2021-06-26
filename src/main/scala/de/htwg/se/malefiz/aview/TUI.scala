package de.htwg.se.malefiz.aview

import de.htwg.se.malefiz.controller.controllerComponent._
import scala.swing.Reactor

/** Malefiz as text-user-interface. Game gets displayed in the console.
 *
 *  @author sehirsig & franzgajewski
 */
case class TUI(controller: ControllerInterface) extends Reactor {
  listenTo(controller)

  /** Initialising of the current state. */
  var currentState:TUIState = IdleTUIState

  def processing(input: String): Unit = {
    currentState = currentState.processing(input: String)
  }

  reactions += {
    case event: RollDice => printTui; currentState = PlayingTUIState
    case event: Moving => printTui;currentState = MovingTUIState
    case event: ChooseFig => printStatus;currentState = ChooseGameFigTUIState
    case event: SettingUp => printStatus
    case event: StartUp => printStatus
    case event: StartGame => printStatus; currentState = PlayingTUIState
    case event: WonGame => printTui; currentState = WinnerTUIState; currentState.processing("")
    case event: GameReset => printStatus; currentState = IdleTUIState
    case event: GameSaved => printStatus;
    case event: GameLoaded => printStatus
  }

  /** Prints the game board. */
  def printTui: Unit = {
    println(controller.boardToString())
    println(GameStatus.gameMessage(controller.gameStatus))
  }

  /** Prints the game state. */
  def printStatus: Unit = {
    println(GameStatus.gameMessage(controller.gameStatus))
  }
}