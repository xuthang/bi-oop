package exam.Export
import exam.Displayable.Displayable

import java.io.BufferedWriter

class SVGExporter(writer:BufferedWriter) extends Exporter {
  override def export(displayable: Displayable): Unit = {
    //todo
    writer.write("")
  }

}
