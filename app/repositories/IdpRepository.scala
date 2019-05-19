package repositories

import javax.inject.Inject
import model.Idp
import scalaz.zio.Task

class IdpRepository @Inject()() {
  def getIdp(id: String, clientId: String): Task[Idp] = ???
}
