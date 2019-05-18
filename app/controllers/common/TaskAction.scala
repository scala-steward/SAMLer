package controllers.common

import play.api.mvc.{Action, AnyContent, BaseController, Request, Result}
import scalaz.zio.{DefaultRuntime, Task}

trait TaskAction {
  self: BaseController =>

  protected val runtime: DefaultRuntime = new DefaultRuntime {}

  def TaskAction(
      block: Request[_] => Task[Result]
  ): Action[AnyContent] = Action.async { implicit request: Request[_] =>
    runtime.unsafeRunToFuture(block(request))
  }
}
