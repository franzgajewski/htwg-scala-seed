package de.htwg.se.malefiz.controller

object GameStatus extends Enumeration {
  type GameStatus = Value
  type PlayerStatus = Value
  //type GameFigureStatus = Value

  val IDLE, READY1, READY2, PLAYER0, PLAYER1, PLAYER2, PLAYER3, PLAYER4, PLAYING, MOVING = Value

  val gameMap = Map[GameStatus, String](
    IDLE -> "Press p to add players",
    READY1 -> "Type start or press p to add more players",
    READY2 -> "Type start to play the Game",
    PLAYING -> "Press r to roll dice",
    MOVING -> "Press a,w,s,d to move")

  val playerMap = Map[PlayerStatus, String](
    PLAYER1 -> "Player 1 press r to roll dice",
    PLAYER2 -> "Player 2 press r to roll dice",
    PLAYER3 -> "Player 3 press r to roll dice",
    PLAYER4 -> "Player 4 press r to roll dice",
    PLAYER0 -> "hier steht grad nix"
  )

  //val gamefigureMap = Map[GameFigureStatus, String](
  //
  // )

  def gameMessage(gameStatus: GameStatus) = {
    gameMap(gameStatus)
  }

//  def playerMessage(playerStatus: PlayerStatus) = {
//    playerMap(playerStatus)
//  }
}