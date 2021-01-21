package exam.Export

import exam.Displayable.Displayable

trait Exporter {
  def export(displayable: Displayable):Unit
}
