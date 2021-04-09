package de.htwg.se.malefiz

import de.htwg.se.malefiz.model.{Gameboard, Player}

object Malefiz {
  def main(args: Array[String]): Unit = {
    val student = Player("Your Name")
    println("Hello, " + student.name)

    val spielbrett = Gameboard()

    //spielbrett.initiating()

    spielbrett.update()
  }
}
