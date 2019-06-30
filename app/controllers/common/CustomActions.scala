package controllers.common

import play.api.mvc.{Action, AnyContent, BaseController, BodyParser, Request, Result}
import zio.{DefaultRuntime, Task}

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

trait CustomActions {
  self: BaseController =>

  protected val runtime: DefaultRuntime = new DefaultRuntime {}

  implicit val ec: ExecutionContextExecutor = ExecutionContext.global

  def addDefaultHeaders(result: Result): Result =
    result.withHeaders("Cache-Control" -> "no-cache, max-age=0, must-revalidate, no-store")

  def TaskAction(
    block: Request[AnyContent] => Task[Result]
  ): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    runtime
      .unsafeRunToFuture(block(request))
      .map(addDefaultHeaders)
  }

  def TaskAction[A](bodyParser: BodyParser[A])(
    block: Request[A] => Task[Result]
  ): Action[A] = Action.async(bodyParser) { implicit request: Request[A] =>
    runtime
      .unsafeRunToFuture(block(request))
      .map(addDefaultHeaders)
  }
}
