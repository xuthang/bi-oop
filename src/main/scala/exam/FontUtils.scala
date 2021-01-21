package exam

import java.awt.Font
import java.awt.font.FontRenderContext
import java.awt.geom.AffineTransform

object FontUtils {
  val frc = new FontRenderContext(new AffineTransform(), true, true)

  def stringDimension(text: String, fontSize: Int): (Int, Int) = {
    val font = new Font("Helvetica", Font.PLAIN, fontSize)
    val bounds = font.getStringBounds(text, frc)
    (bounds.getWidth.toInt, bounds.getHeight.toInt)
  }
}
