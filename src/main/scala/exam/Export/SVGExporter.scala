package exam.Export

import exam.Displayable._

import java.io.{BufferedWriter, File, PrintWriter}

class SVGExporter(path: String, scaleFactor: Int = 1) extends Exporter {
  override def export(displayable: Displayable): Unit = {
    val newDisplay = displayable.scale(scaleFactor)
    val pw = new PrintWriter(new File(path))
    pw.write(
      s"""<svg width ="${newDisplay.width}" height="${newDisplay.height}" xmlns="http://www.w3.org/2000/svg" >
         |${convertToString(displayable)}
         |</svg>
         |""".stripMargin)
    pw.close()
  }

  private def convertToString(displayable: Displayable): String = {
    displayable match {
      case y: Dialog =>
        val x = y.scale(scaleFactor)
        var base =
          s"""<rect height="${x.height}" width="${x.width}" x="${x.x}" y="${x.y}" stroke-width="$scaleFactor" stroke="#000" fill="#ccc"/>
             |
             |<rect height="80" width="${x.width}" x="${x.x}" y="${x.y}" stroke-width="$scaleFactor" stroke="#000" fill="#fff"/>
             |""".stripMargin + convertToString(y.getLabel)

        for (e <- y.components)
          base = base + convertToString(e)

        base

      case y: Button =>
        val x = y.scale(scaleFactor).asInstanceOf[Button]
        s"""
           |<rect height="${x.height}" width="${x.width}" x="${x.x}" y="${x.y}" stroke-width="$scaleFactor" stroke="#000" fill="#fff"/>
           |""".stripMargin + convertToString(y.getLabel)

      case y: InputBox =>
        val x = y.scale(scaleFactor)
        s"""
           |<rect height="${x.height}" width="${x.width}" x="${x.x}" y="${x.y}" stroke-width="$scaleFactor" stroke="#000" fill="#fff"/>
           |""".stripMargin

      case y: Label =>
        val x = y.scale(scaleFactor).asInstanceOf[Label]
        s"""
           |<text font-family="Helvetica" font-size="${x.fontSize}" x="${x.x}" y="${x.y}">${x.text}</text>
           |""".stripMargin

      case _ => throw new IllegalArgumentException("not supported type")
    }
  }

}
