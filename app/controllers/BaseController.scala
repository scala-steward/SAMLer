package controllers

import controllers.common.TaskActions
import play.api.mvc.{AbstractController, ControllerComponents}

class BaseController(cc: ControllerComponents)
    extends AbstractController(cc)
    with TaskActions
