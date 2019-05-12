package controllers.common

import controllers.BaseController
import play.api.mvc.{Action, ActionBuilder, AnyContent, Request, Result}
import scalaz.zio.{DefaultRuntime, Task}

object TaskAction extends ActionBuilder[Request] {

  protected val runtime: DefaultRuntime = new DefaultRuntime {}

  def TaskAction[A](
      block: Request[A] => Task[Result]
  )(implicit request: Request[A]): Action[AnyContent] = Action.async {
    runtime.unsafeRunToFuture(block(request))
  }
}
