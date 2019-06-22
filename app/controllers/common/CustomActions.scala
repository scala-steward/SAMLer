package controllers.common

import play.api.mvc.{Action, AnyContent, BaseController, Request, Result}
import zio.{DefaultRuntime, Task}

trait CustomActions {
  self: BaseController =>

  protected val runtime: DefaultRuntime = new DefaultRuntime {}

  def TaskAction(
      block: Request[_] => Task[Result]
  ): Action[AnyContent] = Action.async { implicit request: Request[_] =>
    runtime.unsafeRunToFuture(block(request))
  }
}
