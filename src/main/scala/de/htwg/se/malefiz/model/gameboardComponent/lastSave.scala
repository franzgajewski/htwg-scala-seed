/*
Class: lastSave.scala

Beschreibung:
Hier werden informationen des letzten Zuges gespeichert.

 */

package de.htwg.se.malefiz.model.gameboardComponent

import com.google.inject.Inject
import de.htwg.se.malefiz.model.cellComponent.Cell

case class lastSave @Inject()(lastFullDice: Int, lastDirectionOpposite: String, lastCell: Cell) extends lastSaveInterface {
  def updateLastFullDice(newNum: Int): lastSave = copy(newNum, lastDirectionOpposite, lastCell)

  def updateLastDirection(newDic: String): lastSave = copy(lastFullDice, newDic, lastCell)

  def updatelastCell(newCel: Cell): lastSave = copy(lastFullDice, lastDirectionOpposite, newCel)
}
