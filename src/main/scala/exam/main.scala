package exam

import exam.Displayable._
import exam.Export.SVGExporter

import java.io.{BufferedWriter, File, FileWriter}

object main extends App {
  println("hello world")

  val dialog = new Dialog(
    "Login Dialog",
    600, 300,
    List(new Label("Password:", 90, 180, 20),
      new Label("Username:", 90, 120, 20),
      new InputBox(270, 180, 270, 30),
      ButtonFactory.get("Login", 90, 300, 150, 60),
      ButtonFactory.get("Close", 360, 300, 150, 60),
    )
  )

  val writer = new BufferedWriter(new FileWriter(new File("dialog.svg")))
  val exporter = new SVGExporter(writer)
  exporter.export(dialog)
  writer.close()
}
