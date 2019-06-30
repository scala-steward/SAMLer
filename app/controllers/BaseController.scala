package controllers

import controllers.common.CustomActions
import play.api.libs.json.Writes
import play.api.mvc.{AbstractController, ControllerComponents, Result}

class BaseController(cc: ControllerComponents) extends AbstractController(cc) with CustomActions {
  def jsonOut[T](s: Status, o: T)(implicit tjs: Writes[T]): Result = s.apply(tjs.writes(o))
}
